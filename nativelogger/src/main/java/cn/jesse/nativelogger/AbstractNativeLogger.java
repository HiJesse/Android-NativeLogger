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

    public static void i(String tag, String msg) {
        NLogger.getInstance().getDefaultLogger().info(tag, msg);

        if (NLogger.getInstance().getFileLogger() == null)
            return;

        NLogger.getInstance().getFileLogger().info(tag, msg);
    }

    public static void i(String tag, String format, Object arg) {
        NLogger.getInstance().getDefaultLogger().info(tag, format, arg);

        if (NLogger.getInstance().getFileLogger() == null)
            return;

        NLogger.getInstance().getFileLogger().info(tag, format, arg);
    }

    public static void i(String tag, String format, Object argA, Object argB) {
        NLogger.getInstance().getDefaultLogger().info(tag, format, argA, argB);

        if (NLogger.getInstance().getFileLogger() == null)
            return;

        NLogger.getInstance().getFileLogger().info(tag, format, argA, argB);
    }

    public static void i(String tag, String format, Object... args) {
        NLogger.getInstance().getDefaultLogger().info(tag, format, args);

        if (NLogger.getInstance().getFileLogger() == null)
            return;

        NLogger.getInstance().getFileLogger().info(tag, format, args);
    }

    public static void i(String tag, Throwable ex) {
        NLogger.getInstance().getDefaultLogger().info(tag, ex);

        if (NLogger.getInstance().getFileLogger() == null)
            return;

        NLogger.getInstance().getFileLogger().info(tag, ex);
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
