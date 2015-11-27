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
    public static final String COL_1B = "MATRICULA1";
    public static final String COL_2B = "EXPERIENCIA";
    public static final String COL_3B = "PROYECTOS";
    public static final String COL_4B = "HABILIDADES";
    public static final String COL_5B = "INTERESES";
    public static final String COL_6B = "EXTRA";
    public static final String COL_7B = "FOTO";

    public static final String TABLE_NAME = "USER";
    public static final String COL_1 = "MATRICULA";
    public static final String COL_2 = "NOMBRE";
    public static final String COL_3 = "APELLIDOS";
    public static final String COL_4 = "CORREO_ALT";
    public static final String COL_5 = "CONTRASENA";


    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAMEB +
                " (MATRICULA1 TEXT PRIMARY KEY NOT NULL, EXPERIENCIA TEXT, PROYECTOS TEXT, HABILIDADES TEXT, INTERESES TEXT, EXTRA TEXT, FOTO INTEGER);");

        db.execSQL("CREATE TABLE " + TABLE_NAME +
                " (MATRICULA TEXT PRIMARY KEY NOT NULL, NOMBRE TEXT, APELLIDOS TEXT, CORREO_ALT TEXT, CONTRASENA TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //metodos para insertar o consultar informacion de USER
    public boolean registerUser(String matricula, String nombre, String apellidos, String correo_alt, String contrasena) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, matricula);
        contentValues.put(COL_2, nombre);
        contentValues.put(COL_3, apellidos);
        contentValues.put(COL_4, correo_alt);
        contentValues.put(COL_5, contrasena);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getMail(String matricula) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result  = db.rawQuery("SELECT CORREO_ALT FROM " + TABLE_NAME + " WHERE MATRICULA =" + matricula, null);
        return result;
    }

    public Cursor getInicio(String matricula, String contrasena) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result  = db.rawQuery("SELECT MATRICULA, CONTRASENA FROM " + TABLE_NAME + " WHERE MATRICULA =" + matricula, null);
        return result;
    }


    //metodos para insertar o consultar informacion de PROFILE
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

    public boolean updateDataProfile(String matricula,String experiencia, String proyectos, String habilidades, String intereses, String extra, int foto) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1B, matricula);
        contentValues.put(COL_2B, experiencia);
        contentValues.put(COL_3B, proyectos);
        contentValues.put(COL_4B, habilidades);
        contentValues.put(COL_5B,intereses);
        contentValues.put(COL_6B,extra);
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
