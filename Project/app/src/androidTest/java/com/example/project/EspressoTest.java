package com.example.a3130peoject;
import android.support.test.espresso.DataInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.espresso.Espresso;



import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;


@RunWith(AndroidJUnit4.class)
public class EspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void VaildInput() {
        Course c1 = new Course("ShortRun","Bob","a",5,1,2);
        onView(R.id.course_name)
                .perform(click())
                .perform(typeText("ShortRun"));
        onView(R.id.teacher_name)
                .perform(click())
                .perform(typeText("Bob"));
        onView(R.id.class_room)
                .perform(click())
                .perform(typeText("a"));
        onView(R.id.friday)
                .perform(click())
                .perform(typeText("5"));
        onView(R.id.classes_begin)
                .perform(click())
                .perform(typeText("1"));
        onView(R.id.classes_ends)
                .perform(click())
                .perform(typeText("2"));
        onView(R.id.button)
                .perform(click())
                .check(mActivityTestRule);
    }


    @Test
    public void InvaildInput() {
        Course c1 = new Course("ShortRun","Bob","a",5,1,2);
        onView(R.id.course_name)
                .perform(click())
                .perform(typeText("ShortRun"));
        onView(R.id.teacher_name)
                .perform(click())
                .perform(typeText("Bob"));
        onView(R.id.class_room)
                .perform(click())
                .perform(typeText("a"));
        onView(R.id.friday)
                .perform(click())
                .perform(typeText("4"));
        onView(R.id.classes_begin)
                .perform(click())
                .perform(typeText("1"));
        onView(R.id.classes_ends)
                .perform(click())
                .perform(typeText("2"));
        onView(R.id.button)
                .perform(click())
                .check(matches(withText("Wrong class day"));
    }



}
