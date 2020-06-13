package com.example.project;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UserAccountTest {

    @Test
    public void ValidPassword() {
        UserAccount u1 = new UserAccount("Amos", "amos123@dal.ca", "amos123");
        assertEquals(true, u1.PasswordLength());
    }

    @Test

    public void InValidPassword(){
        UserAccount u2 = new UserAccount("Amos1", "amos1231@dal.ca", "amos1");
        assertNotEquals(true, u2.PasswordLength());
    }

    @Test

    public void ValidEmail(){
        UserAccount u2 = new UserAccount("Amos1", "amos1231@dal.ca", "amos1");
        assertEquals(true, u2.ValidEmail());
    }


    @Test

    public void InValidEmail(){
        UserAccount u2 = new UserAccount("Amos1", "amos1231dal.ca", "amos1");
        assertNotEquals(true, u2.ValidEmail());
    }






}