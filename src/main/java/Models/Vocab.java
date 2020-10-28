package Models;

public class Vocab {
    private String vocabID;
    private String userID;
    private String value;
    private String description;
    private String english;
    private long prev_reviewed;
    private long cur_reviewed;
    private int total_views;

    public Vocab(String vocabID, String userID, String value, String description,
                 String english, long prev_reviewed, long cur_reviewed, int total_views) {
        this.vocabID = vocabID;
        this.userID = userID;
        this.value = value;
        this.description = description;
        this.english = english;
        this.prev_reviewed = prev_reviewed;
        this.cur_reviewed = cur_reviewed;
        this.total_views = total_views;
    }

    public String getVocabID() {
        return vocabID;
    }

    public void setVocabID(String vocabID) {
        this.vocabID = vocabID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public long getPrev_reviewed() {
        return prev_reviewed;
    }

    public void setPrev_reviewed(long prev_reviewed) {
        this.prev_reviewed = prev_reviewed;
    }

    public long getCur_reviewed() {
        return cur_reviewed;
    }

    public void setCur_reviewed(long cur_reviewed) {
        this.cur_reviewed = cur_reviewed;
    }

    public int getTotal_views() {
        return total_views;
    }

    public void setTotal_views(int total_views) {
        this.total_views = total_views;
    }
}
