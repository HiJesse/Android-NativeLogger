package cn.jesse.nativelogger.logger.base;

import java.util.logging.Formatter;

/**
 * Created by jesse on 9/6/16.
 */
public interface IFileLogger {
    void setFilePathAndFormatter(String directory, Formatter formatter, int expiredPeriod);
    String logDirectory();
    Formatter fileFormatter();
    int expiredPeriod();

    void zipLogs(OnZipListener listener);

    interface OnZipListener {
        void onZip(boolean succeed, String target);
    }
}
