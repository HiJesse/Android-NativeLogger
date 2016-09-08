package cn.jesse.nativeloggersample;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Date;

import cn.jesse.nativelogger.NLogger;
import cn.jesse.nativelogger.formatter.SimpleFormatter;
import cn.jesse.nativelogger.logger.LoggerLevel;
import cn.jesse.nativelogger.util.CrashWatcher;
import cn.jesse.nativelogger.util.DateUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NLogger.i("log before config");

        NLogger.getInstance()
                .builder()
                .tag("NEW")
                .loggerLevel(LoggerLevel.DEBUG)
                .catchException(true, new CrashWatcher.UncaughtExceptionListener() {
                    @Override
                    public void uncaughtException(Thread thread, Throwable ex) {
                        NLogger.e("uncaughtException", ex);
                        android.os.Process.killProcess(android.os.Process.myPid());
                    }
                })
                .fileDirectory(Environment.getExternalStorageDirectory().getPath() + "/download/b/a")
                .packPeriod(4)
                .build();

        NLogger.d("type");
        NLogger.i("MainActivity", "type1");
        NLogger.e("MainActivity", "%s", "type2");
        NLogger.w("MainActivity", "%s%d", "type", 3);
        NLogger.d("MainActivity", "%s%d%s", "type", 4, " finish");

        int i = 0 / 0;

    }
}
