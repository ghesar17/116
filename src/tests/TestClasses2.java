package tests;

import org.junit.Test;
import ratings.Rating;
import ratings.Reviewer;
import ratings.Song;
import ratings.Movie;
import ratings.datastructures.SongBayesianRatingComparator;
import ratings.datastructures.SongTitleComparator;
import ratings.datastructures.LinkedListNode;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class TestClasses2 {

    private final double EPSILON = 0.001;

    public void compareDoubles(double d1, double d2) {
        assertTrue(Math.abs(d1 - d2) < EPSILON);
    }

    @Test
    public void testBayesianAverageRatingSong() {

        Song song1 = new Song("Moonlight on the River", "Mac DeMarco", "1");

        compareDoubles(song1.bayesianAverageRating(2, 3), 3.0);
        compareDoubles(song1.bayesianAverageRating(2, 5), 5.0);
        compareDoubles(song1.bayesianAverageRating(1, 5), 5.0);


        Song song2 = new Song("For the First Time", "Mac DeMarco", "9");

        compareDoubles(song2.bayesianAverageRating(1, 1), 1.0);
        compareDoubles(song2.bayesianAverageRating(10, 1), 1.0);

        Song song3 = new Song("Chamber of Reflection", "Mac DeMarco", "4");

        compareDoubles(song3.bayesianAverageRating(2, 1), 1.0);
        compareDoubles(song3.bayesianAverageRating(20, 4), 4.0);
        compareDoubles(song3.bayesianAverageRating(7, 2), 2.0);

        //testing for NO RATINGS

        Song songwithnoratings = new Song("TOUCH", "keshi", "3");

        compareDoubles(songwithnoratings.bayesianAverageRating(0, 0), 0.0);
    }


    //    @Test
//    public void testGetTitle() {
//
//        ArrayList<String> cast2 = new ArrayList<>(Arrays.asList("Luke","Phil"));
//
//        Movie ASilentVoice = new Movie("A Silent Voice",cast2);
//
//        assertTrue(ASilentVoice.getTitle().equals("A Silent Voice"));
//    }
//
    @Test
    public void testGetCast() {

        ArrayList<String> cast3 = new ArrayList<>(Arrays.asList("Luke", "Phil"));

        Movie WTF = new Movie("WTF", cast3);



        String caststring = cast3.toString();

        String caststring1 = WTF.getCast().toString();

        assertTrue(caststring1.equalsIgnoreCase(caststring));





        ArrayList<String> castwithtwonames = new ArrayList<>(Arrays.asList("Ghesar Phanday","LOL OKAY"));

        Movie LOL = new Movie("LOL",castwithtwonames);

        String castwithtwonamesstring = castwithtwonames.toString();

        String castwithtwonamesstring1 = LOL.getCast().toString();

        assertTrue(castwithtwonamesstring1.equalsIgnoreCase(castwithtwonamesstring));
    }

    @Test
    public void testBayesianAverageRatingMovie() {

        ArrayList<String> cast = new ArrayList<>(Arrays.asList("asd", "dsa"));

        Movie movie1 = new Movie("Moonlight on the River", cast);

        Rating rating1 = new Rating("Jesse", 4);
        Rating rating2 = new Rating("Paul", 5);

        movie1.addRating(rating1);
        movie1.addRating(rating2);

        compareDoubles(movie1.bayesianAverageRating(2, 3), 3.75);
        compareDoubles(movie1.bayesianAverageRating(2, 5), 4.75);
        compareDoubles(movie1.bayesianAverageRating(1, 5), 4.66666667);


    }
    @Test
    public void testSongTitleComparator() {

        SongTitleComparator songs1 = new SongTitleComparator();

        Song song4 = new Song("a", "Mac DeMarco", "5");
        Song song5 = new Song("b", "Mac DeMarco", "6");
        assertTrue(songs1.compare(song4, song5) == true);
        assertTrue(songs1.compare(song5, song4) == false);


        Song song18 = new Song("acd", "ME", "1");
        Song song19 = new Song("kfc", "ME", "1");
        assertTrue(songs1.compare(song18, song19) == true);
        assertTrue(songs1.compare(song19, song18) == false);


        Song song20 = new Song("A", "ME", "1");
        Song song21 = new Song("a", "ME", "1");
        assertTrue(songs1.compare(song20, song21) == false);
        assertTrue(songs1.compare(song21, song20) == false);


        Song song22 = new Song("aa", "ME", "1");
        Song song23 = new Song("aaa", "ME", "1");
        assertTrue(songs1.compare(song22, song23) == true);


        Song song24 = new Song("GH", "ME", "1");
        Song song25 = new Song("NI", "ME", "1");
        assertTrue(songs1.compare(song24, song25) == true);

    }

    @Test
    public void testSongBayesianRatingComparator() {

        SongBayesianRatingComparator songs5 = new SongBayesianRatingComparator();


        Song song11 = new Song("Moonlight on the River", "Mac DeMarco", "123");
        Song song12 = new Song("Moonlight on the River", "Mac DeMarco", "123");
        assertFalse(songs5.compare(song11, song12));


        Rating A = new Rating("ME", 1);
        song11.addRating(A);
        Rating B = new Rating("ME", 1);
        song12.addRating(B);
        assertFalse(songs5.compare(song11, song12));


        Song song13 = new Song("Moonlight on the River", "Mac DeMarco", "123");
        Song song14 = new Song("Moonlight on the River", "Mac DeMarco", "123");
        Rating rating12 = new Rating("ME", 3);
        song13.addRating(rating12);
        Rating rating0 = new Rating("ME", 2);
        song14.addRating(rating0);
        assertTrue(songs5.compare(song13, song14));


        Song song15 = new Song("Moonlight on the River", "Mac DeMarco", "123");
        Song song16 = new Song("Moonlight on the River", "Mac DeMarco", "123");
        Rating rating = new Rating("ME", 4);
        song15.addRating(rating);
        Rating rating2 = new Rating("ME", 5);
        song16.addRating(rating2);
        assertFalse(songs5.compare(song15, song16));

        Song song10 = new Song("Moonlight on the River", "Mac DeMarco", "123");
        Song song111 = new Song("Moonlight on the River", "Mac DeMarco", "123");

        assertFalse(songs5.compare(song10, song111));


        Song song19 = new Song("Moonlight on the River", "Mac DeMarco", "123");
        Song song20 = new Song("Moonlight on the River", "Mac DeMarco", "123");
        song19.addRating(new Rating("ME", 5));
        for (int i = 0; i < 25; i++) {
            song20.addRating(new Rating(Integer.toString(i), 4));

        }
        assertFalse(songs5.compare(song19, song20));

    }
}