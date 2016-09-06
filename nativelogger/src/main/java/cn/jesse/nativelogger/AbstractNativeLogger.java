package cn.jesse.nativelogger;

import cn.jesse.nativelogger.logger.base.ILogger;

/**
 * Created by jesse on 9/6/16.
 */
public abstract class AbstractNativeLogger {
    abstract ILogger getDefaultLogger();
    abstract ILogger getFileLogger();

    public static void i(String msg) {
        NLogger.getInstance().getDefaultLogger().info(msg);

        if (NLogger.getInstance().getFileLogger() == null)
            return;

        NLogger.getInstance().getFileLogger().info(msg);
    }

    public static void d(String msg) {
        NLogger.getInstance().getDefaultLogger().debug(msg);

        if (NLogger.getInstance().getFileLogger() == null)
            return;

        NLogger.getInstance().getFileLogger().debug(msg);
    }

    public static void w(String msg) {
        NLogger.getInstance().getDefaultLogger().warn(msg);

        if (NLogger.getInstance().getFileLogger() == null)
            return;

        NLogger.getInstance().getFileLogger().warn(msg);
    }

    public static void e(String msg) {
        NLogger.getInstance().getDefaultLogger().error(msg);

        if (NLogger.getInstance().getFileLogger() == null)
            return;

        NLogger.getInstance().getFileLogger().error(msg);
    }
}
