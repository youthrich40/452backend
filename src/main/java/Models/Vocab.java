package Models;

import java.sql.Date;

public class Vocab {
    private int vocabID;
    private int userID;
    private String value;
    private String description;
    private String english;
    private Date prev_reviewed;
    private Date cur_reviewed;
    private int total_views;

    public Vocab(int vocabID, int userID, String value, String description,
                 String english, Date prev_reviewed, Date cur_reviewed, int total_views) {
        this.vocabID = vocabID;
        this.userID = userID;
        this.value = value;
        this.description = description;
        this.english = english;
        this.prev_reviewed = prev_reviewed;
        this.cur_reviewed = cur_reviewed;
        this.total_views = total_views;
    }

    public int getVocabID() {
        return vocabID;
    }

    public void setVocabID(int vocabID) {
        this.vocabID = vocabID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
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

    public Date getPrev_reviewed() {
        return prev_reviewed;
    }

    public void setPrev_reviewed(long prev_reviewed) {
        this.prev_reviewed = new java.sql.Date(prev_reviewed);
    }

    public void setPrev_reviewed(Date prev_reviewed) {
        this.prev_reviewed = prev_reviewed;
    }

    public Date getCur_reviewed() {
        return cur_reviewed;
    }

    public void setCur_reviewed(long cur_reviewed) {
        this.cur_reviewed = new java.sql.Date(cur_reviewed);
    }

    public void setCur_reviewed(Date cur_reviewed) {
        this.cur_reviewed = cur_reviewed;
    }

    public int getTotal_views() {
        return total_views;
    }

    public void setTotal_views(int total_views) {
        this.total_views = total_views;
    }
}
