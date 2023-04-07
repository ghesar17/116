package tests;


import org.junit.Test;
import ratings.datastructures.LinkedListNode;
import ratings.FileReader;
import ratings.Movie;
import ratings.Song;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class TestDataStructures3 {

    @Test
    public void testReadMoviesSingleMovie() {
        ArrayList<Movie> movies = FileReader.readMovies("data/movietest1.csv");
        assertEquals(1, movies.size());
        ArrayList<String> cast = new ArrayList<>(Arrays.asList("Kevin Bacon,Bob Hoskins,Bridget Fonda,Jim Cummings,Jack Angel,Danny Mann,Robbie Rist,Frank Welker,Miriam Margolyes"));
        String title = "Balto";
        Movie movie = movies.get(0);
        assertEquals("Bob Hoskins",movie.getCast().get(1));
        assertEquals(9, movie.getCast().size());
        assertEquals(title, movie.getTitle());
    }

    @Test
    public void testReadMoviesMultipleMovies() {
        ArrayList<Movie> movies = FileReader.readMovies("data/moviestest2.csv");
        assertEquals(3, movies.size());
    }

    @Test
    public void testReadMoviesEmptyCSV() {
        ArrayList<Movie> empty = new ArrayList<>();
        assertEquals(empty, FileReader.readMovies("aeouieu"));
    }
}
