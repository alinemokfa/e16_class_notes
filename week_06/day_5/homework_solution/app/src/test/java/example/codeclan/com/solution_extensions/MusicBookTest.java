package example.codeclan.com.solution_extensions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 29/08/2017.
 */

public class MusicBookTest {

    MusicBook book;

    @Before
    public void before() {
        book = new MusicBook("The Six Chord Songbook", 3, 5);
    }

    @Test
    public void hasTitle() {
        assertEquals("The Six Chord Songbook", book.getTitle());
    }

    @Test
    public void hasBuyPrice() {
        assertEquals(3, book.getBuyPrice());
    }

    @Test
    public void hasSellPrice() {
        assertEquals(5, book.getSellPrice());
    }

    @Test
    public void canGetMarkUp() {
        assertEquals(2, book.calculateMarkup());
    }
}
