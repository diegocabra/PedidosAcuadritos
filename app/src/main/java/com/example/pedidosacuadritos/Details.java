package com.example.pedidosacuadritos;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

import com.example.pedidosacuadritos.R;

public class Details extends AppCompatActivity {
    TextView textTitle,textDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //le paso mediante un "tag" la descripcion o titulo al adapter
        Intent i = getIntent();
        String title = i.getStringExtra("title");
        String descripcion = i.getStringExtra("descripcion");

        textTitle = findViewById(R.id.detailTitle);
        textDescripcion =findViewById(R.id.tv_descripcion);


        textTitle.setText(title);
        textDescripcion.setText(descripcion);
    }
}
