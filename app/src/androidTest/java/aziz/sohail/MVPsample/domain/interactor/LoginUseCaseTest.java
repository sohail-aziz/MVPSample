package aziz.sohail.MVPsample.domain.interactor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import aziz.sohail.MVPsample.data.respository.UserRepository;
import aziz.sohail.MVPsample.domain.executor.PostExecutionThread;
import aziz.sohail.MVPsample.domain.executor.ThreadExecutor;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * Created by Sohail Aziz on 8/11/2015.
 */
public class LoginUseCaseTest {

    final String USER_NAME = "sohail";
    final String PASSWORD = "aziz";

    @Mock
    LoginListener mockLoginListener;
    @Mock
    LoginUseCase mockLoginUseCase;

    @Mock
    ThreadExecutor mockThreadExecutor;
    @Mock
    PostExecutionThread mockPostExecutionThread;
    @Mock
    UserRepository mockUserRepository;


    LoginUseCase loginUseCase;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);

        loginUseCase = new LoginUseCase(mockThreadExecutor, mockPostExecutionThread, mockUserRepository);
    }

    @Test
    public void testExecutor() {


        loginUseCase.login(USER_NAME, PASSWORD, mockLoginListener);

        verify(mockThreadExecutor).execute(any(Runnable.class));

        verifyNoMoreInteractions(mockThreadExecutor);
        verifyZeroInteractions(mockUserRepository);
        verifyZeroInteractions(mockPostExecutionThread);

    }


    @Test
    public void testInteractor() {

        loginUseCase.login("sohail", "aziz", mockLoginListener);
        loginUseCase.run();

        verify(mockThreadExecutor).execute(any(Runnable.class));
        verify(mockUserRepository).validateUser(anyString(), anyString(), any(UserRepository.UserCallback.class));

        verifyNoMoreInteractions(mockThreadExecutor);
        verifyNoMoreInteractions(mockUserRepository);

    }

    @Test
    public void testLoginSuccess() {

        final LoginListener mockLoginListener = mock(LoginListener.class);

        doNothing().when(mockThreadExecutor).execute(any(Runnable.class));

        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                ((UserRepository.UserCallback) invocation.getArguments()[2]).onValidateSuccess();
                return null;
            }
        }).when(mockUserRepository).validateUser(anyString(), anyString(), any(UserRepository.UserCallback.class));

        loginUseCase.login("sohail", "aziz", mockLoginListener);
        loginUseCase.run();


        verify(mockPostExecutionThread).post(any(Runnable.class));

    }

    @Test
    public void testLoginFailure() {


        final Exception mockException = mock(Exception.class);


        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                ((UserRepository.UserCallback) invocationOnMock.getArguments()[2]).onValidateError(mockException);
                return null;
            }
        }).when(mockUserRepository).validateUser(anyString(), anyString(), any(UserRepository.UserCallback.class));

        loginUseCase.login("sohail", "aziz", mockLoginListener);
        loginUseCase.run();

        verify(mockPostExecutionThread).post(any(Runnable.class));
    }

}
