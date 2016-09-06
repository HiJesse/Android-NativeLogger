package cn.jesse.nativelogger.util;

import java.text.SimpleDateFormat;

/**
 * Created by jesse on 9/6/16.
 */
public class DateUtils {
    private static final String TEMPLATE_DATE = "yyyy-MM-dd";

    public static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat(TEMPLATE_DATE);
        return sdf.format(System.currentTimeMillis());
    }
}
