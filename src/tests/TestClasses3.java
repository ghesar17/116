package tests;


import org.junit.Test;
import ratings.Rating;
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


public class TestClasses3 {

    @Test
    public void testReadSongsSingleSong(){
        ArrayList<Song> songs = FileReader.readSongs("data/ratingstest1.csv");
        assertEquals(1,songs.size());

        Song song = songs.get(0);

        String ReviewerID = "597";
        assertEquals(ReviewerID,song.getRatings().getValue().getReviewerID());

        String artist = "pinkpantheress";
        assertEquals(artist,song.getArtist());

        String title = "Take me home";
        assertEquals(title,song.getTitle());

        String SongID = "4CykmPXyJzacASnoxR33ns";
        assertEquals(SongID,song.getSongID());
    }

    @Test
    public void testReadSongsMultipleSongs(){
        ArrayList<Song> songs = FileReader.readSongs("data/ratingstest2.csv");
        assertEquals(1,songs.size());
    }

    @Test
    public void testReadSongsEmptyCSV(){
        ArrayList<Song> empty = new ArrayList<>();
        assertEquals(empty,FileReader.readSongs("afoisdfijsdf"));
    }

    @Test
    public void Song_RatingsInWrongOrder(){
        ArrayList<Song> songs = FileReader.readSongs("data/ratingstest2.csv");
        assertEquals(songs.size(),1);
        Song song = songs.get(0);

        assertEquals(5,song.getRatings().getValue().getRating());

        ArrayList<Song> songs1 = FileReader.readSongs("data/ratingstest3.csv");

        //check if the returned arraylist is the right size
        assertEquals(songs1.size(),3);

        Song song1 = songs1.get(0);
        Song song2 = songs1.get(1);
        Song song3 = songs1.get(2);

        //check if the rating list lengths are correct

        assertEquals(5,song1.getRatings().getValue().getRating());
        assertEquals(1,song1.getRatings().size());

        assertEquals(5,song2.getRatings().getValue().getRating());
        assertEquals(1,song2.getRatings().size());

        assertEquals(5,song3.getRatings().getValue().getRating());
        assertEquals(1,song3.getRatings().size());

    }

    @Test
    public void Song_OnlyOneRating(){

        ArrayList<Song> songs = FileReader.readSongs("data/ratingstest4.csv");

        Song song1 = songs.get(0);

        //check that the length of the ll and the order of ratings is correct
        assertEquals(2,song1.getRatings().size());
        assertEquals(5,song1.getRatings().getValue().getRating());
        assertEquals("597",song1.getRatings().getValue().getReviewerID());

        assertEquals(4,song1.getRatings().getNext().getValue().getRating());
        assertEquals("41",song1.getRatings().getNext().getValue().getReviewerID());

    }
}
