package ratings;

public class Reviewer{
    private String ReviewerID;
    public Reviewer(String ReviewerID) {
        setReviewerID(ReviewerID);
    }

    public String getReviewerID() {
        return this.ReviewerID;
    }

    public void setReviewerID(String ReviewerID) {
        this.ReviewerID = ReviewerID;
    }

    public Rating rateSong(int Rating) {
        return new Rating(this.ReviewerID,Rating);
    }
}
