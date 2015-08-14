package aziz.sohail.MVPsample.presentation.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import aziz.sohail.MVPsample.domain.User;
import aziz.sohail.MVPsample.presentation.model.UserModel;

/**
 * Created by Sohail Aziz on 8/9/2015.
 * <p/>
 * Mapper class used to transform {@link aziz.sohail.MVPsample.domain.User} in domain layer to {@link aziz.sohail.MVPsample.presentation.model.UserModel}
 * <p/>
 * in presentation layer
 */
public class UserModelDataMapper {

    public UserModelDataMapper() {

    }

    /**
     * Transforms User {@link aziz.sohail.MVPsample.domain.User} to UserModle {@link aziz.sohail.MVPsample.presentation.model.UserModel}
     *
     * @param user
     * @return UserModel {@link aziz.sohail.MVPsample.presentation.model.UserModel}
     */
    public UserModel transform(User user) {
        if (user == null) {
            throw new IllegalArgumentException();
        }

        UserModel userModel = new UserModel();
        userModel.setUserName(user.getUserFirstName() + " " + user.getUserLastName());
        userModel.setUserProfileUrl(user.getUserProfilePictureUrl());
        userModel.setUserDateOfBirth(user.getUserDateOfBirth());

        return userModel;
    }

    public Collection<UserModel> transform(Collection<User> userCollection) {
        Collection<UserModel> userModelCollection;
        if (userCollection != null && !userCollection.isEmpty()) {
            userModelCollection = new ArrayList<>(userCollection.size());

            for (User u : userCollection) {
                userModelCollection.add(transform(u));
            }


        } else {
            userModelCollection = Collections.emptyList();
        }

        return userModelCollection;
    }

}
