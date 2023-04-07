package ratings;

import ratings.datastructures.LinkedListNode;

public class Song extends Ratable{
//    private String title;
    private String artist;
    private String SongID;
//    private LinkedListNode<Rating> Lln = null;

    public Song(String title, String artist, String SongID) {
        this.setTitle(title);
        this.setArtist(artist);
        this.setSongID(SongID);
    }
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSongID() {
        return SongID;
    }

    public void setSongID(String SongID) {
        this.SongID = SongID;
    }
}
