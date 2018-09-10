package com.example.sugiyamakazuteru.contentprovidertest;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TestDB extends SQLiteOpenHelper {

    // DB、テーブル情報定義
    private final String DB_NAME = "PohoneBookDB.db";
    private final int DB_VERSION = 1;
    public final String DB_TABLE_NAME = "PhoneBookTable";
    public final String COL_NAME = "PhoneNumber";

    // テーブル作成処理
    private final String STRING_CREATE = "CREATE TABLE " + DB_TABLE_NAME +
            "(INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NAME + ");";

    public TestDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
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
        // DB変更処理時にドロップする　暫定
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB_TABLE_NAME);
    }
}
