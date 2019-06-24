package com.akin.register;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;


/**
 * Created by Mungfali on 12-06-2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static  final String DATABASE_NAME = "login.db";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sqlRegister = "CREATE TABLE  UserDetail(NAME VARCHAR, PASSWORD VARCHAR, PHONENUMBER VARCHAR)";
        sqLiteDatabase.execSQL(sqlRegister);

    }

    public void insertquery(String name, String password, String phone)
    {
        Log.i(TAG, name + password +phone);
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("NAME", name);
        values.put("PASSWORD", password);
        values.put("PHONENUMBER", phone);

        // Inserting Row
        db.insert("UserDetail", null, values);
        db.close();
    }
 public Boolean logincheck(String uname,String upwd) {
        Boolean bool = false;
        String selectQuery = "select  * from UserDetail";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        int size = cursor.getCount();
        if (cursor != null && cursor.moveToFirst() && cursor.getCount()>0) {
            do {
               if(uname.equals(cursor.getString(0))&& upwd.equals(cursor.getString(1))){
                  bool = true;
                  break;
               }
            } while (cursor.moveToNext());
        }
        cursor.close();
        return bool;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sqlRegister ="drop table UserDetail";
        sqLiteDatabase.execSQL(sqlRegister);
        onCreate(sqLiteDatabase);
    }
}
