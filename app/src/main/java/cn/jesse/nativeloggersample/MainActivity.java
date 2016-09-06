package cn.jesse.nativeloggersample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.jesse.nativelogger.NLogger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NLogger.getInstance()
                .builder()
                .setPeriod(4)
                .build();

        NLogger.i("test local log");
        NLogger.d("test local log");
        NLogger.w("test local log");
        NLogger.e("test local log");
    }
}
