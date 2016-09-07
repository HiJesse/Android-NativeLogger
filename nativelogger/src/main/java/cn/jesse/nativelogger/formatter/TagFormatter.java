package cn.jesse.nativelogger.formatter;

/**
 * Created by jesse on 9/7/16.
 */
public class TagFormatter {

    public static String format(String subTag, String msg) {
        return String.format("%s : %s", subTag, msg);
    }

    public static String format(String subTag, String format, Object arg) {
        return String.format("%s : " + format, subTag, arg);
    }

    public static String format(String subTag, String format, Object argA, Object argB) {
        return String.format("%s : " + format, subTag, argA, argB);
    }

    public static String format(String subTag, String format, Object... args) {
        return String.format("%s : %s", subTag, String.format(format, args));
    }
}
