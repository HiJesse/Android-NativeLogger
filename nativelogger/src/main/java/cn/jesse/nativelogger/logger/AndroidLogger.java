package cn.jesse.nativelogger.logger;

import android.util.Log;

import cn.jesse.nativelogger.formatter.TagFormatter;
import cn.jesse.nativelogger.logger.base.AbstractLogger;

/**
 * Created by jesse on 9/6/16.
 */
public class AndroidLogger extends AbstractLogger {
    private boolean debugEnable = true;
    private boolean infoEnable = true;
    private boolean warningEnable = true;
    private boolean errorEnable = true;

    public AndroidLogger(String tag) {
        super(tag);
    }

    @Override
    public void setLevel(LoggerLevel level) {
        if (LoggerLevel.DEBUG == level) {
            debugEnable = true;
            infoEnable = true;
            warningEnable = true;
            errorEnable = true;
        }
        else if (LoggerLevel.INFO == level){
            debugEnable = false;
            infoEnable = true;
            warningEnable = true;
            errorEnable = true;
        }
        else if (LoggerLevel.WARN == level){
            debugEnable = false;
            infoEnable = false;
            warningEnable = true;
            errorEnable = true;
        }
        else if (LoggerLevel.ERROR == level){
            debugEnable = false;
            infoEnable = false;
            warningEnable = false;
            errorEnable = true;
        }
        else if (LoggerLevel.OFF == level){
            debugEnable = false;
            infoEnable = false;
            warningEnable = false;
            errorEnable = false;
        }
    }

    @Override
    public boolean isDebugEnabled() {
        return debugEnable;
    }

    @Override
    public void debug(String msg) {
        if (!isDebugEnabled())
            return;
        Log.d(tag, msg);
    }

    @Override
    public void debug(String subTag, String msg) {
        if (!isDebugEnabled())
            return;
        Log.d(tag, TagFormatter.format(subTag, msg));
    }

    @Override
    public void debug(String subTag, String format, Object arg) {
        if (!isDebugEnabled())
            return;
        Log.d(tag, TagFormatter.format(subTag, format, arg));
    }

    @Override
    public void debug(String subTag, String format, Object argA, Object argB) {
        if (!isDebugEnabled())
            return;
        Log.d(tag, TagFormatter.format(subTag, format, argA, argB));
    }

    @Override
    public void debug(String subTag, String format, Object... arguments) {
        if (!isDebugEnabled())
            return;
        Log.d(tag, TagFormatter.format(subTag, format, arguments));
    }

    @Override
    public void debug(String subTag, Throwable t) {
        if (!isDebugEnabled())
            return;
        Log.d(tag, subTag + " " + TagFormatter.format(t));
    }

    @Override
    public boolean isInfoEnabled() {
        return infoEnable;
    }

    @Override
    public void info(String msg) {
        if (!isInfoEnabled())
            return;
        Log.i(tag, msg);
    }

    @Override
    public void info(String subTag, String msg) {
        if (!isInfoEnabled())
            return;
        Log.i(tag, TagFormatter.format(subTag, msg));
    }

    @Override
    public void info(String subTag, String format, Object arg) {
        if (!isInfoEnabled())
            return;
        Log.i(tag, TagFormatter.format(subTag, format, arg));
    }

    @Override
    public void info(String subTag, String format, Object argA, Object argB) {
        if (!isInfoEnabled())
            return;
        Log.i(tag, TagFormatter.format(subTag, format, argA, argB));
    }

    @Override
    public void info(String subTag, String format, Object... arguments) {
        if (!isInfoEnabled())
            return;
        Log.i(tag, TagFormatter.format(subTag, format, arguments));
    }

    @Override
    public void info(String subTag, Throwable t) {
        if (!isInfoEnabled())
            return;
        Log.i(tag, subTag + " " + TagFormatter.format(t));
    }

    @Override
    public boolean isWarnEnabled() {
        return warningEnable;
    }

    @Override
    public void warn(String msg) {
        if (!isWarnEnabled())
            return;
        Log.w(tag, msg);
    }

    @Override
    public void warn(String subTag, String msg) {
        if (!isWarnEnabled())
            return;
        Log.w(tag, TagFormatter.format(subTag, msg));
    }

    @Override
    public void warn(String subTag, String format, Object arg) {
        if (!isWarnEnabled())
            return;
        Log.w(tag, TagFormatter.format(subTag, format, arg));
    }

    @Override
    public void warn(String subTag, String format, Object... arguments) {
        if (!isWarnEnabled())
            return;
        Log.w(tag, TagFormatter.format(subTag, format, arguments));
    }

    @Override
    public void warn(String subTag, String format, Object argA, Object argB) {
        if (!isWarnEnabled())
            return;
        Log.w(tag, TagFormatter.format(subTag, format, argA, argB));
    }

    @Override
    public void warn(String subTag, Throwable t) {
        if (!isWarnEnabled())
            return;
        Log.w(tag, subTag + " " + TagFormatter.format(t));
    }

    @Override
    public boolean isErrorEnabled() {
        return errorEnable;
    }

    @Override
    public void error(String msg) {
        if (!isErrorEnabled())
            return;
        Log.e(tag, msg);
    }

    @Override
    public void error(String subTag, String msg) {
        if (!isErrorEnabled())
            return;
        Log.e(tag, TagFormatter.format(subTag, msg));
    }

    @Override
    public void error(String subTag, String format, Object arg) {
        if (!isErrorEnabled())
            return;
        Log.e(tag, TagFormatter.format(subTag, format, arg));
    }

    @Override
    public void error(String subTag, String format, Object argA, Object argB) {
        if (!isErrorEnabled())
            return;
        Log.e(tag, TagFormatter.format(subTag, format, argA, argB));
    }

    @Override
    public void error(String subTag, String format, Object... arguments) {
        if (!isErrorEnabled())
            return;
        Log.e(tag, TagFormatter.format(subTag, format, arguments));
    }

    @Override
    public void error(String subTag, Throwable t) {
        if (!isErrorEnabled())
            return;
        Log.e(tag, subTag + " " + TagFormatter.format(t));
    }
}
