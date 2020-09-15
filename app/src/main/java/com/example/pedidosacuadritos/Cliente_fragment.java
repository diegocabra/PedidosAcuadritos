package com.example.pedidosacuadritos;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.pedidosacuadritos.Pedido.Pedido;
import com.example.pedidosacuadritos.Utilidades.BaseDatoService;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

import com.example.pedidosacuadritos.Entidades.Persona.Cliente;
import com.example.pedidosacuadritos.Entidades.Persona.Persona;
import com.example.pedidosacuadritos.Utilidades.PageViewModel;


public class Cliente_fragment extends Fragment {


    ArrayAdapter<Cliente> arrayAdapterCliente;
    private EditText getEt_Nombre, getEt_Email, getEt_Telefono, getEt_Ciudad;
    private Button bt_Agregar, bt_Actualizar, bt_Eliminar,bt_Clean;
    private ListView listV_Clientes;
    private List<Cliente> listaClientes = new ArrayList<Cliente>();
    private Persona personaSeleccionada;
    private PageViewModel pageViewModel;
    private Pedido pedidoTemporal;

    public Cliente_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_cliente, container, false);
        return view;
    }

   @Override
      public void onResume() {
        super.onResume();
       ActualizarListView();

    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        getEt_Nombre = getView().findViewById(R.id.et_Nombre);
        getEt_Telefono = getView().findViewById(R.id.et_Telefono);
        getEt_Email = getView().findViewById(R.id.et_Email);
        getEt_Ciudad = getView().findViewById(R.id.et_Ciudad);
        bt_Agregar = getView().findViewById(R.id.bt_Agregar);
        bt_Actualizar = getView().findViewById(R.id.bt_Actualizar);
        bt_Clean = getView().findViewById(R.id.bt_clean);
        bt_Eliminar = getView().findViewById(R.id.bt_Eliminar);

        pageViewModel = ViewModelProviders.of(requireActivity()).get(PageViewModel.class); //Inicializo el viewModel
        final  ListView listV_Clientes = view.findViewById(R.id.listV_Clientes);

        pageViewModel.getClientes().observe(this, new Observer<List<Cliente>>() {
            @Override
            public void onChanged(List<Cliente> clientes) {
                arrayAdapterCliente = new ArrayAdapter<Cliente>(getActivity(),android.R.layout.simple_list_item_1,clientes);
                listV_Clientes.setAdapter(arrayAdapterCliente);
            }
        });

        personaSeleccionada = PersonaSeleccionado(listV_Clientes);

        bt_Actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (camposObligatorios())
                {
                Persona P = new Cliente();
                P.setId(personaSeleccionada.getId());
                P.setNombre(getEt_Nombre.getText().toString());
                P.setEmail(getEt_Email.getText().toString());
                P.setLocalidad(getEt_Ciudad.getText().toString());
                P.setTelefono(getEt_Telefono.getText().toString());
                BaseDatoService Basedatos = BaseDatoService.getInstance();

                Basedatos.write(P);
                Toast.makeText(getActivity(), "Cliente Actualizado", Toast.LENGTH_LONG).show();
                limpiarEditTexts();
                    ActualizarListView();
                }

            }
        });

        bt_Agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (camposObligatorios()) //Antes de guardar , se fija que tengan los campos obligatorios validos.
                {Cliente Nuevo = new Cliente(UUID.randomUUID().toString(), getEt_Nombre.getText().toString(), getEt_Telefono.getText().toString(), getEt_Ciudad.getText().toString(), getEt_Email.getText().toString());
                BaseDatoService Basedatos = BaseDatoService.getInstance();
                Basedatos.write(Nuevo);
                Toast.makeText(getActivity(), "Cliente Agregado", Toast.LENGTH_LONG).show();
                limpiarEditTexts();
                ActualizarListView();
            } }
        });


        bt_Eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (camposObligatorios()) //Antes de guardar , se fija que tengan los campos obligatorios validos.
                {

                    BaseDatoService Basedatos = BaseDatoService.getInstance();
                    Basedatos.delete(personaSeleccionada);
                    Toast.makeText(getActivity(), "Cliente Eliminado", Toast.LENGTH_LONG).show();
                    limpiarEditTexts();
                    ActualizarListView();

                }
            }
        });

        bt_Clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiarEditTexts();
            }
        });

    }

    private void ActualizarListView() {
        //Actualizo el Array Adapter de clientes
        arrayAdapterCliente.notifyDataSetChanged();
    }

    private Persona PersonaSeleccionado(ListView listV_Clientes) {

        listV_Clientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                personaSeleccionada = (Cliente) parent.getItemAtPosition(position);
                getEt_Nombre.setText(personaSeleccionada.getNombre());
                getEt_Telefono.setText(personaSeleccionada.getTelefono());
                getEt_Email.setText(personaSeleccionada.getEmail());
                getEt_Ciudad.setText(personaSeleccionada.getLocalidad());
                Pedido pedidoTemporal = Pedido.getInstance();
                pedidoTemporal.setCliente((Cliente) personaSeleccionada); //armo un pedido temporal y le asigno el cliente nuevo,
                pageViewModel.setPedido(pedidoTemporal);    // "LE paso" al viewModel el pedido que quiero que conserve para el otro fragment
            }
        });
        return personaSeleccionada;
    }


    private boolean camposObligatorios() {

        if ((getEt_Nombre.getText().toString()).isEmpty())
            getEt_Nombre.setError("Campo Requerido");
        if ((getEt_Telefono.getText().toString()).isEmpty())
            getEt_Telefono.setError("Campo Requerido");

        return  !((getEt_Nombre.getText().toString()).isEmpty()) & !((getEt_Telefono.getText().toString()).isEmpty()) ;
    }


    private void limpiarEditTexts() {
        getEt_Nombre.setText("");
        getEt_Telefono.setText("");
        getEt_Email.setText("");
        getEt_Ciudad.setText("");
    }


}

