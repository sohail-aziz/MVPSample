package aziz.sohail.MVPsample.domain.interactor;

import android.support.annotation.NonNull;

import aziz.sohail.MVPsample.data.respository.UserRepository;
import aziz.sohail.MVPsample.domain.executor.PostExecutionThread;
import aziz.sohail.MVPsample.domain.executor.ThreadExecutor;

/**
 * Created by Sohail Aziz on 8/5/2015.
 */
public class LoginUseCase implements Runnable {


    private final ThreadExecutor jobExecutor;
    private final PostExecutionThread uiThread;
    private final UserRepository userRepository;
    private LoginListener listener;

    private String userName, password;

    public LoginUseCase(ThreadExecutor jobExecutor, PostExecutionThread uiThread, UserRepository userRepository) {
        this.jobExecutor = jobExecutor;
        this.uiThread = uiThread;
        this.userRepository = userRepository;
    }

    public void login(@NonNull final String username, @NonNull final String password, final LoginListener listener) {

        this.listener = listener;
        this.userName = username;
        this.password = password;
        this.jobExecutor.execute(this);

    }

    private void notifyFailure(final Exception e) {
        this.uiThread.post(new Runnable() {
            @Override
            public void run() {
                listener.onError(e);
            }
        });
    }

    private void notifySuccess() {

        this.uiThread.post(new Runnable() {
            @Override
            public void run() {
                listener.onDone();
            }
        });
    }

    @Override
    public void run() {


        userRepository.validateUser(userName, password, new UserRepository.UserCallback() {
            @Override
            public void onValidateSuccess() {
                notifySuccess();
            }

            @Override
            public void onValidateError(Exception e) {
                notifyFailure(e);
            }
        });

    }
}
