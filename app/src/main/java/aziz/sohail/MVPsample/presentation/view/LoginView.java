package aziz.sohail.MVPsample.presentation.view;

/**
 * Created by Sohail Aziz on 8/5/2015.
 *
 */

import android.content.Context;

/**
 * Interface representing a View for userLogin
 */
public interface LoginView {

    /**
     * Show a progress
     */
    void showProgress();

    /**
     * Hide a progress
     */
    void hideProgress();

    /**
     * Called on Success
     */
    void onSuccess();

    /**
     * Called on Failure
     */
    void onError(String error);

    Context getContext();
}
