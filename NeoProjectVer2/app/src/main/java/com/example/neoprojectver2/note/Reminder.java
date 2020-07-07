package com.example.neoprojectver2.note;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import com.example.neoprojectver2.MainActivity;
import com.example.neoprojectver2.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.SetOptions;

import org.w3c.dom.Document;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.Snapshot;

public class Reminder extends AppCompatActivity {
    private CalendarView calendar;
    private EditText reminder;
    private Button allSet;
    private String selectDate;

    FirebaseFirestore fStore;
    FirebaseUser user;
    FirebaseAuth fAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        calendar = findViewById(R.id.calendarView);
        reminder = findViewById(R.id.reminder_text);
        allSet = findViewById(R.id.save_reminder);

        fStore = FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();
        user = fAuth.getCurrentUser();

        selectDate = Calendar.getInstance().get(Calendar.YEAR)
                + String.valueOf(Calendar.getInstance().get(Calendar.MONTH))
                + Calendar.getInstance().get(Calendar.DATE);

        final String docId = getIntent().getStringExtra("scheduleId");

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                selectDate = year + Integer.toString(month) + dayOfMonth;
            }
        });
        final DocumentReference ref = fStore.collection("schedule").document(user.getUid()).
                collection("mySchedule").document(docId);
        ref.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    DocumentSnapshot document = task.getResult();
                    if(document.getData().containsKey(selectDate)){
                        reminder.setText((CharSequence) document.getData().get(selectDate));
                    }
                }
            }
        });

        allSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, Object> data = new HashMap<>();
                data.put(selectDate, reminder.getText().toString());
                ref.set(data, SetOptions.merge());
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}
