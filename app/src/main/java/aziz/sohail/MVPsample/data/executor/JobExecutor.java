package aziz.sohail.MVPsample.data.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import aziz.sohail.MVPsample.domain.executor.ThreadExecutor;

/**
 * Created by Sohail Aziz on 8/12/2015.
 * An implementation on {@link java.util.concurrent.ThreadPoolExecutor} in on demand Singleton pattern
 */
public class JobExecutor implements ThreadExecutor {

    private static class LazyHolder {
        private static final JobExecutor INSTANCE = new JobExecutor();
    }

    public static JobExecutor getInstance() {
        return LazyHolder.INSTANCE;
    }

    /* initial pool size*/
    private static final int CORE_POOL_SIZE = 3;
    /*max pool size*/
    private static final int MAX_POOL_SIZE = 10;
    /* Idle time before thread is terminated*/
    private static final long KEEP_ALIVE_TIME = 10;
    private final TimeUnit TIME_UNIT = TimeUnit.SECONDS;

    private ThreadPoolExecutor threadPoolExecutor;
    private BlockingQueue<Runnable> workQueue;

    public JobExecutor() {

        workQueue = new LinkedBlockingQueue<>();
        threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TIME_UNIT, workQueue);
    }

    /**
     * {@inheritDoc}
     *
     * @param runnable
     */
    @Override
    public void execute(Runnable runnable) {

        if (runnable == null) {
            throw new IllegalArgumentException("runnable cannot be null");
        }

        threadPoolExecutor.execute(runnable);
    }
}
