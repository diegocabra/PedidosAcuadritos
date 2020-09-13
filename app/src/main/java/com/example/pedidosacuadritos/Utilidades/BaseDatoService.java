package com.example.pedidosacuadritos.Utilidades;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.pedidosacuadritos.Entidades.Persona.Cliente;
import com.example.pedidosacuadritos.Entidades.Persona.Persona;
import com.example.pedidosacuadritos.Entidades.Producto.Adulto;
import com.example.pedidosacuadritos.Entidades.Producto.Producto;
import com.example.pedidosacuadritos.Pedido.Pedido;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
//Mediante la siguiente clase vamos a conectar el fragment necesario a la base de datos,Firebase.
public class BaseDatoService {




    private static BaseDatoService instance;


    private BaseDatoService() {

    }

    public static BaseDatoService getInstance() {

        if (instance == null)
            instance = new BaseDatoService();

        return instance;
 }

    public void write(Persona persona){

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ReferenciaData = database.getReference("Persona");
         ReferenciaData.child("Cliente").child(persona.getId()).setValue(persona);

    }

    public void write (Producto producto)
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Productos");
        myRef.child(producto.getId()).setValue(producto);
        // TODO: 23/08/20 Agregar genericidad para poder agregar todos los productos pero por grupos , ejemplo los Adultos en una hoja , los niños en otra "hoja".

    }

    public void write (Pedido pedido)
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Pedidos");
        myRef.child(pedido.getId()).setValue(pedido);


    }
    public void delete(Persona persona) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Persona");
        myRef.child("Cliente").child(persona.getId()).removeValue();
    }

    public List<Cliente> listarClientes(){
        final List<Cliente> ListaClientes = new ArrayList<Cliente>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Persona");
        myRef.child("Cliente").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ListaClientes.clear();
                for (DataSnapshot objSnapshot : dataSnapshot.getChildren()){
                    Cliente p = objSnapshot.getValue(Cliente.class);
                    ListaClientes.add(p);}
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            int i;
            }
        });
        return ListaClientes;
    }


    // TODO: 26/08/20  ¿ Acaso este listar datos, no se podra hacer mas generico ? Alta paja, los dos iguales

    public List<Producto> listarProductos(){
        final List<Producto> ListaProductos = new ArrayList<Producto>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Productos");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange (@NonNull DataSnapshot dataSnapshot) {
                ListaProductos.clear();
                for (DataSnapshot objSnapshot : dataSnapshot.getChildren()){
                    Producto prod = objSnapshot.getValue(Producto.class);
                    ListaProductos.add(prod);}

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                int i;
            }
        });
        return ListaProductos;
    }

    public List<Pedido> listarPedidos(){
        final List<Pedido> listaPedidos = new ArrayList<Pedido>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Pedidos");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange (@NonNull DataSnapshot dataSnapshot) {
                listaPedidos.clear();
                for (DataSnapshot objSnapshot : dataSnapshot.getChildren()){
                    Pedido pedido = objSnapshot.getValue(Pedido.class);
                    listaPedidos.add(pedido);}

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                int i;
            }
        });
        return listaPedidos;
    }



}
