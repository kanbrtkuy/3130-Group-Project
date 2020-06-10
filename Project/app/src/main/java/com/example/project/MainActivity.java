package com.example.project;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Weekday
    private RelativeLayout day;

    //SQLite Helper class
    private DatabaseHelper databaseHelper = new DatabaseHelper
            (this, "database.db", null, 1);

    int currentCoursesNumber = 0;
    int maxCoursesNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tool bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Load data from data base
        loadData();
    }

    //Load data from database
    private void loadData() {
        ArrayList<Course> coursesList = new ArrayList<>(); //Course table
        SQLiteDatabase sqLiteDatabase =  databaseHelper.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from courses", null);
        if (cursor.moveToFirst()) {
            do {
                coursesList.add(new Course(
                        cursor.getString(cursor.getColumnIndex("course_name")),
                        cursor.getString(cursor.getColumnIndex("teacher")),
                        cursor.getString(cursor.getColumnIndex("class_room")),
                        cursor.getInt(cursor.getColumnIndex("day")),
                        cursor.getInt(cursor.getColumnIndex("class_start")),
                        cursor.getInt(cursor.getColumnIndex("class_end"))));
            } while(cursor.moveToNext());
        }
        cursor.close();

        //Use database data to create the graph
        for (Course course : coursesList) {
            createLeftView(course);
            createItemCourseView(course);
        }
    }

    //Save to database
    private void saveData(Course course) {
        SQLiteDatabase sqLiteDatabase =  databaseHelper.getWritableDatabase();
        sqLiteDatabase.execSQL
                ("insert into courses(course_name, teacher, class_room, day, class_start, class_end) " + "values(?, ?, ?, ?, ?, ?)",
                new String[] {course.getCourseName(),
                        course.getTeacher(),
                        course.getClassRoom(),
                        course.getDay()+"",
                        course.getStart()+"",
                        course.getEnd()+""}
                );
    }

    //Create left side layout
    private void createLeftView(Course course) {
        int endNumber = course.getEnd();
        if (endNumber > maxCoursesNumber) {
            for (int i = 0; i < endNumber-maxCoursesNumber; i++) {
                View view = LayoutInflater.from(this).inflate(R.layout.left_view, null);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(110,180);
                view.setLayoutParams(params);

                TextView text = view.findViewById(R.id.class_number_text);
                text.setText(String.valueOf(++currentCoursesNumber));

                LinearLayout leftViewLayout = findViewById(R.id.left_view_layout);
                leftViewLayout.addView(view);
            }
            maxCoursesNumber = endNumber;
        }
    }

    //Create mono graph
    private void createItemCourseView(final Course course) {
        int getDay = course.getDay();
        if ((getDay < 1 || getDay > 7)) {
            Toast.makeText(this, "Wrong weekday", Toast.LENGTH_LONG).show();
        } else if (course.getStart() > course.getEnd()) {
            Toast.makeText(this, "End time is earlier than start time", Toast.LENGTH_LONG).show();
        } else {
            int dayId = 0;
            switch (getDay) {
                case 1: dayId = R.id.monday; break;
                case 2: dayId = R.id.tuesday; break;
                case 3: dayId = R.id.wednesday; break;
                case 4: dayId = R.id.thursday; break;
                case 5: dayId = R.id.friday; break;
                case 6: dayId = R.id.saturday; break;
                case 7: dayId = R.id.weekday; break;
            }
            day = findViewById(dayId);

            int height = 180;
            final View v = LayoutInflater.from(this).inflate(R.layout.course_card, null); //Load the course layout
            v.setY(height * (course.getStart()-1)); //Course start and end
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
                    (ViewGroup.LayoutParams.MATCH_PARENT,(course.getEnd()-course.getStart()+1)*height - 8); //Course long
            v.setLayoutParams(params);
            TextView text = v.findViewById(R.id.text_view);
            text.setText(course.getCourseName() + "\n" + course.getTeacher() + "\n" + course.getClassRoom()); //Activities
            day.addView(v);
            //Press to remove
            v.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    v.setVisibility(View.GONE);//Hide
                    day.removeView(v);//Remove
                    SQLiteDatabase sqLiteDatabase =  databaseHelper.getWritableDatabase();
                    sqLiteDatabase.execSQL("delete from courses where course_name = ?", new String[] {course.getCourseName()});
                    return true;
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_courses:
                Intent intent = new Intent(MainActivity.this, AddCourseActivity.class);
                startActivityForResult(intent, 0);
                break;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0 && resultCode == Activity.RESULT_OK && data != null) {
            Course course = (Course) data.getSerializableExtra("course");
            //Left side view
            createLeftView(course);
            //Create the course graph
            createItemCourseView(course);
            //Save to database
            saveData(course);
        }
    }

}