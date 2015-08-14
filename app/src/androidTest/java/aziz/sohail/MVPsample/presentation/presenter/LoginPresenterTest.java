package aziz.sohail.MVPsample.presentation.presenter;

import android.test.AndroidTestCase;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import aziz.sohail.MVPsample.domain.interactor.LoginListener;
import aziz.sohail.MVPsample.domain.interactor.LoginUseCase;
import aziz.sohail.MVPsample.presentation.view.LoginView;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

/**
 * Created by Sohail Aziz on 8/8/2015.
 */
public class LoginPresenterTest extends AndroidTestCase {

    @Mock
    LoginView mockLoginView;
    @Mock
    LoginUseCase mockLoginUseCase;

    LoginPresenter loginPresenter;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        MockitoAnnotations.initMocks(this);

        loginPresenter = new LoginPresenter(mockLoginUseCase);
    }

    public void testLoginPresenterLogin() {

        loginPresenter.login("sohail", "aziz");

        verify(mockLoginView).showProgress();
        verify(mockLoginUseCase).login(eq("sohail"), eq("aziz"), any(LoginListener.class));
    }
}
