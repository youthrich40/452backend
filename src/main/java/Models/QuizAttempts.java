package Models;

import java.sql.Date;

public class QuizAttempts {
    private String attemptID;
    private String userID;
    private String questionID;
    private String answerSubmitted;
    private Date attemptDate;

    public QuizAttempts(String attemptID, String userID, String questionID, String answerSubmitted) {
        this.attemptID = attemptID;
        this.userID = userID;
        this.questionID = questionID;
        this.answerSubmitted = answerSubmitted;
        attemptDate = new java.sql.Date(System.currentTimeMillis());    // Get the time of this exact attempt
    }

    public String getAttemptID() {
        return attemptID;
    }

    public void setAttemptID(String attemptID) {
        this.attemptID = attemptID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
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
