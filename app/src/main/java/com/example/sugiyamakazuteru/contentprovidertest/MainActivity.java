package com.example.sugiyamakazuteru.contentprovidertest;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // コンテンツプロバイダURIを定義
        


/*        TextView text = (TextView) findViewById(R.id.textView);
        // 画面の明るさをContentProviderより取得
        String btext = Settings.System.getString
                (this.getContentResolver(), "screen_brightness");

        text.setText("画面の明るさは、" + btext);*/
    }
}