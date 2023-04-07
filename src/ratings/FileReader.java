package ratings;

import java.io.File;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Arrays;

public class FileReader {

    public static ArrayList<Song> readSongs(String filename) {
        try {
            HashMap<String, Song> songHashMap = new HashMap<>();
            ArrayList<Song> songs = new ArrayList<Song>();
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(filename)));
            for (String line : lines) {
                //grab the data
                ArrayList<String> splits = new ArrayList<>(Arrays.asList(line.split(",")));
                String songID = splits.get(0);
                String artist = splits.get(1);
                String title = splits.get(2);
                String reviewerID = splits.get(3);
                int ratingScore = Integer.parseInt(splits.get(4));
                //if the song is already added in the arraylist, just add the rating
                if (songHashMap.containsKey(title)) {
                    Song song = songHashMap.get(title);
                    Rating rating = new Rating(reviewerID, ratingScore);
                    song.addRating(rating);
                } else {
                    Rating rating = new Rating(reviewerID, ratingScore);
                    Song song = new Song(title, artist, songID);
                    song.addRating(rating);
                    songHashMap.put(title, song);
                    songs.add(song);
                }

            }
            return songs;
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public static ArrayList<Movie> readMovies(String filename) {
        try {
            ArrayList<Movie> movies = new ArrayList<>();
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(filename)));
            for (String line : lines) {
                //grab the data
                ArrayList<String> splits = new ArrayList<>(Arrays.asList(line.split(",")));
                String title = splits.get(0);
                splits.remove(0);
                ArrayList<String> cast = new ArrayList<>();
                for (String name : splits) {
                    cast.add(name);
                }
                //remove the first index of the arraylist bc its the title of the movie
                //at this names should consist of all the cast names
                //remove the extra whitespace at the start of each name
                Movie movie = new Movie(title, cast);
                movies.add(movie);
            }
            return movies;
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public static ArrayList<Movie> readMovieRatings(ArrayList<Movie> movies, String filename){
        //find the movies that are in the arraylist that are also in the file and then take the ratings for those movies
        // and then add those ratings


        // If a Movie from the input ArrayList does not have any ratings in the ratings file, it should not be included in the output ArrayList
        // If a Movie has been rated that is not included in the input ArrayList, the rating should be ignored

        try {
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(filename)));
            for (String line : lines){
                ArrayList<String> splits = new ArrayList<>(Arrays.asList(line.split(",")));
                for (Movie movie : movies){
                    if (movie.getTitle().equals(splits.get(0))){
                        int rating = Integer.parseInt(splits.get(2));
                        String ReviewerID = splits.get(1);
                        Rating movieRating = new Rating(ReviewerID,rating);
                        movie.addRating(movieRating);
                        movies.add(movie);
                    }
                }
            }
            return movies;
        }
        catch (IOException e) {
            return new ArrayList<>();
        }
    }


}
