package com.example.sugiyamakazuteru.contentprovidertest;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TestDB extends SQLiteOpenHelper {

    // DB、テーブル情報定義
    private static final String DB_NAME = "PohoneBookDB.db";
    private static final int DB_VERSION = 1;
    public final String DB_TABLE_NAME = "PhoneBookTable";
    public final String COL_NAME = "PhoneNumber";

    // テーブル作成処理
    private final String STRING_CREATE = "CREATE TABLE " + DB_TABLE_NAME +
            "(_id INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NAME + ");";

    public TestDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // テーブル作成
        sqLiteDatabase.execSQL(STRING_CREATE);

        // カラムを指定し値を入れる
        ContentValues cv= new ContentValues(1);
        cv.put("PhoneNumber","090-2188-7711");
        sqLiteDatabase.insert("PhoneBookTable", null, cv);

        cv = new ContentValues(2);
        cv.put("PhoneNumber","052-981-5791");
        sqLiteDatabase.insert("PhoneBookTable", null, cv);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // DB変更処理時にドロップする　暫定　バージョンが新しくなった時の処理を後ほど追加
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB_TABLE_NAME);
    }
}
