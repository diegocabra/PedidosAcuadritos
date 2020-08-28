package com.example.pedidosacuadritos;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class detalle_Producto extends AppCompatActivity {
    TextView textTitle,textDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_producto);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //le paso mediante un "tag" la descripcion o titulo al adapter
        Intent i = getIntent();
        String title = i.getStringExtra("Titulo");
        String descripcion = i.getStringExtra("descripcion");

        textTitle = findViewById(R.id.tv_Ttuloppal);
        textDescripcion =findViewById(R.id.tv_descripcion);


        textTitle.setText(title);
        textDescripcion.setText(descripcion);
    }
}
