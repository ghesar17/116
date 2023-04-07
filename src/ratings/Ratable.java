package ratings;

import ratings.datastructures.LinkedListNode;


public class Ratable {

    private String title;

    private LinkedListNode<Rating> Lln = null;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LinkedListNode<Rating> getRatings() {
        return this.Lln;
    }

    public void addRating(Rating rating) {
        if (!didReviewerRateSong(rating.getReviewerID())) {
            if (this.Lln == null) {
                this.Lln = new LinkedListNode(rating, null);
            }
            else {
                this.Lln.append(rating);
            }
        }
    }

    public double averageRating() {
        double sum = 0.0;
        if (this.Lln == null) {
            return 0.0;
        } else {
            int size = this.Lln.size();
            return averageRatingHelper(this.Lln, sum) / size;
        }
    }

    private double averageRatingHelper(LinkedListNode<Rating> node, double sum) {
        if (node == null){
            return sum;
        } else {
            sum += node.getValue().getRating();
            return averageRatingHelper(node.getNext(), sum);
        }
    }

    public boolean didReviewerRateSong(String ReviewerID) {
        if (this.Lln != null) {
            return didReviewerRateSongHelper(ReviewerID, this.Lln);
        } else {
            return false;
        }
    }

    private boolean didReviewerRateSongHelper(String ReviewerID, LinkedListNode<Rating> node) {
        if (node == null) {
            return false;
        } else {
            Rating rating = node.getValue();
            if (rating.getReviewerID().equals(ReviewerID)) {
                return true;
            } else {
                return didReviewerRateSongHelper(ReviewerID, node.getNext());
            }
        }
    }

    public void removeRatingByReviewer(Reviewer Reviewer) {
        LinkedListNode<Rating> node = this.Lln;
        String ReviewerID = Reviewer.getReviewerID();
        if (node.getValue().getReviewerID().equals(ReviewerID)) {
            node = this.Lln.getNext();
            this.Lln = node;
            return;
        }
        while (this.Lln != null) {
            LinkedListNode<Rating> nextnode = node.getNext();
            if (nextnode == null){
                return;
            }
            if (nextnode.getValue().getReviewerID().equals(ReviewerID)){
                LinkedListNode<Rating> nextnextNode = node.getNext().getNext();
                node.setNext(nextnextNode);
                return;
            }
            node = node.getNext();
        }
    }

    public double bayesianAverageRating(int extras, int value) {
        if ((this.Lln == null) && (extras == 0)) {
            return 0.0;
        }
        else {
            if (this.Lln == null) {
                return (extras * value) / extras;
            } else {
                LinkedListNode<Rating> node = this.Lln;
                double sum = 0.0;
                return (bayesianAverageRatingHelper(node,sum) + (extras*value)) / (node.size() + extras);
            }
        }
    }


    public double bayesianAverageRatingHelper(LinkedListNode<Rating> node,double sum){
        if (node == null) {
            return sum;
        }
        else {
            sum += node.getValue().getRating();
            return bayesianAverageRatingHelper(node.getNext(),sum);
        }
    }
//    public static void main(String[] args) {
//        Song song1 = new Song("ASD","asd","34");
//        Rating rating1 = new Rating("ASd",3);
//        song1.addRating(rating1);
////        Rating rating2 = new Rating("ASd",3);
////        song1.addRating(rating2);
//        System.out.println(song1.bayesianAverageRating(2,2));
//    }


}
