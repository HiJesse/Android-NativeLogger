package cn.jesse.nativelogger;

import cn.jesse.nativelogger.logger.LoggerLevel;
import cn.jesse.nativelogger.logger.base.IFileLogger;
import cn.jesse.nativelogger.logger.base.ILogger;

/**
 * Created by jesse on 9/6/16.
 */
public abstract class AbstractNativeLogger {
    abstract ILogger getDefaultLogger();
    abstract ILogger getFileLogger();

    public static void zipLogs(IFileLogger.OnZipListener listener) {
        IFileLogger fileLogger = (IFileLogger)NLogger.getInstance().getFileLogger();

        if (null == fileLogger) {
            w("unexpected zip logs, file logger is null");
            return;
        }
        fileLogger.zipLogs(listener);
    }

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

    public static void d(String tag, String msg) {
        NLogger.getInstance().getDefaultLogger().debug(tag, msg);

        if (NLogger.getInstance().getFileLogger() == null)
            return;

        NLogger.getInstance().getFileLogger().debug(tag, msg);
    }

    public static void d(String tag, String format, Object arg) {
        NLogger.getInstance().getDefaultLogger().debug(tag, format, arg);

        if (NLogger.getInstance().getFileLogger() == null)
            return;

        NLogger.getInstance().getFileLogger().debug(tag, format, arg);
    }

    public static void d(String tag, String format, Object argA, Object argB) {
        NLogger.getInstance().getDefaultLogger().debug(tag, format, argA, argB);

        if (NLogger.getInstance().getFileLogger() == null)
            return;

        NLogger.getInstance().getFileLogger().debug(tag, format, argA, argB);
    }

    public static void d(String tag, String format, Object... args) {
        NLogger.getInstance().getDefaultLogger().debug(tag, format, args);

        if (NLogger.getInstance().getFileLogger() == null)
            return;

        NLogger.getInstance().getFileLogger().debug(tag, format, args);
    }

    public static void d(String tag, Throwable ex) {
        NLogger.getInstance().getDefaultLogger().debug(tag, ex);

        if (NLogger.getInstance().getFileLogger() == null)
            return;

        NLogger.getInstance().getFileLogger().debug(tag, ex);
    }

    public static void w(String msg) {
        NLogger.getInstance().getDefaultLogger().warn(msg);

        if (NLogger.getInstance().getFileLogger() == null)
            return;

        NLogger.getInstance().getFileLogger().warn(msg);
    }

    public static void w(String tag, String msg) {
        NLogger.getInstance().getDefaultLogger().warn(tag, msg);

        if (NLogger.getInstance().getFileLogger() == null)
            return;

        NLogger.getInstance().getFileLogger().warn(tag, msg);
    }

    public static void w(String tag, String format, Object arg) {
        NLogger.getInstance().getDefaultLogger().warn(tag, format, arg);

        if (NLogger.getInstance().getFileLogger() == null)
            return;

        NLogger.getInstance().getFileLogger().warn(tag, format, arg);
    }

    public static void w(String tag, String format, Object argA, Object argB) {
        NLogger.getInstance().getDefaultLogger().warn(tag, format, argA, argB);

        if (NLogger.getInstance().getFileLogger() == null)
            return;

        NLogger.getInstance().getFileLogger().warn(tag, format, argA, argB);
    }

    public static void w(String tag, String format, Object... args) {
        NLogger.getInstance().getDefaultLogger().warn(tag, format, args);

        if (NLogger.getInstance().getFileLogger() == null)
            return;

        NLogger.getInstance().getFileLogger().warn(tag, format, args);
    }

    public static void w(String tag, Throwable ex) {
        NLogger.getInstance().getDefaultLogger().warn(tag, ex);

        if (NLogger.getInstance().getFileLogger() == null)
            return;

        NLogger.getInstance().getFileLogger().warn(tag, ex);
    }

    public static void e(String msg) {
        NLogger.getInstance().getDefaultLogger().error(msg);

        if (NLogger.getInstance().getFileLogger() == null)
            return;

        NLogger.getInstance().getFileLogger().error(msg);
    }

    public static void e(String tag, String msg) {
        NLogger.getInstance().getDefaultLogger().error(tag, msg);

        if (NLogger.getInstance().getFileLogger() == null)
            return;

        NLogger.getInstance().getFileLogger().error(tag, msg);
    }

    public static void e(String tag, String format, Object arg) {
        NLogger.getInstance().getDefaultLogger().error(tag, format, arg);

        if (NLogger.getInstance().getFileLogger() == null)
            return;

        NLogger.getInstance().getFileLogger().error(tag, format, arg);
    }

    public static void e(String tag, String format, Object argA, Object argB) {
        NLogger.getInstance().getDefaultLogger().error(tag, format, argA, argB);

        if (NLogger.getInstance().getFileLogger() == null)
            return;

        NLogger.getInstance().getFileLogger().error(tag, format, argA, argB);
    }

    public static void e(String tag, String format, Object... args) {
        NLogger.getInstance().getDefaultLogger().error(tag, format, args);

        if (NLogger.getInstance().getFileLogger() == null)
            return;

        NLogger.getInstance().getFileLogger().error(tag, format, args);
    }

    public static void e(String tag, Throwable ex) {
        NLogger.getInstance().getDefaultLogger().error(tag, ex);

        if (NLogger.getInstance().getFileLogger() == null)
            return;

        NLogger.getInstance().getFileLogger().error(tag, ex);
    }

    public static void json(LoggerLevel level, String msg) {
        NLogger.getInstance().getDefaultLogger().json(level, msg);

        if (NLogger.getInstance().getFileLogger() == null)
            return;

        NLogger.getInstance().getFileLogger().json(level, msg);
    }

    public static void json(LoggerLevel level, String subTag, String msg) {
        NLogger.getInstance().getDefaultLogger().json(level, subTag, msg);

        if (NLogger.getInstance().getFileLogger() == null)
            return;

        NLogger.getInstance().getFileLogger().json(level, subTag, msg);
    }
}
