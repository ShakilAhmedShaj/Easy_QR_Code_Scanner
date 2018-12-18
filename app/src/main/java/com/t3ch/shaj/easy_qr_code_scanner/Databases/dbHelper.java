package com.t3ch.shaj.easy_qr_code_scanner.Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.t3ch.shaj.easy_qr_code_scanner.Model.ListItems;

import java.util.ArrayList;

public class dbHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "mytable";
    public static final String DATABASE_NAME = "qrdb.db";

    public static final String COL_1 = "id";
    public static final String COL_2 = "code";
    public static final String COL_3 = "type";


    public dbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table " + TABLE_NAME + "( id PRIMARY KEY AUTOINCREMENT, " + " code TEXT, type TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public boolean inserData(String code, String type) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, code);
        contentValues.put(COL_3, type);

        SQLiteDatabase db = this.getWritableDatabase();

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else
            return true;

    }

    public ArrayList<ListItems> getAllInfo() {
        ArrayList<ListItems> arrayList = new ArrayList<>();

        SQLiteDatabase database = this.getReadableDatabase();

        Cursor cursor = database.rawQuery("Select * from " + TABLE_NAME, null);

        if (cursor == null) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String code = cursor.getString(1);
                String type = cursor.getString(2);

                ListItems listItems = new ListItems(id, code, type);

                arrayList.add(listItems);
            }

        }

        cursor.close();
        return arrayList;


    }

    public void deleteRow(int value)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM "+ TABLE_NAME+"- WHERE "+ COL_1+"-'"+value+"'");



    }


}
