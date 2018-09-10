package com.example.sugiyamakazuteru.contentprovidertest;


import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] projection = new String[]
                {TestContentProvider.Columns.NAME};
        Cursor cursor = getContentResolver().query(TestContentProvider.testUri,
                projection, null,null);

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1, cursor,
                new String[]{TestContentProvider.Columns.NAME},
                new int[] {android.R.id.text1},
                0);

        TextView texitview = findViewById(R.id.textView);
        texitview.setText((CharSequence) adapter);


/*        TextView text = (TextView) findViewById(R.id.textView);
        // 画面の明るさをContentProviderより取得
        String btext = Settings.System.getString
                (this.getContentResolver(), "screen_brightness");

        text.setText("画面の明るさは、" + btext);*/
    }
}