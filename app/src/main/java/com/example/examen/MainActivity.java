package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.examen.adaptadores.ListaProvedorAdapter;
import com.example.examen.bd.DbHelper;
import com.example.examen.bd.DbProvedor;
import com.example.examen.entidades.Provedor;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView listaProvedor;
    ArrayList<Provedor> listaArrayProvedor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaProvedor=findViewById(R.id.listaProvedor);
        listaProvedor.setLayoutManager(new LinearLayoutManager(this));

        DbProvedor dbProvedor = new DbProvedor(MainActivity.this);
        listaArrayProvedor = new ArrayList<>();
        ListaProvedorAdapter adapter = new ListaProvedorAdapter(dbProvedor.mostrarProvedor());
        listaProvedor.setAdapter(adapter);

    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.menuNuevo:
                nuevoRegistro();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void nuevoRegistro(){
        Intent intent = new Intent(this, Nuevo_Actitvity.class);
        startActivity(intent);
    }

}