package cn.jesse.nativelogger.logger.base;

import cn.jesse.nativelogger.logger.LoggerLevel;

/**
 * Created by jesse on 9/6/16.
 */
public interface ILogger {
    void setTag(String tag);
    String tag();

    void setLevel(LoggerLevel level);

    boolean isDebugEnabled();

    void debug(String msg);

    void debug(String subTag, String msg);

    void debug(String subTag, String format, Object arg);

    void debug(String subTag, String format, Object argA, Object argB);

    void debug(String subTag, String format, Object... arguments);

    void debug(String subTag, Throwable t);

    boolean isInfoEnabled();

    void info(String msg);

    void info(String subTag, String msg);

    void info(String subTag, String format, Object arg);

    void info(String subTag, String format, Object argA, Object argB);

    void info(String subTag, String format, Object... arguments);

    void info(String subTag, Throwable t);

    boolean isWarnEnabled();

    void warn(String msg);

    void warn(String subTag, String msg);

    void warn(String subTag, String format, Object arg);

    void warn(String subTag, String format, Object... arguments);

    void warn(String subTag, String format, Object argA, Object argB);

    void warn(String subTag, Throwable t);

    boolean isErrorEnabled();

    void error(String msg);

    void error(String subTag, String msg);

    void error(String subTag, String format, Object arg);

    void error(String subTag, String format, Object argA, Object argB);

    void error(String subTag, String format, Object... arguments);

    void error(String subTag, Throwable t);

    boolean isEnabled(LoggerLevel level);

    void log(LoggerLevel level, String msg);

    void log(LoggerLevel level, String subTag, String msg);

    void log(LoggerLevel level, String subTag, String format, Object arg);

    void log(LoggerLevel level, String subTag, String format, Object argA, Object argB);

    void log(LoggerLevel level, String subTag, String format, Object... arguments);

    void log(LoggerLevel level, String subTag, Throwable t);

    void json(LoggerLevel level, String msg);

    void json(LoggerLevel level, String subTag, String msg);
}
