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


        TextView text = (TextView) findViewById(R.id.textView);
        String btext = Settings.System.getString
                (this.getContentResolver(), "screen_brightness");

        text.setText("画面の明るさは、" + btext);
    }
}