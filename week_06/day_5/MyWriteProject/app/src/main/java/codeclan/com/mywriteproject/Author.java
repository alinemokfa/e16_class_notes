package codeclan.com.mywriteproject;

import codeclan.com.mywriteproject.behaviours.Writable;
import codeclan.com.mywriteproject.writinginstruments.Notepad;

/**
 * Created by user on 03/11/2017.
 */

public class Author {
    private String name;
    private Writable instrumentToWriteOn;

    public Author(String name, Writable instrumentToWriteOn) {
        this.name = name;
        this.instrumentToWriteOn = instrumentToWriteOn;
    }

    public void compose(String text) {
        this.instrumentToWriteOn.write(text);
//        int numberOfPages = this.instrumentToWriteOn.getNumberOfPages();
    }
}
