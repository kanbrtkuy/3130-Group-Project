package com.example.neoprojectver2;


import com.example.neoprojectver2.model.Note;

import org.junit.Test;

import static org.junit.Assert.*;


public class NoteTest {
    // this is the unit test for get title
    @Test
    public void GetTitle() {
        Note n1 = new Note("ShortRun", "i will train this afternoon.");
        assertEquals(n1.getTitle().equals("ShortRun"),true);
    }

    // this is the unit test for get content
    @Test
    public void GetContent() {
        Note n1 = new Note("ShortRun", "i will train this afternoon.");
        assertEquals(n1.getContent().equals("i will train this afternoon."),true);

    }

    @Test

    public void InvalidGetTitle() {
        Note n1 = new Note("ShortRun", "i will train this afternoon.");
        assertEquals(n1.getTitle().equals("shortrun"),false);
    }


    @Test

    public void InvalidGetContent() {
        Note n1 = new Note("ShortRun", "i will train this afternoon.");
        assertEquals(n1.getContent().equals("i am lazy"),false);
    }

}



