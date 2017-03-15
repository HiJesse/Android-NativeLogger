#Android-NativeLogger

NativeLogger是Android平台一套日志管理框架.NativeLogger可以帮助开发者统一管理不同Level的log, 将其输出到Console或者文件(/天)中.后续将继续完善.

##功能清单

|状态|功能|默认|
|:-:|:-:|:-:|
|![](http://od9tun44g.bkt.clouddn.com/ic_done_black_18dp_1x.png)| 注解配置 | 支持 |
|![](http://od9tun44g.bkt.clouddn.com/ic_done_black_18dp_1x.png)| 设置TAG | NLogger |
|![](http://od9tun44g.bkt.clouddn.com/ic_done_black_18dp_1x.png)| 设置LEVEL | WARN |
|![](http://od9tun44g.bkt.clouddn.com/ic_done_black_18dp_1x.png)| 是否捕获全局异常 | false |
|![](http://od9tun44g.bkt.clouddn.com/ic_done_black_18dp_1x.png)| 是否开启文件日志 | true |
|![](http://od9tun44g.bkt.clouddn.com/ic_done_black_18dp_1x.png)| 文件日志内容格式 | SimpleFormatter |
|![](http://od9tun44g.bkt.clouddn.com/ic_done_black_18dp_1x.png)| 日志文件存放路径 | /sdcard/native.logs/ |
|![](http://od9tun44g.bkt.clouddn.com/ic_done_black_18dp_1x.png)| 日志文件过期时间 | 1 day |
|![](http://od9tun44g.bkt.clouddn.com/ic_done_black_18dp_1x.png)| 日志文件打包周期 | 1 day |
|![](http://od9tun44g.bkt.clouddn.com/ic_done_black_18dp_1x.png)| 格式化输出JSON | 支持 |
|![](http://od9tun44g.bkt.clouddn.com/ic_done_will_black_18dp_1x.png)| 日志混淆 | - |

![](http://od9tun44g.bkt.clouddn.com/ic_done_black_18dp_1x.png) : 已完成
![](http://od9tun44g.bkt.clouddn.com/ic_done_will_black_18dp_1x.png) : 待完成

##Gradle引入

根项目`build.gradle`中引入mavenCentral.

```
allprojects {
    repositories {
        ...
        mavenCentral()
    }
}
```

Module`build.gradle`中引入NLogger.

```
dependencies {
    compile 'com.github.hijesse:android-logger:2.0.0'
}
```

##如何使用
* 注解配置

```
@Logger(tag = "Test", level = Logger.INFO)
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NLogger.init(this);
    }
}
```
* 动态配置

```
NLogger.getInstance()
        .builder()
        .tag("APP")
        .loggerLevel(LoggerLevel.DEBUG)
        .fileLogger(true)
        .fileDirectory(getApplicationContext().getFilesDir().getPath() + "/logs")
        .fileFormatter(new SimpleFormatter())
        .expiredPeriod(3)
        .catchException(true, new CrashWatcher.UncaughtExceptionListener() {
            @Override
            public void uncaughtException(Thread thread, Throwable ex) {
                NLogger.e("uncaughtException", ex);
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        })
        .build();

```

* 使用方式

```
NLogger.d("debug");
NLogger.i("MainActivity", "type1");
NLogger.w("MainActivity", "%s", "type2");
NLogger.d("MainActivity", "%s%d%s", "type", 3, "finish");
NLogger.e("uncaughtException", throwable);
NLogger.json(LoggerLevel.INFO, "{...}");

//zip log files
NLogger.zipLogs(new IFileLogger.OnZipListener() {
    @Override
    public void onZip(boolean succeed, String target) {
        if (succeed)
            NLogger.i("zip", "succeed : " + target);
    }
});
```
