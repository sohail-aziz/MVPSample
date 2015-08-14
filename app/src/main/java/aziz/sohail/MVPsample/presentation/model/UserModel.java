package aziz.sohail.MVPsample.presentation.model;

/**
 * Created by Sohail Aziz on 8/9/2015.
 */
public class UserModel {

    private String userName;
    private String userProfileUrl;
    private long userDateOfBirth;

    public String getUserProfileUrl() {
        return userProfileUrl;
    }

    public void setUserProfileUrl(String userProfileUrl) {
        this.userProfileUrl = userProfileUrl;
    }

    public long getUserDateOfBirth() {
        return userDateOfBirth;
    }

    public void setUserDateOfBirth(long userDateOfBirth) {
        this.userDateOfBirth = userDateOfBirth;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
