package example.codeclan.com.singleresponsibility;

/**
 * Created by user on 27/06/2017.
 */

import java.util.ArrayList;

// The Single Responsibility Principle states that:
// "every module or class should have responsibility over a single part of the functionality provided by the software, and that responsibility should be entirely encapsulated by the class."
// It's often unhelpfully described as:
// "A class should have only one reason to change."

// This Bear has a Jounal, and he can write in it and get back the entries he has written.
// This isn't really the Bear's responsibilty, now the Bear is concerned about how to manage his journal entries, as well as all the regular Bear stuff he needs to do. The Bear class is getting bloated.
// This also gives the Bear more than one "Reason to change" - If how the journal entry system works is updated, then we have to go in to our Bear class and change it, we already have to change the Bear class is any of its Bear stuff changes, that's two reasons to change, bad.
// We should probably have a separate Journal class to manage all that journaling, and leave our Bear class with a single responsibility: Bear stuff.

public class Bear{

    private ArrayList<Salmon> belly;
    private ArrayList<String> journalEntries;

    public Bear(){
        belly = new ArrayList<Salmon>();
        journalEntries = new ArrayList<String>();
    }

    public void eat(Salmon food){
        if (isBellyFull()) return;
        belly.add(food);
    }

    public int foodCount(){
        return belly.size();
    }

    public boolean isBellyFull(){
        return (foodCount() >= 5);
    }

    public void writeJournal(String entry){
        journalEntries.add(entry);
    }

    public String getJournalEntry(int index){
        return journalEntries.get(index);
    }

    public String getLastJournalEntry(){
        return getJournalEntry(journalEntries.size() - 1);
    }




}
