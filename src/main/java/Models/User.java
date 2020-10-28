package Models;

public class User {
    private int userID;
    private String purchaseInfo;

    public User(int userID, String purchaseInfo) {
        this.userID = userID;
        this.purchaseInfo = purchaseInfo;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getPurchaseInfo() {
        return purchaseInfo;
    }

    public void setPurchaseInfo(String purchaseInfo) {
        this.purchaseInfo = purchaseInfo;
    }
}
