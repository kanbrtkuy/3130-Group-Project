package com.example.project;

import android.content.Context;
import android.view.KeyEvent;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.actionWithAssertions;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressKey;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.hamcrest.Matcher;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class AddscheduleTest {

    @Rule
    public ActivityScenarioRule<Addschedule> activityScenarioRule
            = new ActivityScenarioRule<Addschedule>(Addschedule.class);
    @Test

    // this is for vaild process of add schedule

    public void VaildAddProcess() {
        // Context of the app under test.
        onView(withId(R.id.add_note))
                .perform(ViewActions.closeSoftKeyboard())
                .perform(click());
    }

    @Test

    public void VaildBackProcess() {
        // Context of the app under test.
        onView(withId(R.id.back))
                .perform(ViewActions.closeSoftKeyboard())
                .perform(click());
    }






}