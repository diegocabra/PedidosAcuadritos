package com.example.pedidosacuadritos.Utilidades;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.pedidosacuadritos.Entidades.Persona.Cliente;
import com.example.pedidosacuadritos.Entidades.Persona.Persona;
import com.example.pedidosacuadritos.Entidades.Producto.Adulto;
import com.example.pedidosacuadritos.Entidades.Producto.Producto;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
//Mediante la siguiente clase vamos a conectar el fragment necesario a la base de datos,Firebase.
public class BaseDatoService {



    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;
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

    public void write (Adulto producto)
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Productos");
        myRef.child(producto.getId()).setValue(producto);


    }
    public void delete(Persona persona) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Persona");
        myRef.child("Cliente").child(persona.getId()).removeValue();
    }

    public List<Cliente> listarDatos(){
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

    public List<Adulto> listarProductos(){
        final List<Adulto> ListaProductos = new ArrayList<Adulto>();
        Log.e("listar", "estoy aca");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Productos");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange (@NonNull DataSnapshot dataSnapshot) {
                ListaProductos.clear();
                for (DataSnapshot objSnapshot : dataSnapshot.getChildren()){
                    Adulto prod = objSnapshot.getValue(Adulto.class);
                    Log.e("ID PERSONA ","HOLA");
                    ListaProductos.add(prod);}

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                int i;
            }
        });
        return ListaProductos;
    }



}
