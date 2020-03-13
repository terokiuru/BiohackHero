package com.example.biohackhero;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class myWeightDatabase extends SQLiteOpenHelper {

    static final private String DB_NAME = "Bioinfo";
    static final private String DB_TABLE = "weight";
    static final private int DB_VER = 1;

    Context ctx;
    SQLiteDatabase myDb;

    public myWeightDatabase(Context ct) {
        super(ct, DB_NAME, null, DB_VER);
        ctx = ct;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+DB_TABLE+" (_id integer primary key autoincrement, date text, weight text);");
        Log.i("Database", "Table created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+DB_TABLE);
        onCreate(db);
    }


    public void insertData(String s1, String s2) {
        myDb = getWritableDatabase();

        myDb.execSQL("insert into "+DB_TABLE+" (date,weight) values('"+s1+"','"+s2+"');");
        Toast.makeText(ctx, "Data saved successfully "+s1+" "+s2, Toast.LENGTH_SHORT).show();
    }

    public void getAll(){
        myDb = getReadableDatabase();
        Cursor cr = myDb.rawQuery("Select * from "+DB_TABLE, null);
        StringBuilder str = new StringBuilder();

        while (cr.moveToNext()) {
            String s0 = cr.getString(0);
            String s1 = cr.getString(1);
            String s2 = cr.getString(2);
            str.append(s0+"    "+s1+"   "+s2+" \n");
        }

        Toast.makeText(ctx, str.toString(), Toast.LENGTH_LONG).show();
    }

    public void deleteItem()
    {
        myDb = getReadableDatabase();
        Cursor cr = myDb.rawQuery("Select * from "+DB_TABLE, null);
        StringBuilder str = new StringBuilder();
        int i = 0;
        int int_max = 0;
        while (cr.moveToNext()) {
            i = i + 1;
            String s = cr.getString(0);
            int s_int = Integer.parseInt(s);
            if (s_int > int_max) {
                int_max = s_int;
            }
//            str.append(s0+"    "+s1+"   "+s2+" \n");
        }
        str.append(int_max);
        String get_ID = Integer.toString(int_max);
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DB_TABLE, "_id = ?", new String[] {get_ID});

//        Toast.makeText(ctx, str.toString(), Toast.LENGTH_SHORT).show();
    }


}

