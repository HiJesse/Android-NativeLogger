package cn.jesse.nativelogger.logger.base;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cn.jesse.nativelogger.NLoggerError;
import cn.jesse.nativelogger.logger.LoggerLevel;

/**
 * Created by jesse on 9/6/16.
 */
public abstract class AbstractLogger implements ILogger{
    protected String tag;
    private static final String ERROR_FORMAT = "unexpected format";
    private static final String ERROR_LEVEL = "unexpected LoggerLevel";
    private static final int JSON_INDENT = 2;

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
                throw new NLoggerError(ERROR_LEVEL);
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
                throw new NLoggerError(ERROR_LEVEL);
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
                throw new NLoggerError(ERROR_LEVEL);
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
                throw new NLoggerError(ERROR_LEVEL);
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
                throw new NLoggerError(ERROR_LEVEL);
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
                throw new NLoggerError(ERROR_LEVEL);
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
                throw new NLoggerError(ERROR_LEVEL);
        }
    }

    @Override
    public void json(LoggerLevel level, String msg) {
        if (!isEnabled(level))
            return;

        String json = parseJson(msg);

        switch (level) {
            case DEBUG:
                debug(json);
                break;
            case INFO:
                info(json);
                break;
            case WARN:
                warn(json);
                break;
            case ERROR:
                error(json);
                break;
            default:
                throw new NLoggerError(ERROR_LEVEL);
        }
    }

    @Override
    public void json(LoggerLevel level, String subTag, String msg) {
        if (!isEnabled(level))
            return;

        String json = parseJson(msg);

        switch (level) {
            case DEBUG:
                debug(subTag, json);
                break;
            case INFO:
                info(subTag, json);
                break;
            case WARN:
                warn(subTag, json);
                break;
            case ERROR:
                error(subTag, json);
                break;
            default:
                throw new NLoggerError(ERROR_LEVEL);
        }
    }

    /**
     *  format json
     * as:
     * <pre>
     * {
     *     "query": "Pizza",
     *     "locations": [
     *         94043,
     *         90210
     *     ]
     * }</pre>
     * @param json
     * @return
     */
    private String parseJson(String json) {
        if (null == json)
            return ERROR_FORMAT;

        try {
            if (json.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(json);
                return jsonObject.toString(JSON_INDENT);
            }
            if (json.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(json);
                return jsonArray.toString(JSON_INDENT);
            }
            return ERROR_FORMAT;
        } catch (JSONException e) {
            error(this.getClass().getSimpleName(), e);
            return ERROR_FORMAT;
        }
    }
}
