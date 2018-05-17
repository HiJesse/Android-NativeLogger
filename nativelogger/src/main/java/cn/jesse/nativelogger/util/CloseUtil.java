package cn.jesse.nativelogger.util;

import java.io.Closeable;
import java.io.IOException;

import cn.jesse.nativelogger.NLogger;

/**
 * Created by jesse on 15/03/2017.
 */

public class CloseUtil {
    private CloseUtil() {
        //unused
    }

    public static void close(Closeable closeable) {
        try {
            if (null != closeable) {
                closeable.close();
            }
        } catch (IOException e) {
            NLogger.e("close", e);
        }
    }
}
