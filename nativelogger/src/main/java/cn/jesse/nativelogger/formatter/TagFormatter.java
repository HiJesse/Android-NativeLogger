package cn.jesse.nativelogger.formatter;

/**
 * Created by jesse on 9/7/16.
 */
public class TagFormatter {
    private static final String RESULT_UNEXPECTED_FORMAT = "unexpected format";

    public static String format(String subTag, String msg) {
        String result;
        try {
            result = String.format("%s : %s", subTag, msg);
        } catch (Exception e){
            result = RESULT_UNEXPECTED_FORMAT;
        }
        return result;
    }

    public static String format(String subTag, String format, Object arg) {
        String result;
        try {
            result = String.format("%s : " + format, subTag, arg);
        } catch (Exception e){
            result = RESULT_UNEXPECTED_FORMAT;
        }
        return result;
    }

    public static String format(String subTag, String format, Object argA, Object argB) {
        String result;
        try {
            result = String.format("%s : " + format, subTag, argA, argB);
        } catch (Exception e){
            result = RESULT_UNEXPECTED_FORMAT;
        }
        return result;
    }

    public static String format(String subTag, String format, Object... args) {
        String result;
        try {
            result = String.format("%s : %s", subTag, String.format(format, args));
        } catch (Exception e){
            result = RESULT_UNEXPECTED_FORMAT;
        }
        return result;
    }
}
