package cn.jesse.nativelogger;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by jesse on 10/11/16.
 * DEBUG > INFO > WARN > ERROR > OFF
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Logger {
    int OFF = 0;
    int DEBUG = 1;
    int INFO = 2;
    int WARN = 3;
    int ERROR = 4;

    String tag() default "NLogger";
    int level() default WARN;
}
