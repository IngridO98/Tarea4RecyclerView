package com.example.tarea4recyclerview.Adaptadores;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tarea4recyclerview.Actividades.MainActivity;
import com.example.tarea4recyclerview.Modelos.Restaurantes;
import com.example.tarea4recyclerview.R;

import java.util.ArrayList;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> {

    ArrayList<Restaurantes> listaDatos;
    Activity activity;
    RequestOptions opcion;

    public AdapterDatos(ArrayList<Restaurantes> listaDatos, Activity activity) {
        this.listaDatos = listaDatos;
        this.activity = activity;
        opcion=new RequestOptions().centerCrop().placeholder(R.drawable.fondoimagen).error(R.drawable.fondoimagen);
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fila_ejemplo,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.txtNombre.setText(listaDatos.get(position).getNombre());
        holder.txtDireccion.setText(listaDatos.get(position).getDireccion());
        holder.txtTelefono.setText(listaDatos.get(position).getTelefono());
        holder.txtHorario.setText(listaDatos.get(position).getHorarios());
        holder.txtCategoria.setText(listaDatos.get(position).getCategoria());

        Glide.with(holder.itemView).load(listaDatos.get(position).getFoto()).into(holder.ivFoto);
    }

    @Override
    public int getItemCount() {
        return listaDatos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView txtNombre, txtDireccion, txtTelefono, txtHorario, txtCategoria;
        ImageView ivFoto;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            txtNombre=itemView.findViewById(R.id.RestNombre);
            txtDireccion=itemView.findViewById(R.id.RestDireccion);
            txtCategoria=itemView.findViewById(R.id.ResCategoria);
            txtHorario=itemView.findViewById(R.id.RestHorario);
            txtTelefono=itemView.findViewById(R.id.RestTelefono);
            ivFoto=itemView.findViewById(R.id.imgFotoRes);
        }
    }
}
