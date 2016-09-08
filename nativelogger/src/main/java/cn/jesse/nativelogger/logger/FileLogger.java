package cn.jesse.nativelogger.logger;

import android.os.Handler;
import android.os.HandlerThread;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import cn.jesse.nativelogger.formatter.TagFormatter;
import cn.jesse.nativelogger.logger.base.AbstractLogger;
import cn.jesse.nativelogger.logger.base.IFileLogger;
import cn.jesse.nativelogger.util.DateUtils;

/**
 * Created by jesse on 9/6/16.
 */
public class FileLogger extends AbstractLogger implements IFileLogger{
    final transient Logger logger;
    private StringBuffer directory;
    private Formatter formatter;

    private HandlerThread fileLoggerThread;
    private Handler handler;

    public FileLogger(String tag) {
        super(tag);

        fileLoggerThread = new HandlerThread(FileLogger.class.getSimpleName());
        fileLoggerThread.start();
        handler = new Handler(fileLoggerThread.getLooper());

        this.logger = Logger.getLogger(tag);
        logger.setUseParentHandlers(false);
    }


    @Override
    public void setFilePathAndFormatter(String dir, Formatter formatter) {
        directory = new StringBuffer(dir);
        this.formatter = formatter;
        if (!dir.endsWith("/"))
            directory.append("/");

        directory.append(DateUtils.getCurrentDate());


        File file = new File(directory.toString());
        FileHandler fh;
        try {
            fh = new FileHandler(file.toString(), true);
            fh.setFormatter(formatter);

            logger.addHandler(fh);
        } catch (IOException e) {
            //unused
        }
    }

    @Override
    public String logDirectory() {
        return null == directory ? null : directory.toString();
    }

    @Override
    public Formatter fileFormatter() {
        return this.formatter;
    }

    @Override
    public void setLevel(LoggerLevel level) {
        if (LoggerLevel.DEBUG == level)
            logger.setLevel(Level.FINE);
        else if (LoggerLevel.INFO == level)
            logger.setLevel(Level.INFO);
        else if (LoggerLevel.WARN == level)
            logger.setLevel(Level.WARNING);
        else if (LoggerLevel.ERROR == level)
            logger.setLevel(Level.SEVERE);
        else if (LoggerLevel.OFF == level)
            logger.setLevel(Level.OFF);
    }

    private synchronized void log(Level level, String msg, Throwable t) {
        LogRecord record = new LogRecord(level, msg);
        record.setLoggerName(tag);
        record.setThrown(t);
        logger.log(record);
    }

    @Override
    public boolean isDebugEnabled() {
        return logger.isLoggable(Level.FINE);
    }

    @Override
    public void debug(String msg) {
        if (isDebugEnabled())
            log(Level.FINE, msg, null);
    }

    @Override
    public void debug(String subTag, String msg) {

    }

    @Override
    public void debug(String subTag, String format, Object arg) {

    }

    @Override
    public void debug(String subTag, String format, Object argA, Object argB) {

    }

    @Override
    public void debug(String subTag, String format, Object... arguments) {

    }

    @Override
    public void debug(String subTag, Throwable t) {

    }

    @Override
    public boolean isInfoEnabled() {
        return logger.isLoggable(Level.INFO);
    }

    @Override
    public void info(final String msg) {
        if (!isInfoEnabled())
            return;
        handler.post(new Runnable() {
            @Override
            public void run() {
                log(Level.INFO, msg, null);
            }
        });
    }

    @Override
    public void info(final String subTag, final String msg) {
        if (!isInfoEnabled())
            return;
        handler.post(new Runnable() {
            @Override
            public void run() {
                log(Level.INFO, TagFormatter.format(subTag, msg), null);
            }
        });
    }

    @Override
    public void info(final String subTag, final String format, final Object arg) {
        if (!isInfoEnabled())
            return;
        handler.post(new Runnable() {
            @Override
            public void run() {
                log(Level.INFO, TagFormatter.format(subTag, format, arg), null);
            }
        });
    }

    @Override
    public void info(final String subTag, final String format, final Object argA, final Object argB) {
        if (!isInfoEnabled())
            return;
        handler.post(new Runnable() {
            @Override
            public void run() {
                log(Level.INFO, TagFormatter.format(subTag, format, argA, argB), null);
            }
        });
    }

    @Override
    public void info(final String subTag, final String format, final Object... arguments) {
        if (!isInfoEnabled())
            return;
        handler.post(new Runnable() {
            @Override
            public void run() {
                log(Level.INFO, TagFormatter.format(subTag, format, arguments), null);
            }
        });
    }

    @Override
    public void info(final String subTag, final Throwable t) {
        if (!isInfoEnabled())
            return;
        log(Level.INFO, subTag, t);
    }


    @Override
    public boolean isWarnEnabled() {
        return logger.isLoggable(Level.WARNING);
    }

    @Override
    public void warn(final String msg) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                log(Level.WARNING, msg, null);
            }
        });
    }

    @Override
    public void warn(String subTag, String msg) {

    }

    @Override
    public void warn(String subTag, String format, Object arg) {

    }

    @Override
    public void warn(String subTag, String format, Object... arguments) {

    }

    @Override
    public void warn(String subTag, String format, Object argA, Object argB) {

    }

    @Override
    public void warn(String subTag, Throwable t) {

    }


    @Override
    public boolean isErrorEnabled() {
        return logger.isLoggable(Level.SEVERE);
    }

    @Override
    public void error(String msg) {
    }

    @Override
    public void error(String subTag, String msg) {

    }

    @Override
    public void error(String subTag, String format, Object arg) {

    }

    @Override
    public void error(String subTag, String format, Object argA, Object argB) {

    }

    @Override
    public void error(String subTag, String format, Object... arguments) {

    }

    @Override
    public void error(String subTag, Throwable t) {

    }

}
