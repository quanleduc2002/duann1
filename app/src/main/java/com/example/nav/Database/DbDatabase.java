package com.example.nav.Database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DbDatabase extends SQLiteOpenHelper {


    public DbDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "Ghichu", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_GHICHU = "CREATE TABLE GhiChu(" +
                "maGC TEXT PRIMARY KEY, " +
                "NoiDung TEXT," +
                " ThoiGian TEXT ," +
                " Date DATE)";
        db.execSQL(CREATE_TABLE_GHICHU);

        String CREATE_TABLE_LOAI = "CREATE TABLE LoaiGhiChu(" +
                "maGC TEXT REFERENCES GhiChu(maGC),"+
                "maLGC TEXT PRIMARY KEY,"+
                "tenGC TEXT)";
        db.execSQL(CREATE_TABLE_LOAI);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTABLE_GHICHU = "drop table if exists GhiChu";
        db.execSQL(dropTABLE_GHICHU);
        String dropTABLE_LOAI = "drop table if exists LoaiGhiChu";
        db.execSQL(dropTABLE_LOAI);
    }
}
