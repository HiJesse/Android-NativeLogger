#Android-NativeLogger

NativeLogger是Android平台一套日志管理框架.NativeLogger可以帮助开发者统一管理不同Level的log, 将其输出到Console或者文件(/天)中.后续将继续完善.

##功能清单

|状态|功能|默认|
|:-:|:-:|:-:|
|![](http://od9tun44g.bkt.clouddn.com/ic_done_black_18dp_1x.png)| 设置TAG | NLogger |
|![](http://od9tun44g.bkt.clouddn.com/ic_done_black_18dp_1x.png)| 设置LEVEL | WARN |
|![](http://od9tun44g.bkt.clouddn.com/ic_done_black_18dp_1x.png)| 是否捕获全局异常 | false |
|![](http://od9tun44g.bkt.clouddn.com/ic_done_black_18dp_1x.png)| 是否开启文件日志 | true |
|![](http://od9tun44g.bkt.clouddn.com/ic_done_black_18dp_1x.png)| 文件日志内容格式 | SimpleFormatter |
|![](http://od9tun44g.bkt.clouddn.com/ic_done_black_18dp_1x.png)| 日志文件存放路径 | /sdcard/native.logs/ |
|![](http://od9tun44g.bkt.clouddn.com/ic_done_black_18dp_1x.png)| 日志文件过期时间 | 1 day |
|![](http://od9tun44g.bkt.clouddn.com/ic_done_black_18dp_1x.png)| 日志文件打包周期 | 1 day |
|![](http://od9tun44g.bkt.clouddn.com/ic_done_will_black_18dp_1x.png)| 适配Android 6.0 | - |
|![](http://od9tun44g.bkt.clouddn.com/ic_done_will_black_18dp_1x.png)| 格式化输出JSON | - |
|![](http://od9tun44g.bkt.clouddn.com/ic_done_will_black_18dp_1x.png)| 格式化输出XML | - |
|![](http://od9tun44g.bkt.clouddn.com/ic_done_will_black_18dp_1x.png)| 日志混淆 | - |

![](http://od9tun44g.bkt.clouddn.com/ic_done_black_18dp_1x.png) : 已完成
![](http://od9tun44g.bkt.clouddn.com/ic_done_will_black_18dp_1x.png) : 待完成

##如何引入

Gradle


```
repositories {
    jcenter()
    maven { url "https://raw.githubusercontent.com/HiJesse/mvn/master/repository/" }
}
```

```
dependencies {
    compile "cn.jesse.android:nativelogger:1.0.0"
}
```

##如何使用

简单用法-只使用基础的Console log

```
NLogger.d("debug");
NLogger.i("MainActivity", "type1");
NLogger.w("MainActivity", "%s", "type2");
NLogger.d("MainActivity", "%s%d%s", "type", 3, "finish");
NLogger.e("uncaughtException", throwable);
```

进阶用法-配置功能清单中所有属性

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

        NLogger.d("debug");
        NLogger.i("MainActivity", "type1");
        NLogger.w("MainActivity", "%s", "type2");
        NLogger.d("MainActivity", "%s%d%s", "type", 3, " finish");

        NLogger.zipLogs(new IFileLogger.OnZipListener() {
            @Override
            public void onZip(boolean succeed, String target) {
                if (succeed)
                    NLogger.i("zip", "succeed : " + target);
            }
        });
```


##License

    Copyright 2016 Jesse

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.