package cn.jesse.nativelogger.util;

/**
 * Created by jesse on 9/5/16.
 */
public class CrashWatcher implements Thread.UncaughtExceptionHandler {
    private static CrashWatcher mInstance = new CrashWatcher();
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    private UncaughtExceptionListener listener;

    private CrashWatcher() {
    }

    public static CrashWatcher getInstance() {
        return mInstance;
    }

    public void init() {
        if (null != mDefaultHandler)
            return;
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void setListener(UncaughtExceptionListener listener) {
        this.listener = listener;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        if (null != listener)
            listener.uncaughtException(thread, ex);
    }

    public interface UncaughtExceptionListener {
        void uncaughtException(Thread thread, Throwable ex);
    }
}
