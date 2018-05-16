package cn.jesse.nativelogger.formatter;

import android.util.Log;

import java.io.PrintWriter;
import java.io.StringWriter;

import cn.jesse.nativelogger.util.CloseUtil;

/**
 * Created by jesse on 9/7/16.
 */
public class TagFormatter {
    private static final String RESULT_UNEXPECTED_FORMAT = "unexpected format";
    private static final String WITH = " with ";

    private TagFormatter() {
        //unused
    }

    public static String format(String subTag, String msg) {
        String result;
        try {
            result = String.format("%s : %s", subTag, msg);
        } catch (Exception e){
            Log.e(subTag, RESULT_UNEXPECTED_FORMAT, e);
            result = RESULT_UNEXPECTED_FORMAT;
        }
        return result;
    }

    public static String format(String subTag, String format, Object arg) {
        String result;
        String finalFormat = "%s : " + format;
        try {
            result = String.format(finalFormat, subTag, arg);
        } catch (Exception e){
            Log.e(subTag, RESULT_UNEXPECTED_FORMAT, e);
            result = RESULT_UNEXPECTED_FORMAT + WITH + format;
        }
        return result;
    }

    public static String format(String subTag, String format, Object argA, Object argB) {
        String result;
        String finalFormat = "%s : " + format;
        try {
            result = String.format(finalFormat, subTag, argA, argB);
        } catch (Exception e){
            Log.e(subTag, RESULT_UNEXPECTED_FORMAT, e);
            result = RESULT_UNEXPECTED_FORMAT + WITH + format;
        }
        return result;
    }

    public static String format(String subTag, String format, Object... args) {
        String result;
        try {
            result = String.format("%s : %s", subTag, String.format(format, args));
        } catch (Exception e){
            Log.e(subTag, RESULT_UNEXPECTED_FORMAT, e);
            result = RESULT_UNEXPECTED_FORMAT + WITH + format;
        }
        return result;
    }

    public static String format(Throwable t) {
        String result = "";
        if (null == t)
            return result;

        PrintWriter pw = null;
        try {
            StringWriter sw = new StringWriter();
            pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            result = sw.toString();
        } finally {
            CloseUtil.close(pw);
        }
        return result;
    }
}
