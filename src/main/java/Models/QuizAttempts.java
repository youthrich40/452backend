package Models;

import java.sql.Date;

public class QuizAttempts {
    private int attemptID;
    private int userID;
    private int questionID;
    private String answerSubmitted;
    private Date attemptDate;

    public QuizAttempts(int attemptID, int userID, int questionID, String answerSubmitted) {
        this.attemptID = attemptID;
        this.userID = userID;
        this.questionID = questionID;
        this.answerSubmitted = answerSubmitted;
        attemptDate = new java.sql.Date(System.currentTimeMillis());    // Get the time of this exact attempt
    }

    public int getAttemptID() {
        return attemptID;
    }

    public void setAttemptID(int attemptID) {
        this.attemptID = attemptID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getAnswerSubmitted() {
        return answerSubmitted;
    }

    public void setAnswerSubmitted(String answerSubmitted) {
        this.answerSubmitted = answerSubmitted;
    }

    public Date getAttemptDate() {
        return attemptDate;
    }

    public void setAttemptDate(Date attemptDate) {
        this.attemptDate = attemptDate;
    }
}
