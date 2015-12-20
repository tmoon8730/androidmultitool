package com.tea.big.androidmultitool.SimpleDatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.tea.big.androidmultitool.SimpleDatabase.Student;

/**
 * Created by tmoon on 12/19/15.
 */
public class DBHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 4;

    private static final String DATABASE_NAME = "crud.db";

    public DBHelper(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_TABLE_STUDENT = "CREATE TABLE " + Student.TABLE + "("
                + Student.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Student.KEY_name + " TEXT,"
                + Student.KEY_age + " INTEGER,"
                + Student.KEY_email + " TEXT )";
        db.execSQL(CREATE_TABLE_STUDENT);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Student.TABLE);
        onCreate(db);
    }
}
