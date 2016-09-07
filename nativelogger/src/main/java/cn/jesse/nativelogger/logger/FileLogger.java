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

    private synchronized void log(Level level, String msg, Throwable t) {
        LogRecord record = new LogRecord(level, msg);
        record.setLoggerName(tag);
        record.setThrown(t);
        logger.log(record);
    }

    @Override
    public boolean isDebugEnabled() {
        return false;
    }

    @Override
    public void debug(String msg) {

    }

    @Override
    public void debug(String format, Object arg) {

    }

    @Override
    public void debug(String format, Object argA, Object argB) {

    }

    @Override
    public void debug(String format, Object... arguments) {

    }

    @Override
    public void debug(String msg, Throwable t) {

    }

    @Override
    public boolean isInfoEnabled() {
        return false;
    }

    @Override
    public void info(final String msg) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                log(Level.INFO, msg, null);
            }
        });
    }

    @Override
    public void info(String format, Object arg) {

    }

    @Override
    public void info(String format, Object argA, Object argB) {

    }

    @Override
    public void info(String format, Object... arguments) {

    }

    @Override
    public void info(String msg, Throwable t) {

    }

    @Override
    public boolean isWarnEnabled() {
        return false;
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
    public void warn(String format, Object arg) {

    }

    @Override
    public void warn(String format, Object... arguments) {

    }

    @Override
    public void warn(String format, Object argA, Object argB) {

    }

    @Override
    public void warn(String msg, Throwable t) {

    }

    @Override
    public boolean isErrorEnabled() {
        return false;
    }

    @Override
    public void error(String msg) {
    }

    @Override
    public void error(String format, Object arg) {

    }

    @Override
    public void error(String format, Object argA, Object argB) {

    }

    @Override
    public void error(String format, Object... arguments) {

    }

    @Override
    public void error(String msg, Throwable t) {

    }
}
