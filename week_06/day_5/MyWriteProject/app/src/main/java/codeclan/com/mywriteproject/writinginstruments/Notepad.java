package codeclan.com.mywriteproject.writinginstruments;

import java.util.ArrayList;

import codeclan.com.mywriteproject.behaviours.Writable;

/**
 * Created by user on 03/11/2017.
 */

public class Notepad implements Writable {
    private ArrayList<String> pages;

    public Notepad() {
        this.pages = new ArrayList();
    }

    public void write(String text) {
        this.pages.add(text);
    }

    public int getNumberOfPages() {
        return this.pages.size();
    }
}
