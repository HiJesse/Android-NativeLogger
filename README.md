# Android-NativeLogger

NativeLogger是Android平台一套日志管理框架.NativeLogger可以帮助开发者统一管理不同Level的log, 将其输出到Console或者文件(/天)中.后续将继续完善.

## 功能清单

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

## Gradle引入

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
    compile 'com.github.hijesse:android-logger:2.5.0'
}
```

## 如何使用

* 初始化-注解配置
	
	[Java调用参考](https://github.com/HiJesse/Android-NativeLogger/blob/69d5a3572d45aadf86dc503ac5615f1c334a53b2/sample/src/main/java/cn/jesse/nativeloggersample/JavaActivity.java#L19-L29)
	
	Kotlin调用示例:
	
	```
	@Logger(tag = "Test", level = LoggerLevel.INFO)
	class MyApplication : Application() {
	
	    override fun onCreate() {
	        super.onCreate()
	        // 使用注解方式初始化
	        NLoggerConfig.init(this)
	    }
	}
	```
	
* 初始化-全量配置
	
	[Java调用参考](https://github.com/HiJesse/Android-NativeLogger/blob/69d5a3572d45aadf86dc503ac5615f1c334a53b2/sample/src/main/java/cn/jesse/nativeloggersample/JavaActivity.java#L32-L45)
	
	Kotlin调用示例:
	
	```
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
		
	```

* 日志打印
	
	Kotlin和Java的调用完全一致.
	
	```
	NLogger.d("debug");
	NLogger.i("MainActivity", "type1");
	NLogger.w("MainActivity", "%s", "type2");
	NLogger.d("MainActivity", "%s%d%s", "type", 3, "finish");
	NLogger.e("uncaughtException", throwable);
	NLogger.json(LoggerLevel.INFO, "{...}");
	```

* 日志压缩

	假设配置了日志文件打包周期为3天, 调用压缩日志后组件会压缩最近三天的日志到压缩包, 并回调到业务中. **压缩结果回调为子线程.**
	
	[Java调用参考](https://github.com/HiJesse/Android-NativeLogger/blob/69d5a3572d45aadf86dc503ac5615f1c334a53b2/sample/src/main/java/cn/jesse/nativeloggersample/JavaActivity.java#L57-L65)
	
	Kotlin调用示例:
	
	```
	NLogger.zipLogs { succeed, target ->
	    if (succeed) {
	        NLogger.i("zip", "succeed : $target Thread: ${Thread.currentThread().name}")
	    }
	}
	```
