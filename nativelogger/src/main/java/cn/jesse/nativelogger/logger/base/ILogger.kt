package cn.jesse.nativelogger.logger.base

import cn.jesse.nativelogger.logger.LoggerLevel

/**
 * Logger 接口
 *
 * @author Jesse
 */
interface ILogger {

    fun setTag(tag: String)
    fun tag(): String

    fun setLevel(level: LoggerLevel)
    fun isDebugEnabled(): Boolean

    fun debug(msg: String)

    fun debug(subTag: String, msg: String)

    fun debug(subTag: String, format: String, arg: Any)

    fun debug(subTag: String, format: String, argA: Any, argB: Any)

    fun debug(subTag: String, format: String, vararg arguments: Any)

    fun debug(subTag: String, t: Throwable)

    fun isInfoEnabled(): Boolean

    fun info(msg: String)

    fun info(subTag: String, msg: String)

    fun info(subTag: String, format: String, arg: Any)

    fun info(subTag: String, format: String, argA: Any, argB: Any)

    fun info(subTag: String, format: String, vararg arguments: Any)

    fun info(subTag: String, t: Throwable)

    fun isWarnEnabled(): Boolean

    fun warn(msg: String)

    fun warn(subTag: String, msg: String)

    fun warn(subTag: String, format: String, arg: Any)

    fun warn(subTag: String, format: String, vararg arguments: Any)

    fun warn(subTag: String, format: String, argA: Any, argB: Any)

    fun warn(subTag: String, t: Throwable)

    fun isErrorEnabled(): Boolean

    fun error(msg: String)

    fun error(subTag: String, msg: String)

    fun error(subTag: String, format: String, arg: Any)

    fun error(subTag: String, format: String, argA: Any, argB: Any)

    fun error(subTag: String, format: String, vararg arguments: Any)

    fun error(subTag: String, t: Throwable)

    fun isEnabled(level: LoggerLevel): Boolean

    fun log(level: LoggerLevel, msg: String)

    fun log(level: LoggerLevel, subTag: String, msg: String)

    fun log(level: LoggerLevel, subTag: String, format: String, arg: Any)

    fun log(level: LoggerLevel, subTag: String, format: String, argA: Any, argB: Any)

    fun log(level: LoggerLevel, subTag: String, format: String, vararg arguments: Any)

    fun log(level: LoggerLevel, subTag: String, t: Throwable)

    fun json(level: LoggerLevel, msg: String)

    fun json(level: LoggerLevel, subTag: String, msg: String)
}