package tests;

import org.junit.Test;
import ratings.Rating;
import ratings.Reviewer;
import ratings.Song;
import ratings.Playlist;
import ratings.datastructures.LinkedListNode;
import ratings.datastructures.SongBayesianRatingComparator;
import ratings.datastructures.SongTitleComparator;

import static org.junit.Assert.*;


public class TestDataStructures2 {

    @Test

    public void testGetSongListSongTitleComparator() {

        SongTitleComparator songTitleComparator = new SongTitleComparator();

        Playlist playlist1 = new Playlist(songTitleComparator);

        Song song1 = new Song("Moonlight on the River", "Mac DeMarco", "1");
        Song song2 = new Song("Boonlight on the River", "Mac DeMarco", "1");

        playlist1.addSong(song1);
        playlist1.addSong(song2);

        assertEquals(playlist1.getSongList().getValue().getTitle(), "Boonlight on the River");
        assertEquals(playlist1.getSongList().getNext().getValue().getTitle(), "Moonlight on the River");


    }

    @Test

    public void testGetSongListSongTitleComparatorNOSONGS() {

        SongTitleComparator songTitleComparator = new SongTitleComparator();

        Playlist playlist1 = new Playlist(songTitleComparator);

        LinkedListNode<Song> songlist = playlist1.getSongList();

        assertEquals(songlist, null);

    }

    @Test

    public void testGetSongListSongBayesianRatingComparator() {

        Playlist playlist1 = new Playlist(new SongBayesianRatingComparator());

        Song song1 = new Song("Moonlight on the River", "Mac DeMarco", "1");
        Song song2 = new Song("Boonlight on the River", "Mac DeMarco", "1");

        Rating rating1 = new Rating("123", 2);
        Rating rating2 = new Rating("1234", 5);

        song1.addRating(rating1);
        song2.addRating(rating2);

        playlist1.addSong(song1);
        playlist1.addSong(song2);

        //must check the values of title, artist and songid, rather than relying on assertequals
        assertEquals(playlist1.getSongList().getValue().getTitle(), "Boonlight on the River");
        assertEquals(playlist1.getSongList().getNext().getValue().getTitle(), "Moonlight on the River");

        //test for no ratings

        Playlist playlist2 = new Playlist(new SongBayesianRatingComparator());

        Song song3 = new Song("Moonlight on the River", "Mac DeMarco", "1");
        Song song4 = new Song("Boonlight on the River", "Mac DeMarco", "1");

        playlist2.addSong(song3);
        playlist2.addSong(song4);

        LinkedListNode<Song> songlist = playlist2.getSongList();
        assertEquals(songlist.getValue(), song3);
        assertEquals(songlist.getNext().getValue(), song4);


        //test for more than 3

        Playlist playlist3 = new Playlist(new SongBayesianRatingComparator());

        Song song5 = new Song("Moonlight on the River", "Mac DeMarco", "1");
        Song song6 = new Song("Boonlight on the River", "Mac DeMarco", "1");
        Song song7 = new Song("Doonlight on the River", "Mac DeMarco", "1");
        Song song8 = new Song("Eoonlight on the River", "Mac DeMarco", "1");

        playlist3.addSong(song5);
        playlist3.addSong(song6);
        playlist3.addSong(song7);
        playlist3.addSong(song8);

        LinkedListNode<Song> songlist1 = playlist3.getSongList();
        assertEquals(songlist1.getValue(), song5);
        assertEquals(songlist1.getNext().getValue(), song6);
        assertEquals(songlist1.getNext().getNext().getValue(), song7);
        assertEquals(songlist1.getNext().getNext().getNext().getValue(), song8);


    }
}
