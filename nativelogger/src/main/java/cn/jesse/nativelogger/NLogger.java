package cn.jesse.nativelogger;

import android.text.TextUtils;

import cn.jesse.nativelogger.logger.AndroidLogger;
import cn.jesse.nativelogger.logger.base.ILogger;

/**
 * Created by jesse on 9/5/16.
 */
public class NLogger extends AbstractNativeLogger{
    private static final String TAG = NLogger.class.getSimpleName();
    private static NLogger mInstance;
    private static Builder builder;

    private ILogger defaultLogger = new AndroidLogger(TAG);
    private ILogger fileLogger;

    private NLogger() {

    }

    /**
     * get instance
     * @return
     */
    public static NLogger getInstance() {
        if (mInstance == null) {
            synchronized (NLogger.class) {
                if (mInstance == null) {
                    mInstance = new NLogger();
                }
            }
        }
        return mInstance;
    }

    /**
     * build builder to native logger
     * @param builder
     * @return
     */
    private NLogger build(Builder builder) {
        return mInstance;
    }

    /**
     * instance builder
     * @return
     */
    public Builder builder() {
        if (builder == null) {
            synchronized (NLogger.class) {
                if (builder == null) {
                    builder = new Builder();
                }
            }
        }
        return builder;
    }

    /**
     * get android logger
     *
     */
    @Override
    ILogger getDefaultLogger() {
        return this.defaultLogger;
    }

    /**
     * get file logger
     *
     */
    @Override
    ILogger getFileLogger() {
        return this.fileLogger;
    }

    public static final class Builder {
        private boolean isFileLoggerEnable = true;
        private String tag = NLogger.class.getSimpleName();
        private int packPeriod = 1;

        /**
         * set file logger enbale
         *
         */
        public Builder setFileLoggerEnable(boolean enable) {
            this.isFileLoggerEnable = enable;
            return this;
        }

        /**
         * set pack log period
         *
         * @throws IllegalArgumentException if the period < 0
         */
        public Builder setPeriod(int period) {
            if (period < 0)
                throw new IllegalArgumentException("unexpected period : " + period);

            packPeriod = period;
            return this;
        }

        /**
         * set tag
         *
         * @throws IllegalArgumentException if the tag is null | empty
         */
        public Builder setTag(String tag) {
            if (TextUtils.isEmpty(tag))
                throw new IllegalArgumentException("unexpected tag");

            this.tag = tag;
            return this;
        }

        public NLogger build() {
            return mInstance.build(this);
        }
    }
}
