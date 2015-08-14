package aziz.sohail.MVPsample.presentation.mapper;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Collection;

import aziz.sohail.MVPsample.domain.User;
import aziz.sohail.MVPsample.presentation.model.UserModel;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;


/**
 * Created by Sohail Aziz on 8/11/2015.
 */
public class UserDataMapperTest extends TestCase {

    final String FIRST_NAME = "Sohail";
    final String LAST_NAME = "Aziz";
    UserModelDataMapper userModelDataMapper;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        userModelDataMapper = new UserModelDataMapper();
    }

    public void testTransformUser() {

        String expectedUsername = FIRST_NAME + " " + LAST_NAME;

        User user = new User();
        user.setUserFirstName(FIRST_NAME);
        user.setUserLastName(LAST_NAME);

        UserModel userModel = userModelDataMapper.transform(user);

        assertThat("not instance of UserModel", userModel, is(instanceOf(UserModel.class)));
        assertThat("invalid username", expectedUsername, is(userModel.getUserName()));
    }


    public void testTransformUserCollection() {

        User userOne = mock(User.class);
        User userTwo = mock(User.class);

        Collection<User> userCollection = new ArrayList<>(5);
        userCollection.add(userOne);
        userCollection.add(userTwo);

        Collection<UserModel> userModelCollection = userModelDataMapper.transform(userCollection);

        assertThat("invalid list size", userModelCollection.size(), is(2));
        assertThat(userModelCollection.toArray()[0], is(instanceOf(UserModel.class)));
        assertThat(userModelCollection.toArray()[1], is(instanceOf(UserModel.class)));

    }
}
