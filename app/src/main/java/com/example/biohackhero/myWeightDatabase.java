package com.example.biohackhero;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class myWeightDatabase extends SQLiteOpenHelper {

    static final private String DB_NAME = "Bioinfo";
    static final private String DB_TABLE = "weight";
    static final private int DB_VER = 1;

    public myWeightDatabase(Context ct) {
        super(ct, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

