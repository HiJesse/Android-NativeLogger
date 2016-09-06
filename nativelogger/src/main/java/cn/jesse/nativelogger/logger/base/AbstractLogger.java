package cn.jesse.nativelogger.logger.base;

import cn.jesse.nativelogger.logger.LoggerLevel;

/**
 * Created by jesse on 9/6/16.
 */
public abstract class AbstractLogger implements ILogger{
    private final String tag;

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
    public void log(LoggerLevel level, String msg, Throwable cause) {
        switch (level) {
            case DEBUG:
                debug(msg, cause);
                break;
            case INFO:
                info(msg, cause);
                break;
            case WARN:
                warn(msg, cause);
                break;
            case ERROR:
                error(msg, cause);
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
    public void log(LoggerLevel level, String format, Object arg) {
        switch (level) {
            case DEBUG:
                debug(format, arg);
                break;
            case INFO:
                info(format, arg);
                break;
            case WARN:
                warn(format, arg);
                break;
            case ERROR:
                error(format, arg);
                break;
            default:
                throw new Error("unexpected LoggerLevel");
        }
    }

    @Override
    public void log(LoggerLevel level, String format, Object argA, Object argB) {
        switch (level) {
            case DEBUG:
                debug(format, argA, argB);
                break;
            case INFO:
                info(format, argA, argB);
                break;
            case WARN:
                warn(format, argA, argB);
                break;
            case ERROR:
                error(format, argA, argB);
                break;
            default:
                throw new Error("unexpected LoggerLevel");
        }
    }

    @Override
    public void log(LoggerLevel level, String format, Object... arguments) {
        switch (level) {
            case DEBUG:
                debug(format, arguments);
                break;
            case INFO:
                info(format, arguments);
                break;
            case WARN:
                warn(format, arguments);
                break;
            case ERROR:
                error(format, arguments);
                break;
            default:
                throw new Error("unexpected LoggerLevel");
        }
    }
}
