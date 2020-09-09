package com.example.pedidosacuadritos;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.pedidosacuadritos.Catalogo.Catalogo;
import com.example.pedidosacuadritos.Entidades.Producto.Producto;
import com.example.pedidosacuadritos.Utilidades.AdapterRecyclerView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Producto_fragment extends Fragment {


    public Producto_fragment() {
        // Required empty public constructor
    }

    Catalogo catalogoProductos;
    RecyclerView recyclerView;
    AdapterRecyclerView adapter;
    List<Producto> items;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_producto, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {

        // TODO: 26/08/20 ---Esto lo vamos a hacer luego de manera manual mediante otra activity. --- INICIO


/**
        Adulto p = new Adulto(UUID.randomUUID().toString(),"cuadrille Negro","bolsillo azul","rojo","amarillo");
        catalogoProductos.AgregarProducto(p);
        catalogoProductos.AgregarProducto(new Adulto("cuadrille Azul","bolsillo azul","rojo","amarillo"));
        catalogoProductos.AgregarProducto(new Adulto("cuadrille Verde","Sin bolsillo ","negro","amarillo"));
        catalogoProductos.AgregarProducto(new Adulto("cuadrille Negro","bolsillo azul","rojo","amarillo"));
        catalogoProductos.AgregarProducto(new jardin("cuadrille Rosa","bolsillo azul","rojo","amarillo"));
        catalogoProductos.AgregarProducto(new Adulto("cuadrille Negro","bolsillo azul","blanco con lunares","amarillo"));
        catalogoProductos.AgregarProducto(new Adulto("Liso Negro","bolsillo Verde","rojo","amarillo"));
        catalogoProductos.AgregarProducto(new Adulto(" rayado Negro","bolsillo azul","azul","amarillo"));
*/


        //---Esto lo vamos a hacer luego de manera manual mediante otra activity. -----.FIN.


        // Lookup the recyclerview in activity layout
        recyclerView = getView().findViewById(R.id.RecyclerViewProductos);
        catalogoProductos = new Catalogo();
        items = catalogoProductos.getCatalogoProductos();
        // Create adapter passing in the sample user data
        adapter = new AdapterRecyclerView(items);
        // Attach the adapter to the recyclerview to populate items
        recyclerView.setAdapter(adapter);
        // Set layout manager to position the items
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //agrega una linea entre elementos del Recycler view
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));





    }




}
