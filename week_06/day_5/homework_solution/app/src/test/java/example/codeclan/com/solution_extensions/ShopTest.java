package example.codeclan.com.solution_extensions;

import org.junit.Before;
import org.junit.Test;

import example.codeclan.com.solution_extensions.behaviours.Sellable;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 29/08/2017.
 */

public class ShopTest {
    Shop shop;
    Sellable book;
    Sellable guitar;
    Sellable stand;
    Sellable piano;

    @Before
    public void before() {
        shop = new Shop("Ray's Music Exchange");
        book = new MusicBook("The Six Chord Songbook", 3, 5);
        guitar = new Guitar("Gibson SG", "Cherry Red", 6, 400, 500);
        stand = new MusicStand("Silver", 5, 8);
        piano = new Piano("Steinway", "Black", 1800, 2000);

    }

    @Test
    public void hasName() {
        assertEquals("Ray's Music Exchange", shop.getName());
    }

    @Test
    public void stockStartsEmpty() {
        assertEquals(0, shop.stockCount());
    }

    @Test
    public void canAddBookToStock() {
        shop.addToStock(book);
        assertEquals(1, shop.stockCount());
    }

    @Test
    public void canAddGuitarToStock() {
        shop.addToStock(guitar);
        assertEquals(1, shop.stockCount());
    }

    @Test
    public void canRemoveItemFromStock() {
        shop.addToStock(book);
        shop.removeFromStock(book);
        assertEquals(0, shop.stockCount());
    }

    @Test
    public void canGetTotalPotentialProfit() {
        shop.addToStock(book);
        shop.addToStock(piano);
        shop.addToStock(guitar);
        shop.addToStock(stand);
        assertEquals(305, shop.totalPotentialProfit());
    }
}
