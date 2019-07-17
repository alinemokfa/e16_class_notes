package com.codeclan.example.wordcounter;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class WordCounterExtendedTest {

    String testString = "it was the best of times, it was the worst of times";
    WordCounterExtended wordCounter;

    @Before
    public void before() {
        wordCounter = new WordCounterExtended(testString);
    }

    @Test
    public void testWordCounter() {
        int result = wordCounter.getCount(testString);
        assertEquals(12, result);
    }

    @Test
    public void testOccurencesOfWordFollowedBySpace() {
        int result = wordCounter.getOccurrencesCount("it");
        assertEquals(2, result);
    }

    @Test
    public void testOccurencesOfWordFollowedByComma() {
        int result = wordCounter.getOccurrencesCount("times");
        assertEquals(2, result);
    }

    @Test
    public void testToString() {
        //System.out.println(wordCounter.toString());
        String output = wordCounter.toString();
        assertEquals("Total Words: 12\nthe : 2\ntimes : 2\nof : 2\nwas : 2\nbest : 1\nworst : 1\nit : 2\n", output);
    }
}

