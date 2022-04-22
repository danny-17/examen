package com.example.examen.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.examen.entidades.Provedor;

import java.util.ArrayList;

public class DbProvedor extends DbHelper{

    Context context;

    public DbProvedor(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarProvedor(String nombre_comercial, String representante_legal, String direccion,String telefono, String productos,int credito){

        long id = 0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre_comercial", nombre_comercial);
            values.put("representante_legal", representante_legal);
            values.put("direccion", direccion);
            values.put("telefono", telefono);
            values.put("productos", productos);
            values.put("credito", credito);

            id = db.insert(TABLE_PROVEDOR, null, values);
        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }

    public ArrayList<Provedor> mostrarProvedor(){

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Provedor> listaProveedor = new ArrayList<>();
        Provedor provedor = null;
        Cursor cursorProvedor = null;

        cursorProvedor=db.rawQuery("SELECT * FROM " + TABLE_PROVEDOR, null);
        if(cursorProvedor.moveToFirst()){
            do {
                provedor = new Provedor();
                provedor.setRuc(cursorProvedor.getInt(0));
                provedor.setNombre_comercial(cursorProvedor.getString(1));
                provedor.setRepresentante_legal(cursorProvedor.getString(2));
                provedor.setDireccion(cursorProvedor.getString(3));
                provedor.setTelefono(cursorProvedor.getString(4));
                provedor.setProductos(cursorProvedor.getString(5));
                provedor.setCredito(cursorProvedor.getInt(6));
                listaProveedor.add(provedor);
            }while (cursorProvedor.moveToNext());
        }
        cursorProvedor.close();
        return listaProveedor;
    }

    public Provedor verProvedor(int ruc){

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Provedor provedor = null;
        Cursor cursorProvedor = null;

        cursorProvedor=db.rawQuery("SELECT * FROM " + TABLE_PROVEDOR + " WHERE ruc = " + ruc + " LIMIT 1 ", null);
        if(cursorProvedor.moveToFirst()){
            provedor = new Provedor();
            provedor.setRuc(cursorProvedor.getInt(0));
            provedor.setNombre_comercial(cursorProvedor.getString(1));
            provedor.setRepresentante_legal(cursorProvedor.getString(2));
            provedor.setDireccion(cursorProvedor.getString(3));
            provedor.setTelefono(cursorProvedor.getString(4));
            provedor.setProductos(cursorProvedor.getString(5));
            provedor.setCredito(cursorProvedor.getInt(6));
        }
        cursorProvedor.close();
        return provedor;
    }

    public boolean editarProvedor(int ruc, String nombre_comercial, String representante_legal, String direccion, String telefono, String productos){

        boolean correcto = false;
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            db.execSQL(" UPDATE " + TABLE_PROVEDOR + " SET nombre_comercial='"+ nombre_comercial+"', representante_legal='"+ representante_legal+"', direccion='"+ direccion+"', telefono='"+ telefono+"', productos='"+ productos+"' WHERE ruc='" + ruc +"'");
        }catch (Exception ex){
            ex.toString();
            correcto=false;
        }finally{
            db.close();
        }
        return correcto;
    }

}
