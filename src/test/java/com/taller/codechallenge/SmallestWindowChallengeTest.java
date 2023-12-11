package com.taller.codechallenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmallestWindowChallengeTest {

    @Test
    public void shouldReturnSmallestWindowSuccessfully() {
        String inputString = "this is a test string";
        String pattern = "tist";
        String expected = "t stri";
        assertEquals(expected, SmallestWindowChallenge.findSmallestWindow(inputString, pattern));

        inputString = "geeksforgeeks";
        pattern = "ork";
        expected = "ksfor";
        assertEquals(expected, SmallestWindowChallenge.findSmallestWindow(inputString, pattern));
    }

    @Test
    public void shouldReturnNoWindowExists() {
        String inputString = "";
        String pattern = "tist";
        String expected = SmallestWindowChallenge.NO_WINDOW_MESSAGE;
        assertEquals(expected, SmallestWindowChallenge.findSmallestWindow(inputString, pattern));
    }
}