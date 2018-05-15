package cn.jesse.nativelogger

import cn.jesse.nativelogger.logger.LoggerLevel
import cn.jesse.nativelogger.logger.base.IFileLogger
import cn.jesse.nativelogger.logger.base.ILogger

/**
 * NLogger 抽象类, 提供对外访问的静态方法
 *
 * @author Jesse
 */
abstract class AbstractNativeLogger {

    /**
     * 获取默认的日志管理器
     */
    abstract fun getDefaultLogger(): ILogger

    /**
     * 获取文件日志管理器
     */
    abstract fun getFileLogger(): ILogger?

    /**
     * 静态块
     */
    companion object {

        /**
         * 压缩日志文件
         */
        @JvmStatic
        fun zipLogs(listener: IFileLogger.OnZipListener) {
            val fileLogger = NLogger.getInstance().getFileLogger() as IFileLogger ?

            if (null == fileLogger) {
                w("unexpected zip logs, file logger is null")
                return
            }
            fileLogger.zipLogs(listener)
        }

        @JvmStatic
        fun i(msg: String) {
            NLogger.getInstance().getDefaultLogger().info(msg)

            if (NLogger.getInstance().getFileLogger() == null) {
                return
            } else {
                NLogger.getInstance().getFileLogger()?.info(msg)
            }
        }

        @JvmStatic
        fun i(tag: String, msg: String) {
            NLogger.getInstance().getDefaultLogger().info(tag, msg)

            if (NLogger.getInstance().getFileLogger() == null){
                return
            }

            NLogger.getInstance().getFileLogger()?.info(tag, msg)
        }

        @JvmStatic
        fun i(tag: String, format: String, arg: Any) {
            NLogger.getInstance().getDefaultLogger().info(tag, format, arg)

            if (NLogger.getInstance().getFileLogger() == null){
                return
            }

            NLogger.getInstance().getFileLogger()?.info(tag, format, arg)
        }

        @JvmStatic
        fun i(tag: String, format: String, argA: Any, argB: Any) {
            NLogger.getInstance().getDefaultLogger().info(tag, format, argA, argB)

            if (NLogger.getInstance().getFileLogger() == null){
                return
            }

            NLogger.getInstance().getFileLogger()?.info(tag, format, argA, argB)
        }

        @JvmStatic
        fun i(tag: String, format: String, vararg args: Any) {
            NLogger.getInstance().getDefaultLogger().info(tag, format, *args)

            if (NLogger.getInstance().getFileLogger() == null){
                return
            }

            NLogger.getInstance().getFileLogger()?.info(tag, format, *args)
        }

        @JvmStatic
        fun i(tag: String, ex: Throwable) {
            NLogger.getInstance().getDefaultLogger().info(tag, ex)

            if (NLogger.getInstance().getFileLogger() == null){
                return
            }

            NLogger.getInstance().getFileLogger()?.info(tag, ex)
        }

        @JvmStatic
        fun d(msg: String) {
            NLogger.getInstance().getDefaultLogger().debug(msg)

            if (NLogger.getInstance().getFileLogger() == null){
                return
            }

            NLogger.getInstance().getFileLogger()?.debug(msg)
        }

        @JvmStatic
        fun d(tag: String, msg: String) {
            NLogger.getInstance().getDefaultLogger().debug(tag, msg)

            if (NLogger.getInstance().getFileLogger() == null){
                return
            }

            NLogger.getInstance().getFileLogger()?.debug(tag, msg)
        }

        @JvmStatic
        fun d(tag: String, format: String, arg: Any) {
            NLogger.getInstance().getDefaultLogger().debug(tag, format, arg)

            if (NLogger.getInstance().getFileLogger() == null){
                return
            }

            NLogger.getInstance().getFileLogger()?.debug(tag, format, arg)
        }

        @JvmStatic
        fun d(tag: String, format: String, argA: Any, argB: Any) {
            NLogger.getInstance().getDefaultLogger().debug(tag, format, argA, argB)

            if (NLogger.getInstance().getFileLogger() == null){
                return
            }

            NLogger.getInstance().getFileLogger()?.debug(tag, format, argA, argB)
        }

        @JvmStatic
        fun d(tag: String, format: String, vararg args: Any) {
            NLogger.getInstance().getDefaultLogger().debug(tag, format, *args)

            if (NLogger.getInstance().getFileLogger() == null){
                return
            }

            NLogger.getInstance().getFileLogger()?.debug(tag, format, *args)
        }

        @JvmStatic
        fun d(tag: String, ex: Throwable) {
            NLogger.getInstance().getDefaultLogger().debug(tag, ex)

            if (NLogger.getInstance().getFileLogger() == null){
                return
            }

            NLogger.getInstance().getFileLogger()?.debug(tag, ex)
        }

        @JvmStatic
        fun w(msg: String) {
            NLogger.getInstance().getDefaultLogger().warn(msg)

            if (NLogger.getInstance().getFileLogger() == null){
                return
            }

            NLogger.getInstance().getFileLogger()?.warn(msg)
        }

        @JvmStatic
        fun w(tag: String, msg: String) {
            NLogger.getInstance().getDefaultLogger().warn(tag, msg)

            if (NLogger.getInstance().getFileLogger() == null){
                return
            }

            NLogger.getInstance().getFileLogger()?.warn(tag, msg)
        }

        @JvmStatic
        fun w(tag: String, format: String, arg: Any) {
            NLogger.getInstance().getDefaultLogger().warn(tag, format, arg)

            if (NLogger.getInstance().getFileLogger() == null){
                return
            }

            NLogger.getInstance().getFileLogger()?.warn(tag, format, arg)
        }

        @JvmStatic
        fun w(tag: String, format: String, argA: Any, argB: Any) {
            NLogger.getInstance().getDefaultLogger().warn(tag, format, argA, argB)

            if (NLogger.getInstance().getFileLogger() == null){
                return
            }

            NLogger.getInstance().getFileLogger()?.warn(tag, format, argA, argB)
        }

        @JvmStatic
        fun w(tag: String, format: String, vararg args: Any) {
            NLogger.getInstance().getDefaultLogger().warn(tag, format, *args)

            if (NLogger.getInstance().getFileLogger() == null){
                return
            }

            NLogger.getInstance().getFileLogger()?.warn(tag, format, *args)
        }

        @JvmStatic
        fun w(tag: String, ex: Throwable) {
            NLogger.getInstance().getDefaultLogger().warn(tag, ex)

            if (NLogger.getInstance().getFileLogger() == null){
                return
            }

            NLogger.getInstance().getFileLogger()?.warn(tag, ex)
        }

        @JvmStatic
        fun e(msg: String) {
            NLogger.getInstance().getDefaultLogger().error(msg)

            if (NLogger.getInstance().getFileLogger() == null){
                return
            }

            NLogger.getInstance().getFileLogger()?.error(msg)
        }

        @JvmStatic
        fun e(tag: String, msg: String) {
            NLogger.getInstance().getDefaultLogger().error(tag, msg)

            if (NLogger.getInstance().getFileLogger() == null){
                return
            }

            NLogger.getInstance().getFileLogger()?.error(tag, msg)
        }

        @JvmStatic
        fun e(tag: String, format: String, arg: Any) {
            NLogger.getInstance().getDefaultLogger().error(tag, format, arg)

            if (NLogger.getInstance().getFileLogger() == null){
                return
            }

            NLogger.getInstance().getFileLogger()?.error(tag, format, arg)
        }

        @JvmStatic
        fun e(tag: String, format: String, argA: Any, argB: Any) {
            NLogger.getInstance().getDefaultLogger().error(tag, format, argA, argB)

            if (NLogger.getInstance().getFileLogger() == null){
                return
            }

            NLogger.getInstance().getFileLogger()?.error(tag, format, argA, argB)
        }

        @JvmStatic
        fun e(tag: String, format: String, vararg args: Any) {
            NLogger.getInstance().getDefaultLogger().error(tag, format, *args)

            if (NLogger.getInstance().getFileLogger() == null){
                return
            }

            NLogger.getInstance().getFileLogger()?.error(tag, format, *args)
        }

        @JvmStatic
        fun e(tag: String, ex: Throwable) {
            NLogger.getInstance().getDefaultLogger().error(tag, ex)

            if (NLogger.getInstance().getFileLogger() == null){
                return
            }

            NLogger.getInstance().getFileLogger()?.error(tag, ex)
        }

        @JvmStatic
        fun json(level: LoggerLevel, msg: String) {
            NLogger.getInstance().getDefaultLogger().json(level, msg)

            if (NLogger.getInstance().getFileLogger() == null){
                return
            }

            NLogger.getInstance().getFileLogger()?.json(level, msg)
        }

        @JvmStatic
        fun json(level: LoggerLevel, subTag: String, msg: String) {
            NLogger.getInstance().getDefaultLogger().json(level, subTag, msg)

            if (NLogger.getInstance().getFileLogger() == null) {
                return
            }

            NLogger.getInstance().getFileLogger()?.json(level, subTag, msg)
        }
    }
}