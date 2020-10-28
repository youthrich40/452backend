package Models;

public class Quiz {
    private int questionID;
    private int userID;
    private int numberOfAttempts;

    public Quiz(int questionID, int userID, int numberOfAttempts) {
        this.questionID = questionID;
        this.userID = userID;
        this.numberOfAttempts = numberOfAttempts;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public void setNumberOfAttempts(int numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
    }
}
