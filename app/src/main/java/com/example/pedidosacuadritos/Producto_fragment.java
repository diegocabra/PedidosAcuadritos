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
import com.example.pedidosacuadritos.Entidades.Producto.Adulto;
import com.example.pedidosacuadritos.Entidades.Producto.Producto;
import com.example.pedidosacuadritos.Entidades.Producto.jardin;
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
        catalogoProductos = new Catalogo();
        /**
        // TODO: 26/08/20 ---Esto lo vamos a hacer luego de manera manual mediante otra activity. --- INICIO

        Adulto p = new Adulto("cuadrille Negro","bolsillo azul","rojo","amarillo");
       catalogoProductos.AgregarProducto(p);
        catalogoProductos.AgregarProducto(new Adulto("Ambo Mujer Azul","Bolsillo Rayado","Blanco","Amarillo"));
        catalogoProductos.AgregarProducto(new Adulto("Cuadrille Verde","Sin bolsillo ","Negro","Amarillo"));
        catalogoProductos.AgregarProducto(new Adulto("Cuadrille Negro","Bolsillo Lunares ","Negro","Negro"));
        catalogoProductos.AgregarProducto(new jardin("Cuadrille Rosa","Bolsillo Flores Chicas","Coral","Rosado"));
        catalogoProductos.AgregarProducto(new Adulto("Ambo Negro","Bolsillo Liso","Blanco con lunares","Blanco"));
        catalogoProductos.AgregarProducto(new Adulto("Liso Negro","Bolsillo Verde","rojo","amarillo"));
        catalogoProductos.AgregarProducto(new Adulto(" Rayado Negro","Bolsillo Azul","Lunares","Azul"));

*/

        //---Esto lo vamos a hacer luego de manera manual mediante otra activity. -----.FIN.


        // Lookup the recyclerview in activity layout
        recyclerView = getView().findViewById(R.id.RecyclerViewProductos);

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
