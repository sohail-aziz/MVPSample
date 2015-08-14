package aziz.sohail.MVPsample.domain.interactor;

/**
 * Created by Sohail Aziz on 8/8/2015.
 */
public interface LoginListener {
    void onDone();

    void onError(Exception e);
}
