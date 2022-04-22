package com.example.examen;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.examen.bd.DbProvedor;
import com.example.examen.entidades.Provedor;

public class EditarActivity extends AppCompatActivity {

    EditText txtNombre, txtRepresentante, txtDireccion, txtTelefono, txtPoductos, txtCredito;
    Button btnGuarda;

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

            btnGuarda.setVisibility(View.INVISIBLE);

            txtNombre.setInputType(InputType.TYPE_NULL);
            txtRepresentante.setInputType(InputType.TYPE_NULL);
            txtDireccion.setInputType(InputType.TYPE_NULL);
            txtTelefono.setInputType(InputType.TYPE_NULL);
            txtPoductos.setInputType(InputType.TYPE_NULL);
            txtPoductos.setInputType(InputType.TYPE_NULL);

        }
    }
}