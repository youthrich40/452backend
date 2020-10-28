package Models;

public class User {
    private String userID;
    private String purchaseInfo;

    public User(String userID, String purchaseInfo) {
        this.userID = userID;
        this.purchaseInfo = purchaseInfo;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPurchaseInfo() {
        return purchaseInfo;
    }

    public void setPurchaseInfo(String purchaseInfo) {
        this.purchaseInfo = purchaseInfo;
    }
}
