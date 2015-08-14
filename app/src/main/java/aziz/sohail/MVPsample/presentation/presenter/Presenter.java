package aziz.sohail.MVPsample.presentation.presenter;

/**
 * Created by Sohail Aziz on 8/5/2015.
 */

/**
 * Base Presenter for presentation layer
 */
public interface Presenter {

    /**
     * Method that controls the lifecycle of view, It should be called in {Activity or Fragment}'s onResume;
     */
    void onResume();

    /**
     * * Method that controls the lifecycle of view, It should be called in {Activity or Fragment}'s onPause;
     */
    void onPause();

    /**
     * * Method that controls the lifecycle of view, It should be called in {Activity or Fragment}'s onDestroy;
     */
    void onDestroy();
}
