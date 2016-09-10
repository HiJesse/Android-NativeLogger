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
import cn.jesse.nativelogger.util.ZipUtils;

/**
 * Created by jesse on 9/6/16.
 */
public class FileLogger extends AbstractLogger implements IFileLogger{
    final transient Logger logger;
    private String logDir;
    private Formatter formatter;
    private int expiredPeriod;

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
    public void setFilePathAndFormatter(final String dir, Formatter formatter, final int expiredPeriod) {
        this.logDir = dir;
        this.formatter = formatter;
        this.expiredPeriod = expiredPeriod;

        if (!logDir.endsWith("/"))
            logDir += "/";

        File file = new File(logDir + DateUtils.getCurrentDate());
        FileHandler fh;
        try {
            fh = new FileHandler(file.toString(), true);
            fh.setFormatter(formatter);

            logger.addHandler(fh);
        } catch (IOException e) {
            //unused
        }
        handler.post(new Runnable() {
            @Override
            public void run() {
                ZipUtils.getSuitableFilesWithClear(dir, expiredPeriod);
            }
        });
    }

    @Override
    public String logDirectory() {
        return this.logDir;
    }

    @Override
    public Formatter fileFormatter() {
        return this.formatter;
    }

    @Override
    public int expiredPeriod() {
        return this.expiredPeriod;
    }

    @Override
    public void zipLogs(final OnZipListener listener) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                boolean result = false;
                String targetZipFileName = logDir + DateUtils.getCurrentDate() + ZipUtils.SUFFIX_ZIP;
                try {
                    File zipFile = new File(targetZipFileName);
                    if (zipFile.exists())
                        zipFile.delete();
                    result = ZipUtils.zipFiles(ZipUtils.getSuitableFilesWithClear(logDir, expiredPeriod),
                            zipFile, DateUtils.getCurrentDate());
                } catch (Exception e) {
                    error(tag, e.getCause());
                }
                if (null != listener)
                    listener.onZip(result, targetZipFileName);
            }
        });
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
    public void debug(final String msg) {
        if (!isDebugEnabled())
            return;
        handler.post(new Runnable() {
            @Override
            public void run() {
                log(Level.FINE, msg, null);
            }
        });
    }

    @Override
    public void debug(final String subTag, final String msg) {
        if (!isDebugEnabled())
            return;
        handler.post(new Runnable() {
            @Override
            public void run() {
                log(Level.FINE, TagFormatter.format(subTag, msg), null);
            }
        });
    }

    @Override
    public void debug(final String subTag, final String format, final Object arg) {
        if (!isDebugEnabled())
            return;
        handler.post(new Runnable() {
            @Override
            public void run() {
                log(Level.FINE, TagFormatter.format(subTag, format, arg), null);
            }
        });
    }

    @Override
    public void debug(final String subTag, final String format, final Object argA, final Object argB) {
        if (!isDebugEnabled())
            return;
        handler.post(new Runnable() {
            @Override
            public void run() {
                log(Level.FINE, TagFormatter.format(subTag, format, argA, argB), null);
            }
        });
    }

    @Override
    public void debug(final String subTag, final String format, final Object... arguments) {
        if (!isDebugEnabled())
            return;
        handler.post(new Runnable() {
            @Override
            public void run() {
                log(Level.FINE, TagFormatter.format(subTag, format, arguments), null);
            }
        });
    }

    @Override
    public void debug(String subTag, Throwable t) {
        if (!isDebugEnabled())
            return;
        log(Level.FINE, subTag, t);
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
        if (!isWarnEnabled())
            return;
        handler.post(new Runnable() {
            @Override
            public void run() {
                log(Level.WARNING, msg, null);
            }
        });
    }

    @Override
    public void warn(final String subTag, final String msg) {
        if (!isWarnEnabled())
            return;
        handler.post(new Runnable() {
            @Override
            public void run() {
                log(Level.WARNING, TagFormatter.format(subTag, msg), null);
            }
        });
    }

    @Override
    public void warn(final String subTag, final String format, final Object arg) {
        if (!isWarnEnabled())
            return;
        handler.post(new Runnable() {
            @Override
            public void run() {
                log(Level.WARNING, TagFormatter.format(subTag, format, arg), null);
            }
        });
    }

    @Override
    public void warn(final String subTag, final String format, final Object... arguments) {
        if (!isWarnEnabled())
            return;
        handler.post(new Runnable() {
            @Override
            public void run() {
                log(Level.WARNING, TagFormatter.format(subTag, format, arguments), null);
            }
        });
    }

    @Override
    public void warn(final String subTag, final String format, final Object argA, final Object argB) {
        if (!isWarnEnabled())
            return;
        handler.post(new Runnable() {
            @Override
            public void run() {
                log(Level.WARNING, TagFormatter.format(subTag, format, argA, argB), null);
            }
        });
    }

    @Override
    public void warn(String subTag, Throwable t) {
        if (!isWarnEnabled())
            return;
        log(Level.WARNING, subTag, t);
    }


    @Override
    public boolean isErrorEnabled() {
        return logger.isLoggable(Level.SEVERE);
    }

    @Override
    public void error(final String msg) {
        if (!isErrorEnabled())
            return;
        handler.post(new Runnable() {
            @Override
            public void run() {
                log(Level.SEVERE, msg, null);
            }
        });
    }

    @Override
    public void error(final String subTag, final String msg) {
        if (!isErrorEnabled())
            return;
        handler.post(new Runnable() {
            @Override
            public void run() {
                log(Level.SEVERE, TagFormatter.format(subTag, msg), null);
            }
        });
    }

    @Override
    public void error(final String subTag, final String format, final Object arg) {
        if (!isErrorEnabled())
            return;
        handler.post(new Runnable() {
            @Override
            public void run() {
                log(Level.SEVERE, TagFormatter.format(subTag, format, arg), null);
            }
        });
    }

    @Override
    public void error(final String subTag, final String format, final Object argA, final Object argB) {
        if (!isErrorEnabled())
            return;
        handler.post(new Runnable() {
            @Override
            public void run() {
                log(Level.SEVERE, TagFormatter.format(subTag, format, argA, argB), null);
            }
        });
    }

    @Override
    public void error(final String subTag, final String format, final Object... arguments) {
        if (!isErrorEnabled())
            return;
        handler.post(new Runnable() {
            @Override
            public void run() {
                log(Level.SEVERE, TagFormatter.format(subTag, format, arguments), null);
            }
        });
    }

    @Override
    public void error(String subTag, Throwable t) {
        if (!isErrorEnabled())
            return;
        log(Level.SEVERE, subTag, t);
    }

}
