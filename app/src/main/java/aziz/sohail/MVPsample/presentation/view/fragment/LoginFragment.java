package aziz.sohail.MVPsample.presentation.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import aziz.sohail.MVPsample.R;
import aziz.sohail.MVPsample.data.executor.JobExecutor;
import aziz.sohail.MVPsample.data.respository.UserDataRepository;
import aziz.sohail.MVPsample.data.respository.UserRepository;
import aziz.sohail.MVPsample.domain.executor.PostExecutionThread;
import aziz.sohail.MVPsample.domain.executor.ThreadExecutor;
import aziz.sohail.MVPsample.domain.interactor.LoginUseCase;
import aziz.sohail.MVPsample.presentation.UIThread;
import aziz.sohail.MVPsample.presentation.presenter.LoginPresenter;
import aziz.sohail.MVPsample.presentation.view.LoginView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link aziz.sohail.MVPsample.presentation.view.fragment.BaseFragment} subclass for User login
 */
public class LoginFragment extends BaseFragment implements LoginView {


    private static final String TAG = "LoginFragment";
    @Bind(R.id.editTextUsernameFragmentLogin)
    EditText editTextUsername;
    @Bind(R.id.editTextPasswordFragmentLogin)
    EditText editTextPassword;
    @Bind(R.id.buttonLoginFragmentLogin)
    Button buttonLogin;
    @Bind(R.id.progressBarFragmentLogin)
    ProgressBar progressBarLoading;

    private LoginPresenter loginPresenter;

    public LoginFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);


        Log.d(TAG, "savedInstance not null");
        ThreadExecutor threadExecutor = JobExecutor.getInstance();
        PostExecutionThread postExecutionThread = UIThread.getInstance();
        UserRepository userRepository = UserDataRepository.getInstance();
        loginPresenter = new LoginPresenter(new LoginUseCase(threadExecutor, postExecutionThread, userRepository));
        loginPresenter.setView(this);

        hideProgress();
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // outState.putBoolean("saved", true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.buttonLoginFragmentLogin)
    public void onLogin() {

        final String userName = editTextUsername.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();

        loginPresenter.login(userName, password);
    }

    @Override
    public void showProgress() {
        progressBarLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBarLoading.setVisibility(View.GONE);
    }

    @Override
    public void onSuccess() {
        showToast("Login successful");


    }

    @Override
    public void onError(String error) {

        showToast(error);

    }

    @Override
    public Context getContext() {
        return getActivity().getApplicationContext();
    }
}