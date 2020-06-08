package com.example.pedidosacuadritos;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.pedidosacuadritos.BaseDatoService;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

import com.example.pedidosacuadritos.Entidades.Cliente;

/**
 * A simple {@link Fragment} subclass.
 */
public class First_ClienteFragment extends Fragment {


    private EditText getEt_Nombre, getEt_Email, getEt_Telefono, getEt_Ciudad;
    private Button bt_Agregar;
    private ListView listV_Clientes;
    private List<Cliente> listaClientes = new ArrayList<Cliente>();
    ArrayAdapter<Cliente> arrayAdapterCliente;

    public First_ClienteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cliente, container, false);

    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        getEt_Nombre = getView().findViewById(R.id.et_Nombre);
        getEt_Telefono = getView().findViewById(R.id.et_Telefono);
        getEt_Email = getView().findViewById(R.id.et_Email);
        getEt_Ciudad = getView().findViewById(R.id.et_Ciudad);
        bt_Agregar = getView().findViewById(R.id.bt_Agregar);
        ListView listV_Clientes = getView().findViewById(R.id.listV_Clientes);
        BaseDatoService Basedatos = BaseDatoService.getInstance();
        listaClientes = Basedatos.listarDatos();
        arrayAdapterCliente = new ArrayAdapter<Cliente>(getActivity(), android.R.layout.simple_list_item_1, listaClientes);
        listV_Clientes.setAdapter(arrayAdapterCliente);

        bt_Agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                camposObligatorios();//Antes de guardar , se fija que tengan los campos obligatorios validos.
                Cliente Nuevo = new Cliente(UUID.randomUUID().toString(), getEt_Nombre.getText().toString(), getEt_Telefono.getText().toString(), getEt_Ciudad.getText().toString());
                //  Log.e("Cliente",""+"Nombre :"+Nuevo.getNombre()+"Localidad :"+Nuevo.getLocalidad()+"- Telefono :"+Nuevo.getTelefono()+"-ID :"+Nuevo.getId());
                BaseDatoService Basedatos = BaseDatoService.getInstance();
                Basedatos.write(Nuevo);
                Toast.makeText(getActivity(), "Cliente Agregado", Toast.LENGTH_SHORT).show();
                limpiarEditTexts();
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


    private void limpiarEditTexts() {
        getEt_Nombre.setText("");
        getEt_Telefono.setText("");
        getEt_Email.setText("");
        getEt_Ciudad.setText("");
    }


}

