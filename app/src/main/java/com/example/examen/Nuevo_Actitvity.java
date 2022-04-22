package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.examen.bd.DbProvedor;

public class Nuevo_Actitvity extends AppCompatActivity {

    EditText txtNombre_Pro, txtRepresentante_Pre, txtDireccion, txtTelefono, txtProductos, txtCredito;
    Button btnGuarda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_actitvity);

        txtNombre_Pro = findViewById(R.id.txtNombre);
        txtRepresentante_Pre = findViewById(R.id.txtRepresentate_Pr);
        txtDireccion = findViewById(R.id.txtDireccion);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtProductos = findViewById(R.id.txtProductos);
        txtCredito = findViewById(R.id.txtCredito);

        btnGuarda = findViewById(R.id.btnGuardar);
        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbProvedor dbProvedor = new DbProvedor(Nuevo_Actitvity.this);
                long id = dbProvedor.insertarProvedor(txtNombre_Pro.getText().toString(), txtRepresentante_Pre.getText().toString(),txtDireccion.getText().toString(),txtTelefono.getText().toString(),txtProductos.getText().toString(), Integer.parseInt(txtCredito.getText().toString()));
                if(id>0){
                    Toast.makeText(Nuevo_Actitvity.this, "PROVEDOR GUARDADO", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Nuevo_Actitvity.this, "ERROR GUARDADO", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void limpiar(){
        txtNombre_Pro.setText("");
        txtRepresentante_Pre.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtProductos.setText("");
        txtCredito.setText("");
    }
}