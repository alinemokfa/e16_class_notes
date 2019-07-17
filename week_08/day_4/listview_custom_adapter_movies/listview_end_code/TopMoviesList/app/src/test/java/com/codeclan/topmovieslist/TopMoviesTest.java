package com.codeclan.topmovieslist;

import org.junit.Test;
import static org.junit.Assert.*;


public class TopMoviesTest {

    @Test
    public void getListTest() {
        TopMovies topMovies = new TopMovies();
        assertEquals(20, topMovies.getList().size());
    }
}