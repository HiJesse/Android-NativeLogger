package cn.jesse.nativelogger.logger.base;

import cn.jesse.nativelogger.logger.LoggerLevel;

/**
 * Created by jesse on 9/6/16.
 */
public abstract class AbstractLogger implements ILogger{
    protected String tag;

    protected AbstractLogger(String tag) {
        if (tag == null) {
            throw new NullPointerException("tag is null");
        }
        this.tag = tag;
    }

    @Override
    public String tag() {
        return tag;
    }

    @Override
    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public boolean isEnabled(LoggerLevel level) {
        switch (level) {
            case DEBUG:
                return isDebugEnabled();
            case INFO:
                return isInfoEnabled();
            case WARN:
                return isWarnEnabled();
            case ERROR:
                return isErrorEnabled();
            default:
                throw new Error("unexpected LoggerLevel");
        }
    }

    @Override
    public void log(LoggerLevel level, String subTag, Throwable cause) {
        switch (level) {
            case DEBUG:
                debug(subTag, cause);
                break;
            case INFO:
                info(subTag, cause);
                break;
            case WARN:
                warn(subTag, cause);
                break;
            case ERROR:
                error(subTag, cause);
                break;
            default:
                throw new Error("unexpected LoggerLevel");
        }
    }

    @Override
    public void log(LoggerLevel level, String msg) {
        switch (level) {
            case DEBUG:
                debug(msg);
                break;
            case INFO:
                info(msg);
                break;
            case WARN:
                warn(msg);
                break;
            case ERROR:
                error(msg);
                break;
            default:
                throw new Error("unexpected LoggerLevel");
        }
    }

    @Override
    public void log(LoggerLevel level, String subTag, String msg) {
        switch (level) {
            case DEBUG:
                debug(subTag, msg);
                break;
            case INFO:
                info(subTag, msg);
                break;
            case WARN:
                warn(subTag, msg);
                break;
            case ERROR:
                error(subTag, msg);
                break;
            default:
                throw new Error("unexpected LoggerLevel");
        }
    }

    @Override
    public void log(LoggerLevel level, String subTag, String format, Object arg) {
        switch (level) {
            case DEBUG:
                debug(subTag, format, arg);
                break;
            case INFO:
                info(subTag, format, arg);
                break;
            case WARN:
                warn(subTag, format, arg);
                break;
            case ERROR:
                error(subTag, format, arg);
                break;
            default:
                throw new Error("unexpected LoggerLevel");
        }
    }

    @Override
    public void log(LoggerLevel level, String subTag, String format, Object argA, Object argB) {
        switch (level) {
            case DEBUG:
                debug(subTag, format, argA, argB);
                break;
            case INFO:
                info(subTag, format, argA, argB);
                break;
            case WARN:
                warn(subTag, format, argA, argB);
                break;
            case ERROR:
                error(subTag, format, argA, argB);
                break;
            default:
                throw new Error("unexpected LoggerLevel");
        }
    }

    @Override
    public void log(LoggerLevel level, String subTag, String format, Object... arguments) {
        switch (level) {
            case DEBUG:
                debug(subTag, format, arguments);
                break;
            case INFO:
                info(subTag, format, arguments);
                break;
            case WARN:
                warn(subTag, format, arguments);
                break;
            case ERROR:
                error(subTag, format, arguments);
                break;
            default:
                throw new Error("unexpected LoggerLevel");
        }
    }
}
