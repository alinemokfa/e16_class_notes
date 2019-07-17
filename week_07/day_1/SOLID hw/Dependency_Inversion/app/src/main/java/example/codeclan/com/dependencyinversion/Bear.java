package example.codeclan.com.dependencyinversion;

/**
 * Created by user on 27/06/2017.
 */

// The Dependency Inversion Principle states that:
// "High level modules should not depend upon low level modules. Both should depend upon abstractions."
// Thanks, internet, that's no help at all.

// Basically, Bear is a "higher level module" than Diary.
// This "level of abstraction" is a relative measure of what level of detail the class is concerned about.

// You don't need to understand how your Macbook's processor or the macOS kernel actually works.
// All of that lower-level complexity is abstracted away from you when you use your laptop.
// The same is true for our Bear and their Diary.

import java.util.ArrayList;

public class Bear{

    private Diary journal;

    public Bear(){
        this.journal = new Diary();
        // An instance of Diary is newed up in the Bear constructor.
        // This means the Bear class is "dependent" on the Diary class.
        // The Bear is stuck with a Diary, but it shouldn't really matter what kind of journal it is, as long as it can .write()
    }

    public Diary getJournal(){
        return this.journal;
    }

    public void writeJournal(String text){
        this.journal.write(text);
    }

}