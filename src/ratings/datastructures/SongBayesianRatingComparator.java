package ratings.datastructures;

import ratings.Song;
import ratings.Ratable;

public class SongBayesianRatingComparator extends Comparator<Song> {

    public boolean compare(Song a, Song b) {
        if (a.bayesianAverageRating(2,3) > b.bayesianAverageRating(2,3)) {
            return true;
        }
        else {
            return false;
        }
    }

}