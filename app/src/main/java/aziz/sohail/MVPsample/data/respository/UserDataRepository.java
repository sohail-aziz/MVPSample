package aziz.sohail.MVPsample.data.respository;

import aziz.sohail.MVPsample.data.exception.InvalidCredentialException;

/**
 * Created by Sohail Aziz on 8/12/2015.
 */
public class UserDataRepository implements UserRepository {

    private static UserDataRepository INSTANCE = new UserDataRepository();

    public static UserDataRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public void validateUser(String username, String password, UserCallback callback) {

        if (username == null || password == null || callback == null) {
            throw new IllegalArgumentException();
        }

        if (validated(username, password)) {
            callback.onValidateSuccess();
        } else {
            callback.onValidateError(new InvalidCredentialException());
        }

    }


    private boolean validated(String username, String password) {
        if (username.equals("sohail") && password.equals("aziz")) {
            return true;
        } else {
            return false;
        }
    }


}
