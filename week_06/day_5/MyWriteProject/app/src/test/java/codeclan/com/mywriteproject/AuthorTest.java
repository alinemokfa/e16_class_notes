package codeclan.com.mywriteproject;

import org.junit.Test;

import codeclan.com.mywriteproject.writinginstruments.Notepad;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 03/11/2017.
 */

public class AuthorTest {

    @Test
    public void testAuthorCanWriteToNotepad() {
        Notepad notepad = new Notepad();
        Author author = new Author("Terry Brooks", notepad);
        author.compose("Some text");

        assertEquals(1, notepad.getNumberOfPages());
    }
}
