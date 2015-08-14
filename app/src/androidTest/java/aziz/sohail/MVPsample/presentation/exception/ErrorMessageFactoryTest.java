package aziz.sohail.MVPsample.presentation.exception;

import android.test.AndroidTestCase;

import aziz.sohail.MVPsample.R;
import aziz.sohail.MVPsample.data.exception.InvalidCredentialException;
import aziz.sohail.MVPsample.data.exception.NetworkConnectionException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Created by Sohail Aziz on 8/10/2015.
 */
public class ErrorMessageFactoryTest extends AndroidTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testNetworkException() {
        String expectedMessage = getContext().getString(R.string.error_network);

        String actualMessage = ErrorMessageFactory.create(getContext(), new NetworkConnectionException());

        assertThat(actualMessage, is(equalTo(expectedMessage)));
    }

    public void testInvalidCredentialsException() {
        String expectedMessage = getContext().getString(R.string.error_credentials);

        String actualMessage = ErrorMessageFactory.create(getContext(), new InvalidCredentialException());

        assertThat(actualMessage, is(equalTo(expectedMessage)));
    }
}
