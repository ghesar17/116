package ratings;
import ratings.datastructures.LinkedListNode;

import java.util.ArrayList;
import java.util.Arrays;



public class Movie extends Ratable {
    private ArrayList<String> cast;

    public String title;

    public Movie(String title, ArrayList<String> cast) {
        setTitle(title);
        this.cast = cast;
    }

    public ArrayList<String> getCast() {
        return this.cast;
    }
}
