package com.example.examen.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen.R;
import com.example.examen.VerActivity;
import com.example.examen.entidades.Provedor;

import java.util.ArrayList;

public class ListaProvedorAdapter extends RecyclerView.Adapter<ListaProvedorAdapter.ProvedorViewHolder> {

    ArrayList<Provedor> listaProvedor;
    public ListaProvedorAdapter(ArrayList<Provedor>listaProvedor){
        this.listaProvedor=listaProvedor;
    }

    @NonNull
    @Override
    public ProvedorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_provedor, null, false);
        return new ProvedorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProvedorViewHolder holder, int position) {
        holder.viewNombre.setText(listaProvedor.get(position).getNombre_comercial());
        holder.viewRepresentante.setText(listaProvedor.get(position).getRepresentante_legal());
        holder.viewDireccion.setText(listaProvedor.get(position).getDireccion());
        holder.viewTelefono.setText(listaProvedor.get(position).getTelefono());
        holder.viewProductos.setText(listaProvedor.get(position).getProductos());
        //holder.viewCredito.setText(listaProvedor.get(position).getCredito());
    }

    @Override
    public int getItemCount() {
        return listaProvedor.size();
    }

    public class ProvedorViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombre, viewRepresentante, viewDireccion, viewTelefono, viewProductos, viewCredito;

        public ProvedorViewHolder(@NonNull View itemView) {
            super(itemView);
            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewRepresentante = itemView.findViewById(R.id.viewRepresentante);
            viewDireccion = itemView.findViewById(R.id.viewDireccion);
            viewTelefono = itemView.findViewById(R.id.viewTelefono);
            viewProductos = itemView.findViewById(R.id.viewProductos);
            viewCredito = itemView.findViewById(R.id.viewCredito);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, VerActivity.class);
                    intent.putExtra("RUC", listaProvedor.get(getAdapterPosition()).getRuc());
                    context.startActivity(intent);

                }
            });

        }
    }
}
