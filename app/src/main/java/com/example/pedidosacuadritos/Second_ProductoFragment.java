package com.example.pedidosacuadritos;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.pedidosacuadritos.Entidades.Producto.Adulto;
import com.example.pedidosacuadritos.Entidades.Producto.Inventario;
import com.example.pedidosacuadritos.Entidades.Producto.Producto;
import com.example.pedidosacuadritos.Utilidades.AdapterRecyclerView;

import java.util.ArrayList;
import java.util.LinkedList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Second_ProductoFragment extends Fragment {


    public Second_ProductoFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    AdapterRecyclerView adapter;
    LinkedList<Producto> items;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_producto, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {

        //---Esto lo vamos a hacer luego de manera manual mediante otra activity. --- INICIO
        Inventario.getInstance().AgregarProducto(new Adulto("1","cuadrille Negro","bolsillo azul","rojo","amarillo"));
        Inventario.getInstance().AgregarProducto(new Adulto("1","cuadrille Azul","bolsillo azul","rojo","amarillo"));
        Inventario.getInstance().AgregarProducto(new Adulto("1","cuadrille Verde","Sin bolsillo ","rojo","amarillo"));
        Inventario.getInstance().AgregarProducto(new Adulto("1","cuadrille Negro","bolsillo azul","rojo","amarillo"));
        Inventario.getInstance().AgregarProducto(new Adulto("1","cuadrille Rosa","bolsillo azul","rojo","amarillo"));
        Inventario.getInstance().AgregarProducto(new Adulto("1","cuadrille Negro","bolsillo azul","rojo","amarillo"));
        Inventario.getInstance().AgregarProducto(new Adulto("1","Liso Negro","bolsillo Verde","rojo","amarillo"));
        Inventario.getInstance().AgregarProducto(new Adulto("1"," rayado Negro","bolsillo azul","rojo","amarillo"));

        //---Esto lo vamos a hacer luego de manera manual mediante otra activity. -----.FIN.


        // Lookup the recyclerview in activity layout
        recyclerView = getView().findViewById(R.id.RecyclerViewProductos);

        Inventario InventarioProductos = Inventario.getInstance();
        items = InventarioProductos.getLista();
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
