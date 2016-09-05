package cn.jesse.nativeloggersample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.jesse.nativelogger.NativeLogger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NativeLogger.getInstance()
                .builder()
                .setPeriod(4)
                .build();
    }
}
