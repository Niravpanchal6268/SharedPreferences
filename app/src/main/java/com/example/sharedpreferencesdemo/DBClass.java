package com.example.sharedpreferencesdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBClass extends SQLiteOpenHelper {
    private final static String DB_Name = "user_data";
    private final static int version = 1;

    public DBClass(Context context) {
        super(context, DB_Name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String t = ("create table userSL(ID integer primary key autoincrement,NAME text,EMAIL text,PASSWORD text)");
        sqLiteDatabase.execSQL(t);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop table if exists userSL");
        onCreate(sqLiteDatabase);

    }

    public boolean InsertData(String Name, String Email, String Password) {
        SQLiteDatabase db = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("NAME", Name);
        values.put("EMAIL", Email);
        values.put("PASSWORD", Password);
        long i = db.insert("userSL", null, values);
        if (i != -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean CheckEmailPassword(String Email, String Password) {

        SQLiteDatabase db= getWritableDatabase();
        Cursor cursor =db.rawQuery("select * from userSL where EMAIL=? and PASSWORD=?",new String[]{Email,Password});
        if (cursor.getCount() > 0) {
            return true;
        } else {

            return false;
        }

    }




}
