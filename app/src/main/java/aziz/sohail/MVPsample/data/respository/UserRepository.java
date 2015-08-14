package aziz.sohail.MVPsample.data.respository;

/**
 * Created by Sohail Aziz on 8/12/2015.
 */
public interface UserRepository {

    interface UserCallback {
        void onValidateSuccess();

        void onValidateError(Exception e);
    }

    void validateUser(String username, String password, UserCallback callback);
}
