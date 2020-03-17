package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    String tableName = "SinhVien";
    String id = "ID";
    String name = "name";
    String gioitinh = "gioitinh";
    String namsinh = "namsinh";
    String sothich = "sothich";
    String school = "school";
    public Database(@Nullable Context context) {
        super(context, "QuanLySV.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String caulenhtruyvan = "CREATE TABLE IF NOT EXISTS "+tableName+"(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(200), gioitinh INTEGER, namsinh VARCHAR(10), sothich VARCHAR(30), school VARCHAR(200))";
        db.execSQL(caulenhtruyvan);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    void khongtraKQ(SinhVien sv){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(name, sv.getHoTen());
        contentValues.put(gioitinh, sv.getGioiTinh());
        contentValues.put(namsinh, sv.getNamSinh());
        contentValues.put(sothich, sv.getSoThich());
        contentValues.put(school,sv.getSchool());
        database.insert(tableName,null,contentValues);
        database.close();
    }

    Cursor traKQ(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql,null);
    }

    void xoaUpdate(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }
}
