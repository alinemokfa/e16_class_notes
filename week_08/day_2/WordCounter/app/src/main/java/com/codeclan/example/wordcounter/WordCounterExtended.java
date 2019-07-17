package com.codeclan.example.wordcounter;


import java.util.HashMap;

/**
 * Created by sandy on 26/10/2016.
 */


public class WordCounterExtended {

    private HashMap <String, Integer> concordance;
    private String[] words;

    public WordCounterExtended(String text) {
        this.concordance = new HashMap<String, Integer>();
        this.words = text.toLowerCase().split("[,\\s]+");

        for (String word : words) {
            if (concordance.get(word) == null) {
                concordance.put(word, 1);
            } else {
                Integer updatedValue = concordance.get(word) + 1;
                concordance.put(word, updatedValue );
            }
        }
    }

    public int getCount() {
        return this.words.length;
    }

    public int getOccurrencesCount(String word) {
        return concordance.get(word);
    }

    public String toString() {
        String output = "Total Words: " + words.length + "\n";

        // for key in hash.keys
        for (String key: concordance.keySet()) {

            // this output would like
            // output += "Hello : 5 \n"
            // output += key + " : " + hash[key] + " \n"
            output += key + " : " + concordance.get(key) + "\n";
        }

        return output;
    }
}
