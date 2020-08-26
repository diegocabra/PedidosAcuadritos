package com.example.pedidosacuadritos.Utilidades;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pedidosacuadritos.Details;
import com.example.pedidosacuadritos.Entidades.Producto.Adulto;
import com.example.pedidosacuadritos.Entidades.Producto.Producto;
import com.example.pedidosacuadritos.R;

import java.util.List;


public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {


    private int globalPosition;
    //Guardamos una lista de productos disponibles
    private List<Producto> Lproductos;


    public AdapterRecyclerView(List<Producto> productos) {
        Lproductos = productos;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View productosView = inflater.inflate(R.layout.recycler_view_item_1, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(productosView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterRecyclerView.ViewHolder viewHolder, int position) {

        // Get the data model based on position
        Producto producto = Lproductos.get(position);
        TextView textView2 = viewHolder.textTitle;
        textView2.setText(producto.getTela());
        TextView textView = viewHolder.textDescription;
        textView.setText(producto.getBolsillo());
        ImageView im = viewHolder.img;
        im.setImageResource(R.drawable.azulbolsillorayado);

        //Mediante este if puedo saber cual es la posicion seleccionada y la cambio de color Rojo
        if (position == globalPosition)
            viewHolder.itemView.setBackgroundColor(Color.LTGRAY); // Si el item es seleccionado cambia a Gris
        else
            viewHolder.itemView.setBackgroundColor(Color.TRANSPARENT); // Si el item no es seleccionado se queda en transparente

    }

    @Override
    public int getItemCount() {
        return Lproductos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textTitle, textDescription;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //listener del ITEMVIEW
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //globalPosition tengo la posicion en donde esta parado o seleccionado el adapter, cuando selecciono un ITEM
                    globalPosition = getAdapterPosition();
                    notifyDataSetChanged();

                }
            });
            textTitle = itemView.findViewById(R.id.tv_titulo);
            textDescription = itemView.findViewById(R.id.tv_descripcion);
            img = itemView.findViewById(R.id.imv_modelo);
            //Evento de cuando mantengo presionado el item por un tiempo mas prolongado .
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {


                    Intent i = new Intent(v.getContext(), Details.class);
                    i.putExtra("title", Lproductos.get(getAdapterPosition()).getTela());

                    i.putExtra("descripcion", Lproductos.get(getAdapterPosition()).getBolsillo());
                    v.getContext().startActivity(i);
                    return false;
                }
            });

        }

    }
}

