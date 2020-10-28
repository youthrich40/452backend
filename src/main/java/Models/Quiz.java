package Models;

public class Quiz {
    private String questionID;
    private String userID;
    private int numberOfAttempts;

    public Quiz(String questionID, String userID, int numberOfAttempts) {
        this.questionID = questionID;
        this.userID = userID;
        this.numberOfAttempts = numberOfAttempts;
    }

    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public void setNumberOfAttempts(int numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
    }
}
