package aziz.sohail.MVPsample.data;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import aziz.sohail.MVPsample.data.respository.UserDataRepository;
import aziz.sohail.MVPsample.data.respository.UserRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

/**
 * Created by Sohail Aziz on 8/13/2015.
 */
public class UserRepositoryTest {

    @Mock
    UserRepository.UserCallback mockUserCallback;

    UserRepository userRepository;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);
        userRepository = UserDataRepository.getInstance();
    }

    @Test
    public void testValidationSuccess() {

        userRepository.validateUser("sohail", "aziz", mockUserCallback);

        verify(mockUserCallback).onValidateSuccess();
    }

    @Test
    public void testValidationError() {

        userRepository.validateUser("abc", "abc", mockUserCallback);

        verify(mockUserCallback).onValidateError(any(Exception.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateException() {

        userRepository.validateUser(null, null, null);

    }


}

