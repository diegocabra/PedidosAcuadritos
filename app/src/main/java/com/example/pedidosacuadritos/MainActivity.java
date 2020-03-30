package com.example.pedidosacuadritos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    protected TextView fecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fecha = findViewById(R.id.et_Fecha);
        fecha.setText(new Date().toString());
    }
}
