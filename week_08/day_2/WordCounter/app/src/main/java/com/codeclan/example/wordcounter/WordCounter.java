package com.codeclan.example.wordcounter;

/**
 * Created by sandy on 13/12/2016.
 */

public class WordCounter {
    public static int getCount(String text) {
        String[] wordArray = text.toLowerCase().split(" ");
        return wordArray.length;
    }
}
