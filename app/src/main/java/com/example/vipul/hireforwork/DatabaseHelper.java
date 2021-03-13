package com.example.vipul.hireforwork;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "student_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "PHONE";
    public static final String COL_4 = "AGE";
    public static final String COL_5 = "GENDER";
    public static final String COL_6 = "EMAIL";
    public static final String COL_7 = "COUNTRY";
    public static final String COL_8 = "Address";
    public static final String COL_9 = "USE_AS";
    public static final String COL_10 = "IMG";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,PHONE INTEGER,AGE INTEGER,GENDER TEXT,EMAIL TEXT,COUNTRY TEXT,ADDRESS TEXT,USE_AS TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String phone, String age, String gender, String email, String country, String address, String use_as) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,phone);
        contentValues.put(COL_4,age);
        contentValues.put(COL_5,gender);
        contentValues.put(COL_6,email);
        contentValues.put(COL_7,country);
        contentValues.put(COL_8,address);
        contentValues.put(COL_9,use_as);
        //contentValues.put(COL_10, String.valueOf(imag));
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String id,String name,String phone,String age,String gender,String email,String country,String address,String use_as) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,phone);
        contentValues.put(COL_4,age);
        contentValues.put(COL_5,gender);
        contentValues.put(COL_6,email);
        contentValues.put(COL_7,country);
        contentValues.put(COL_8,address);
        contentValues.put(COL_9,use_as);

        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }
}