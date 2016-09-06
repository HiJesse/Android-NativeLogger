package cn.jesse.nativelogger.logger;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import cn.jesse.nativelogger.logger.base.AbstractLogger;
import cn.jesse.nativelogger.logger.base.IFileLogger;
import cn.jesse.nativelogger.util.DateUtils;

/**
 * Created by jesse on 9/6/16.
 */
public class FileLogger extends AbstractLogger implements IFileLogger{
    final transient Logger logger;
    private StringBuffer directory;

    public FileLogger(String tag) {
        super(tag);
        this.logger = Logger.getLogger(tag);
        logger.setUseParentHandlers(false);
    }


    @Override
    public void setLogDirectory(String dir) {
        directory = new StringBuffer(dir);
        if (!dir.endsWith("/"))
            directory.append("/");

        directory.append(DateUtils.getCurrentDate());


        File file = new File(directory.toString());
        FileHandler fh;
        try {
            fh = new FileHandler(file.toString(), true);
            fh.setFormatter( new SimpleFormatter() );

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
    public void info(String msg) {
        logger.info(msg);
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
    public void warn(String msg) {
        logger.warning(msg);
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
