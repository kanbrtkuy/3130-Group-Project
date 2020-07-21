package com.example.neoprojectver2;


import android.content.DialogInterface;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;
import androidx.test.espresso.action.ViewActions;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.neoprojectver2.auth.Login;
import com.example.neoprojectver2.auth.Register;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static androidx.core.content.ContextCompat.startActivity;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

@LargeTest
@RunWith(AndroidJUnit4ClassRunner.class)
public class LoginTest {

    @Rule
    public ActivityTestRule<Login> mActivityTestRule = new ActivityTestRule<>(Login.class);

    @Test
    public void LoginTest() throws Exception {

        onView(withText("Its Ok"))
                .inRoot(withDecorView(not(is(mActivityTestRule.getActivity().getWindow().getDecorView()))))
                .perform(click());
        onView(withId(R.id.email))
                .perform(click())
                .perform(typeText("zhanghw0909@gmail.com"));
        onView(withId(R.id.lType))
                .perform(click())
                .perform(typeText("Coach"));
        onView(withId(R.id.lPassword))
                .perform(ViewActions.closeSoftKeyboard())
                .perform(click())
                .perform(typeText("Aaa12345"));
        onView(withId(R.id.loginBtn))
                .perform(ViewActions.closeSoftKeyboard())
                .perform(click());

    }


}