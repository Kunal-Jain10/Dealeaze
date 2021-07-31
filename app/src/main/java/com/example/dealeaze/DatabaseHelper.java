package com.example.dealeaze;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "USER_INFO";
    public static final String COL_1 = "NAME";
    public static final String COL_2 = "EMAIL";
    public static final String COL_3 = "PASSWORD";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "dealeaze.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" + COL_1 + " TEXT, " + COL_2 + " TEXT PRIMARY KEY, " + COL_3 + " TEXT)" ;
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

    public boolean insertdata(Login_register login_register){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_1,login_register.getName());
        cv.put(COL_2,login_register.getEmail());
        cv.put(COL_3,login_register.getPassword());

        long result = db.insert(TABLE_NAME,null,cv);
        if (result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public String checkPassword(String loginEmail){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select email, password from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String a,b;
        b = "Not found";
        if(cursor.moveToFirst())
        {
            do
            {
                a = cursor.getString(0);

                if(a.equals(loginEmail))
                {
                    b = cursor.getString(1);
                    break;
                }
            }while(cursor.moveToNext());
        }
        return b;
    }


    public boolean checkUser(String registerEmail){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select email from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String a;
        boolean b;
        b = true;
        if(cursor.moveToFirst())
        {
            do
            {
                a = cursor.getString(0);
                if(a.equals(registerEmail))
                {
                    b = false;
                    break;
                }
            }while(cursor.moveToNext());
        }
        return b;
    }
}