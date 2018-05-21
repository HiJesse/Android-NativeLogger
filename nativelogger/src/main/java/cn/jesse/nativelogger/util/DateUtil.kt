package cn.jesse.nativelogger.util;

import java.text.SimpleDateFormat;

/**
 * Created by jesse on 9/6/16.
 */
public class DateUtil {
    private static final String TEMPLATE_DATE = "yyyy-MM-dd";

    private DateUtil() {
        //unused
    }

    public static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat(TEMPLATE_DATE);
        return sdf.format(System.currentTimeMillis());
    }
}
