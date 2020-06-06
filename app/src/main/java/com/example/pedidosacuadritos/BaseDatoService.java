package com.example.pedidosacuadritos;

import com.example.pedidosacuadritos.Entidades.Persona;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
        DatabaseReference myRef = database.getReference("message");

        //myRef.setValue("Hello, World!");
        myRef.child("Cliente").child(persona.getId()).setValue(persona);

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
