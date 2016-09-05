package cn.jesse.nativelogger;

/**
 * Created by jesse on 9/5/16.
 */
public class NativeLogger {
    private static NativeLogger mInstance;
    private static Builder builder;

    private NativeLogger(Builder builder) {

    }

    /**
     * get instance from builder
     * @param builder
     * @return
     */
    public static NativeLogger getInstance(Builder builder) {
        if (mInstance == null) {
            synchronized (NativeLogger.class) {
                if (mInstance == null) {
                    mInstance = new NativeLogger(builder);
                }
            }
        }
        return mInstance;
    }

    /**
     * get instance
     * @return
     */
    public static NativeLogger getInstance() {
        if (mInstance == null) {
            synchronized (NativeLogger.class) {
                if (mInstance == null) {
                    mInstance = new NativeLogger(null);
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
        private int packPeriod = 1;

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

        public NativeLogger build() {
            return mInstance.build(this);
        }
    }
}
