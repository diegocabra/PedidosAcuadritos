package com.example.pedidosacuadritos;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class First_ClienteFragment extends Fragment {


   private EditText getEt_Nombre, getEt_Email,getEt_Telefono,getEt_Ciudad;
    private Button bt_Agregar;

    public First_ClienteFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_cliente, container, false);


    }

    public void onViewCreated(View view,  Bundle savedInstanceState) {
        getEt_Nombre = getView().findViewById(R.id.et_Nombre);
        getEt_Telefono = getView().findViewById(R.id.et_Telefono);
        getEt_Email = getView().findViewById(R.id.et_Email);
        getEt_Ciudad = getView().findViewById(R.id.et_Ciudad);


        bt_Agregar = getView().findViewById(R.id.bt_Agregar);

        bt_Agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                camposObligatorios();//Antes de guardar , se fija que tengan los campos obligatorios validos.
                //String nombre = getEt_Nombre.getText().toString();
                //                Toast.makeText(getActivity(),nombre, Toast.LENGTH_LONG).show();

            }
        });




    }
// REVISAR ESTA VALIDACION CHOTA ; no controla ambas.
    private void camposObligatorios() {
        if (getEt_Nombre.getText().toString().equals(""))
        getEt_Nombre.setError("Campo Requerido");
        if (getEt_Telefono.getText().toString().equals(""))
            getEt_Telefono.setError("Campo Requerido");



    }
}

