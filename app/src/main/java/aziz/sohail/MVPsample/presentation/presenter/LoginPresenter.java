package aziz.sohail.MVPsample.presentation.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import aziz.sohail.MVPsample.domain.interactor.LoginListener;
import aziz.sohail.MVPsample.domain.interactor.LoginUseCase;
import aziz.sohail.MVPsample.presentation.exception.ErrorMessageFactory;
import aziz.sohail.MVPsample.presentation.view.LoginView;

/**
 * Created by Sohail Aziz on 8/5/2015.
 */
public class LoginPresenter implements Presenter, LoginListener {

    private static final String TAG = "LoginPresenter";
    private LoginView loginView;
    private LoginUseCase loginUseCase;

    public LoginPresenter(@NonNull LoginUseCase loginUseCase) {

        this.loginUseCase = loginUseCase;
    }

    public void setView(@NonNull LoginView view) {
        this.loginView = view;
    }

    public void login(@NonNull final String username, @NonNull final String password) {

        loginView.showProgress();
        loginUseCase.login(username, password, this);
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onDone() {
        Log.d(TAG, "onDone");
        loginView.hideProgress();
        loginView.onSuccess();
    }

    @Override
    public void onError(Exception e) {
        Log.d(TAG, "onError");
        String errorMessage = ErrorMessageFactory.create(this.loginView.getContext(), e);
        loginView.hideProgress();
        loginView.onError(errorMessage);
    }
}
