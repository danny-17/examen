package com.example.examen.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "provedores.db";
    public static final String TABLE_PROVEDOR = "t_proveedor";


    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(" CREATE TABLE " + TABLE_PROVEDOR + "(" +

                "ruc INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre_comercial TEXT," +
                "representante_legal TEXT," +
                "direccion TEXT," +
                "telefono TEXT," +
                "productos TEXT," +
                "credito INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE " + TABLE_PROVEDOR);
        onCreate(sqLiteDatabase);
    }
}
