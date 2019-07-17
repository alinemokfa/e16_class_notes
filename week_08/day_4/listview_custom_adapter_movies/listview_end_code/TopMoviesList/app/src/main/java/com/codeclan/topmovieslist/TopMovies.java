package com.codeclan.topmovieslist;


import java.util.ArrayList;

public class TopMovies {

    private ArrayList<Movie> list;

    public TopMovies() {
        list = new ArrayList<Movie>();
        list.add(new Movie(1, "The Shawshank Redemption", 1994));
        list.add(new Movie(2, "The Godfather", 1972));
        list.add(new Movie(3, "The Godfather: Part II", 1974));
        list.add(new Movie(4, "The Dark Knight", 2008));
        list.add(new Movie(5, "12 Angry Men", 1957));
        list.add(new Movie(6, "Schindler's List", 1993));
        list.add(new Movie(7, "Pulp Fiction", 1994));
        list.add(new Movie(8, "Lord of the Rings: The Return of the King", 2003));
        list.add(new Movie(9, "The Good, the Bad and the Ugly", 1966));
        list.add(new Movie(10, "Fight Club", 1999));
        list.add(new Movie(11, "Lord of the Rings: The Fellowship of the Ring", 2001));
        list.add(new Movie(12, "Star Wars: Episode V - The Empire Strikes Back", 1980));
        list.add(new Movie(13, "Forrest Gump", 1994));
        list.add(new Movie(14, "Inception", 2010));
        list.add(new Movie(15, "The Lord of the Rings: The Two Towers", 2002));
        list.add(new Movie(16, "One Flew Over the Cuckoo's Nest", 1975));
        list.add(new Movie(17, "Goodfellas", 1990));
        list.add(new Movie(18, "The Matrix", 1999));
        list.add(new Movie(19, "Seven Samurai", 1954));
        list.add(new Movie(20, "Star Wars: Episode IV - A New Hope", 1977));
    }

    public ArrayList<Movie> getList() {
        return new ArrayList<Movie>(list);
    }

}
