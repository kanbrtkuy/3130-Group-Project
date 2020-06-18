package com.example.neoprojectver2;


import androidx.test.espresso.action.ViewActions;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.neoprojectver2.note.EditNote;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@LargeTest
@RunWith(AndroidJUnit4ClassRunner.class)
public class EditNoteTest {

    @Rule
    public ActivityTestRule<EditNote> mActivityTestRule = new ActivityTestRule<>(EditNote.class);

    @Test
    public void editNoteTest() {

        onView(withId(R.id.editNoteTitle))
                .perform(click())
                .perform(typeText("2020/06/17/Running"));
        onView(withId(R.id.editNoteContent))
                .perform(click())
                .perform(typeText("10km Running in 1 hour."));
        onView(withId(R.id.saveEditedNote))
                .perform(ViewActions.closeSoftKeyboard())
                .perform(click());

    }
}
