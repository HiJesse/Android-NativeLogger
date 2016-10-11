package cn.jesse.nativeloggersample;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import cn.jesse.nativelogger.Logger;
import cn.jesse.nativelogger.NLogger;
import cn.jesse.nativelogger.formatter.SimpleFormatter;
import cn.jesse.nativelogger.logger.LoggerLevel;
import cn.jesse.nativelogger.logger.base.IFileLogger;
import cn.jesse.nativelogger.util.CrashWatcher;

@Logger(tag = "Test", level = LoggerLevel.WARN)
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test = (TextView) findViewById(R.id.tv_test);
        test.setOnClickListener(this);

        NLogger.init(this);


//        NLogger.getInstance()
//                .builder()
//                .tag("APP")
//                .loggerLevel(LoggerLevel.DEBUG)
//                .fileLogger(true)
//                .fileDirectory(Environment.getExternalStorageDirectory().getPath() + "/download/b/a")
////                .fileDirectory(getApplicationContext().getFilesDir().getPath() + "/logs")
//                .fileFormatter(new SimpleFormatter())
//                .expiredPeriod(3)
//                .catchException(true, new CrashWatcher.UncaughtExceptionListener() {
//                    @Override
//                    public void uncaughtException(Thread thread, Throwable ex) {
//                        NLogger.e("uncaughtException", ex);
//                        android.os.Process.killProcess(android.os.Process.myPid());
//                    }
//                })
//                .build();

        NLogger.d("debug");
        NLogger.i("MainActivity", "type1");
        NLogger.w("MainActivity", "%s", "type2");
        NLogger.d("MainActivity", "%s%d%s", "type", 3, " finish");

    }

    @Override
    public void onClick(View v) {
        NLogger.zipLogs(new IFileLogger.OnZipListener() {
            @Override
            public void onZip(boolean succeed, String target) {
                if (succeed)
                    NLogger.i("zip", "succeed : " + target);
            }
        });
    }
}
