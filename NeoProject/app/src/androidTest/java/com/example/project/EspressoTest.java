package com.example.project;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class EspressoTest {
    @Test
    public void ValidLogin() {
        onView(R.id.mEmail)
                .perform(click())
                .perform(typeText("amoszhu@dal.ca"));
        onView(R.id.mPassword)
                .perform(click())
                .perform(typeText("ilove3130"));
        onView(R.id.mLoginBtn)
                .perform(click())
                .check(mActivityTestRule);

    }
}
