package com.example.pedidosacuadritos;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.Observer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.example.pedidosacuadritos.Utilidades.PageViewModel;
import com.example.pedidosacuadritos.Entidades.Persona.Cliente;


public class Third extends Fragment {

    private TextView tv_nombreCliente,tv_precio;
    private RadioGroup modoPago;
    private PageViewModel pageViewModel;


    public Third() {
        // Required empty public constructor
    }

    public static Third newInstance(){
        return new Third();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Inicializamos el Viewmodel


    }

        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {

        tv_nombreCliente = getView().findViewById(R.id.tv_Titulo);

        pageViewModel = ViewModelProviders.of(requireActivity()).get(PageViewModel.class);
        pageViewModel.getPedido().observe(getViewLifecycleOwner(), new Observer<Cliente>() { //Observer de clientes seleccionados en el fragments uno.
                    @Override
                    public void onChanged(Cliente cliente) {
                        tv_nombreCliente.setText("CLIENTE : "+ cliente.getNombre());
                    }
                });


                //modoPago.getCheckedRadioButtonId();

    }
}
