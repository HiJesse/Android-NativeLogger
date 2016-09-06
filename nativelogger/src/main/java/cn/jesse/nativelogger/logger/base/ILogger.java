package cn.jesse.nativelogger.logger.base;

import cn.jesse.nativelogger.logger.LoggerLevel;

/**
 * Created by jesse on 9/6/16.
 */
public interface ILogger {
    void setTag(String tag);
    String tag();

    boolean isDebugEnabled();

    void debug(String msg);

    void debug(String format, Object arg);

    void debug(String format, Object argA, Object argB);

    void debug(String format, Object... arguments);

    void debug(String msg, Throwable t);

    boolean isInfoEnabled();

    void info(String msg);

    void info(String format, Object arg);

    void info(String format, Object argA, Object argB);

    void info(String format, Object... arguments);

    void info(String msg, Throwable t);

    boolean isWarnEnabled();

    void warn(String msg);

    void warn(String format, Object arg);

    void warn(String format, Object... arguments);

    void warn(String format, Object argA, Object argB);

    void warn(String msg, Throwable t);

    boolean isErrorEnabled();

    void error(String msg);

    void error(String format, Object arg);

    void error(String format, Object argA, Object argB);

    void error(String format, Object... arguments);

    void error(String msg, Throwable t);

    boolean isEnabled(LoggerLevel level);

    void log(LoggerLevel level, String msg);

    void log(LoggerLevel level, String format, Object arg);

    void log(LoggerLevel level, String format, Object argA, Object argB);

    void log(LoggerLevel level, String format, Object... arguments);

    void log(LoggerLevel level, String msg, Throwable t);
}
