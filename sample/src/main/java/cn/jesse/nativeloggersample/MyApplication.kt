package cn.jesse.nativeloggersample

import android.app.Application
import android.os.Environment
import cn.jesse.nativelogger.Logger
import cn.jesse.nativelogger.NLogger
import cn.jesse.nativelogger.NLoggerConfig
import cn.jesse.nativelogger.formatter.SimpleFormatter
import cn.jesse.nativelogger.logger.LoggerLevel

/**
 * app 入口处初始化NLogger. 提供两种方式
 *
 * @author Jesse
 */
@Logger(tag = "Test", level = LoggerLevel.INFO)
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // 使用注解方式初始化
//        NLoggerConfig.init(this)


        // 使用builder 初始化
        NLoggerConfig.getInstance()
                .builder()
                .tag("APP")
                .loggerLevel(LoggerLevel.DEBUG)
                .fileLogger(true)
                .fileDirectory(applicationContext.filesDir.path + "/logs")
                .fileFormatter(SimpleFormatter())
                .expiredPeriod(3)
                .catchException(true, { _, ex ->
                    NLogger.e("uncaughtException", ex!!)
                    android.os.Process.killProcess(android.os.Process.myPid())
                })
                .build()
    }
}
