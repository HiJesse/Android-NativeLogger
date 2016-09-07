package cn.jesse.nativelogger.formatter;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * Created by jesse on 9/7/16.
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
            Throwable t = r.getThrown();
            PrintWriter pw = null;
            try {
                StringWriter sw = new StringWriter();
                pw = new PrintWriter(sw);
                t.printStackTrace(pw);
                sb.append(sw.toString());
            } finally {
                if (null != pw)
                    pw.close();
            }
        }
        return sb.toString();
    }
}
