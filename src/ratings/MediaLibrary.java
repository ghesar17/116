package ratings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static ratings.FileReader.readSongs;
import static ratings.FileReader.readMovies;
import static ratings.FileReader.readMovieRatings;

public class MediaLibrary {
    private ArrayList<Ratable> mediaLibrary;

    public void populateLibrary(String songsfile, String moviescastfile, String moviesratingsfile) {
        this.mediaLibrary.addAll(readSongs(songsfile));
        this.mediaLibrary.addAll(readMovies(moviescastfile));
        this.mediaLibrary.addAll(readMovieRatings(readMovies(moviescastfile),moviesratingsfile));
    }

    public ArrayList<Ratable> topKRatables(int k) {
        //need to do bayesian on all the ratings then sort then return a arraylist of the sorted ratables

        ArrayList<Double> bayesianRatings = new ArrayList<>();
        //now I have a arraylist of all the ratable objects now i need to bayesian each
        HashMap<String, Double> ratableHashMap = new HashMap<>();
        for (Ratable ratable : this.mediaLibrary) {
            Double bayesian = ratable.bayesianAverageRating(2, 3);
            ratableHashMap.put(ratable.getTitle(), bayesian);
            bayesianRatings.add(bayesian);
        }
        //at this point it would look like
//asdijas;doiad

        // ratableHashMap = {"Chamber of Reflection" : 4.666, "LOL" : 3.333, "Moonlight" : 5.222}
        // bayesianRatings = [4.666,3.333,5.222]

        //need to return ["Moonlight","Chamber of Reflection","LOL"]
        //then i can just search for the actual ratable object by title which is chill i think

        bayesianRatings.sort();






        Arrays.sort(bayesianRatings, 0, 3);
    }

    public boolean compare(Ratable a, Ratable b) {
        if (a.bayesianAverageRating(2,3) > b.bayesianAverageRating(2,3)) {
            return true;
        }
        else {
            return false;
        }
    }

//        if (songHashMap.containsKey(title)) {
//            Song song = songHashMap.get(title);
//            Rating rating = new Rating(reviewerID, ratingScore);
//            song.addRating(rating);
//        } else {
//            Rating rating = new Rating(reviewerID, ratingScore);
//            Song song = new Song(title, artist, songID);
//            song.addRating(rating);
//            songHashMap.put(title, song);
//            songs.add(song);

    }
}
