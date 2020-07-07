package com.example.neoprojectver2;


import androidx.test.espresso.action.ViewActions;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.neoprojectver2.auth.Register;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@LargeTest
@RunWith(AndroidJUnit4ClassRunner.class)
public class RegisterTest {

    @Rule
    public ActivityTestRule<Register> mActivityTestRule = new ActivityTestRule<>(Register.class);

    @Test
    public void RegisterTest() {

        onView(withId(R.id.userName))
                .perform(click())
                .perform(typeText("hanwenz"));
        onView(withId(R.id.userEmail))
                .perform(click())
                .perform(typeText("barryindalhousie@gmail.com"));
        onView(withId(R.id.password))
                .perform(click())
                .perform(typeText("Dalcsci3130"));
        onView(withId(R.id.passwordConfirm))
                .perform(click())
                .perform(typeText("Dalcsci3130"));
        onView(withId(R.id.createAccount))
                .perform(ViewActions.closeSoftKeyboard())
                .perform(click());


    }
}
