package cn.jesse.nativelogger;

/**
 * Created by jesse on 05/02/2017.
 */

public class NLoggerError extends Error {
    public NLoggerError() {
        //unused
    }

    /**
     * Constructs a new {@code Error} with the current stack trace and the
     * specified detail message.
     *
     * @param detailMessage
     *            the detail message for this error.
     */
    public NLoggerError(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new {@code Error} with the current stack trace, the
     * specified detail message and the specified cause.
     *
     * @param detailMessage
     *            the detail message for this error.
     * @param throwable
     *            the cause of this error.
     */
    public NLoggerError(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    /**
     * Constructs a new {@code Error} with the current stack trace and the
     * specified cause.
     *
     * @param throwable
     *            the cause of this error.
     */
    public NLoggerError(Throwable throwable) {
        super(throwable);
    }
}
