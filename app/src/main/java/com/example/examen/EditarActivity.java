package com.example.examen;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.examen.bd.DbProvedor;
import com.example.examen.entidades.Provedor;

public class EditarActivity extends AppCompatActivity {

    EditText txtNombre, txtRepresentante, txtDireccion, txtTelefono, txtPoductos, txtCredito;
    Button btnGuarda;

    boolean correcto = false;

    Provedor provedor;
    int ruc = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);

        txtNombre=findViewById(R.id.txtNombre);
        txtRepresentante=findViewById(R.id.txtRepresentate_Pr);
        txtDireccion=findViewById(R.id.txtDireccion);
        txtTelefono=findViewById(R.id.txtTelefono);
        txtPoductos=findViewById(R.id.txtProductos);
        txtCredito=findViewById(R.id.txtCredito);

        btnGuarda=findViewById(R.id.btnGuardar);

        if(savedInstanceState==null){
            Bundle extras = getIntent().getExtras();
            if(extras==null){
                ruc= Integer.parseInt(null);
            }else{
                ruc=extras.getInt("RUC");
            }
        }else{
            ruc=(int) savedInstanceState.getSerializable("RUC");
        }

        DbProvedor dbProvedor = new DbProvedor(EditarActivity.this);
        provedor=dbProvedor.verProvedor(ruc);

        if(provedor!=null){
            txtNombre.setText(provedor.getNombre_comercial());
            txtRepresentante.setText(provedor.getRepresentante_legal());
            txtDireccion.setText(provedor.getDireccion());
            txtTelefono.setText(provedor.getTelefono());
            txtPoductos.setText(provedor.getProductos());
            //txtCredito.setText(provedor.getCredito());
        }
        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!txtNombre.getText().toString().equals("") &&!txtRepresentante.getText().toString().equals("") &&!txtDireccion.getText().toString().equals("")&&!txtTelefono.getText().toString().equals("")&&!txtPoductos.getText().toString().equals("")){
                    correcto=dbProvedor.editarProvedor(ruc, txtNombre.getText().toString(), txtRepresentante.getText().toString(),txtDireccion.getText().toString(),txtTelefono.getText().toString(),txtPoductos.getText().toString());
                    if(correcto){
                        Toast.makeText(EditarActivity.this, "Provedor Editado", Toast.LENGTH_SHORT).show();
                        verRegistro();
                    }else{
                        Toast.makeText(EditarActivity.this, "Provedor Editado", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(EditarActivity.this, "Llene todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void verRegistro(){
        Intent intent = new Intent(this, VerActivity.class);
        intent.putExtra("RUC", ruc);
        startActivity(intent);
    }
}