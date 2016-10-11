package cn.jesse.nativelogger;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import cn.jesse.nativelogger.logger.LoggerLevel;

/**
 * Created by jesse on 10/11/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Logger {
    String tag() default "NLogger";
    LoggerLevel level() default LoggerLevel.DEBUG;
}
