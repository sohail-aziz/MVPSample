package aziz.sohail.MVPsample.domain;

/**
 * Created by Sohail Aziz on 8/9/2015.
 *
 * User class to represent user in Domain layer
 */
public class User {

    private String userId;
    private String userFirstName, userLastName;
    private String userProfilePictureUrl;
    private long userDateOfBirth;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserProfilePictureUrl() {
        return userProfilePictureUrl;
    }

    public void setUserProfilePictureUrl(String userProfilePictureUrl) {
        this.userProfilePictureUrl = userProfilePictureUrl;
    }

    public long getUserDateOfBirth() {
        return userDateOfBirth;
    }

    public void setUserDateOfBirth(long userDateOfBirth) {
        this.userDateOfBirth = userDateOfBirth;
    }
}
