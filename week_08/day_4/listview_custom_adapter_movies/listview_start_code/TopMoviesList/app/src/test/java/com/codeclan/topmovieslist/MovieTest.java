package com.codeclan.topmovieslist;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class MovieTest {

    Movie movie;

    @Before
    public void before() {
        movie = new Movie(101, "Monty Python and the Holy Grail", 1975);
    }

    @Test
    public void getRankingTest() {
        assertEquals((Integer)101, movie.getRanking());

    }

    @Test
    public void getTitleTest() {
        assertEquals("Monty Python and the Holy Grail", movie.getTitle());

    }

    @Test
    public void getYearTest() {
        assertEquals((Integer)1975, movie.getYear());

    }
}