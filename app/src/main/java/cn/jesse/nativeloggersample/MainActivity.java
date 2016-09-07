package cn.jesse.nativeloggersample;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Date;

import cn.jesse.nativelogger.NLogger;
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
                .catchException(true, new CrashWatcher.UncaughtExceptionListener() {
                    @Override
                    public void uncaughtException(Thread thread, Throwable ex) {
                        NLogger.e("uncaughtException : " + ex.getMessage());
                        android.os.Process.killProcess(android.os.Process.myPid());
                    }
                })
                .tag("NEW")
                .fileDirectory(Environment.getExternalStorageDirectory().getPath() + "/download/b/a")
                .packPeriod(4)
                .build();

        NLogger.i("test local log" + new Date().getTime());
        NLogger.d("test local log");
        NLogger.w("test local log");
        NLogger.e("test local log");
    }
}
