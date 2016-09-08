package cn.jesse.nativelogger.formatter;

import java.text.MessageFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * Created by jesse on 9/7/16.
 *
 * eg.
 * 2016-09-07 23:23:23 NLogger: INFO
 * SplashActivity was created
 */
public class SimpleFormatter extends Formatter {
    private static final String LINE_SEPARATOR = "\n";


    public SimpleFormatter() {
    }

    /**
     * Converts a object into a human readable string
     * representation.
     *
     */
    @Override
    public String format(LogRecord r) {
        StringBuilder sb = new StringBuilder();
        sb.append(MessageFormat.format("{0,date,yyyy-MM-dd HH:mm:ss} ",
                new Object[] { new Date(r.getMillis()) }));
        sb.append(r.getLoggerName()).append(": ");
        sb.append(r.getLevel().getName()).append(LINE_SEPARATOR);
        sb.append(formatMessage(r)).append(LINE_SEPARATOR);
        if (r.getThrown() != null) {
            sb.append("Throwable occurred: ");
            sb.append(TagFormatter.format(r.getThrown()));
        }
        return sb.toString();
    }
}