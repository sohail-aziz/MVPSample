package aziz.sohail.MVPsample.presentation;

import android.os.Handler;
import android.os.Looper;

import aziz.sohail.MVPsample.domain.executor.PostExecutionThread;

/**
 * Created by Sohail Aziz on 8/12/2015.
 * UI thread Singletone on Demand pattern
 */
public class UIThread implements PostExecutionThread {

    private static class LazyHolder {
        private static final UIThread INSTANCE = new UIThread();
    }

    public static UIThread getInstance() {
        return LazyHolder.INSTANCE;
    }

    private final Handler handler;

    public UIThread() {
        handler = new Handler(Looper.getMainLooper());
    }

    /**
     * {@inheritDoc}
     *
     * @param runnable
     */
    @Override
    public void post(Runnable runnable) {
        if (runnable == null) {
            throw new IllegalArgumentException("runnable cannot be null");
        }

        handler.post(runnable);
    }
}
