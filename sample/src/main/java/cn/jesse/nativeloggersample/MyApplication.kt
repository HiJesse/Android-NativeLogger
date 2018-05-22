package cn.jesse.nativeloggersample

import android.app.Application
import android.os.Environment
import cn.jesse.nativelogger.Logger
import cn.jesse.nativelogger.NLogger
import cn.jesse.nativelogger.NLoggerConfig
import cn.jesse.nativelogger.formatter.SimpleFormatter
import cn.jesse.nativelogger.logger.LoggerLevel

/**
 * Created by jesse on 10/15/16.
 */
@Logger(tag = "Test", level = Logger.INFO)
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        NLoggerConfig.init(this)


        NLoggerConfig.getInstance()
                .builder()
                .tag("APP")
                .loggerLevel(LoggerLevel.DEBUG)
                .fileLogger(true)
                .fileDirectory(Environment.getExternalStorageDirectory().getPath() + "/download/b/a")
//                .fileDirectory(getApplicationContext().getFilesDir().getPath() + "/logs")
                .fileFormatter(SimpleFormatter())
                .expiredPeriod(3)
                .catchException(true, { _, ex ->
                    NLogger.e("uncaughtException", ex!!)
                    android.os.Process.killProcess(android.os.Process.myPid())
                })
                .build()
    }
}
