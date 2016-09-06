package cn.jesse.nativelogger;

import android.text.TextUtils;

/**
 * Created by jesse on 9/5/16.
 */
public class NativeLogger {
    private static NativeLogger mInstance;
    private static Builder builder;

    private NativeLogger() {

    }

    /**
     * get instance
     * @return
     */
    public static NativeLogger getInstance() {
        if (mInstance == null) {
            synchronized (NativeLogger.class) {
                if (mInstance == null) {
                    mInstance = new NativeLogger();
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
    private NativeLogger build(Builder builder) {
        return mInstance;
    }

    /**
     * instance builder
     * @return
     */
    public Builder builder() {
        if (builder == null) {
            synchronized (NativeLogger.class) {
                if (builder == null) {
                    builder = new Builder();
                }
            }
        }
        return builder;
    }

    public static final class Builder {
        private boolean isFileLoggerEnable = true;
        private String tag = NativeLogger.class.getSimpleName();
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

        public NativeLogger build() {
            return mInstance.build(this);
        }
    }
}
