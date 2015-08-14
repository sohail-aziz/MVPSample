package aziz.sohail.MVPsample.domain.executor;

/**
 * Created by Sohail Aziz on 8/12/2015.
 * Thread execution abstraction to change context from one thread to any other.
 */
public interface PostExecutionThread {

    /**
     * Post {@link java.lang.Runnable} to UI thread.
     *
     * @param runnable
     */
    void post(Runnable runnable);
}
