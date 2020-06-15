package com.example.pedidosacuadritos.Utilidades;

import androidx.annotation.NonNull;

import com.example.pedidosacuadritos.Entidades.Persona.Cliente;
import com.example.pedidosacuadritos.Entidades.Persona.Persona;
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
        DatabaseReference myRef = database.getReference("Clientes");
      //  database.setPersistenceEnabled(true);
        myRef.child("Cliente").child(persona.getId()).setValue(persona);

    }

    public List<Cliente> listarDatos(){
        final List<Cliente> ListaClientes = new ArrayList<Cliente>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Clientes");
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



    public void basicReadWrite() {
        // [START write_message]
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");


        // [END write_message]

        // [START read_message]
        // Read from the database
        /**   myRef.addValueEventListener(new ValueEventListener() {
        @Override public void onDataChange(DataSnapshot dataSnapshot) {
        // This method is called once with the initial value and again
        // whenever data at this location is updated.
        String value = dataSnapshot.getValue(String.class);
        Log.d(TAG, "Value is: " + value);
        }

        @Override public void onCancelled(DatabaseError error) {
        // Failed to read value
        Log.w(TAG, "Failed to read value.", error.toException());
        }
        });*/
        // [END read_message]

    }
}
