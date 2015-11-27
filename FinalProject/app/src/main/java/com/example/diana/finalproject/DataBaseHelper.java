package com.example.diana.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Diana on 11/27/15.
 */
public class DataBaseHelper extends SQLiteOpenHelper{

    public static final String DB_NAME = "bolsaTrabajo.db";
    public static final String TABLE_NAMEB = "perfil";
    public static final String COL_1B = "MATRICULA";
    public static final String COL_2B = "EXPERIENCIA";
    public static final String COL_3B = "PROYECTOS";
    public static final String COL_4B = "HABILIDADES";
    public static final String COL_5B = "INTERESES";
    public static final String COL_6B = "EXTRA";
    public static final String COL_7B = "FOTO";



    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAMEB +
                " (MATRICULA STRING PRIMARY KEY, EXPERIENCIA TEXT, PROYECTOS TEXT, HABILIDADES TEXT, INTERESES TEXT, EXTRA TEXT, FOTO INTEGER);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public boolean insertDataProfile(String matricula,String experiencia, String proyectos, String habilidades, String intereses, String extra, int foto) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1B, matricula);
        contentValues.put(COL_2B,experiencia);
        contentValues.put(COL_3B, proyectos);
        contentValues.put(COL_4B, habilidades);
        contentValues.put(COL_5B,intereses);
        contentValues.put(COL_6B,extra);
        contentValues.put(COL_7B,foto);
        long result = db.insert(TABLE_NAMEB, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean updateDataProfile(String matricula,String experiencia, String proyectos, String habilidades, String intereses, String extra) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1B, matricula);
        contentValues.put(COL_2B, experiencia);
        contentValues.put(COL_3B, proyectos);
        contentValues.put(COL_4B, habilidades);
        contentValues.put(COL_5B,intereses);
        contentValues.put(COL_6B,extra);

        db.update(TABLE_NAMEB, contentValues, "MATRICULA = ?", new String[]{matricula});
        return true;
    }

    public boolean updateDataProfilePic(String matricula,int foto){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_7B,foto);

        db.update(TABLE_NAMEB, contentValues, "MATRICULA = ?", new String[]{matricula});
        return true;

    }

    public Cursor getDataProfile(String matricula) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result  = db.rawQuery("SELECT * FROM " + TABLE_NAMEB + " WHERE MATRICULA =" + matricula, null);
        return result;
    }




}
