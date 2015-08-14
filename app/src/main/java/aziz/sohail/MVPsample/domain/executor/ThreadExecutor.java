package aziz.sohail.MVPsample.domain.executor;

/**
 * Created by Sohail Aziz on 8/12/2015.
 * Executes {@link java.lang.Runnable} asynchronously out of UI thread.
 */
public interface ThreadExecutor {

    /**
     * Executes {@link java.lang.Runnable}
     * @param runnable
     */
    public void execute(final Runnable runnable);
}
