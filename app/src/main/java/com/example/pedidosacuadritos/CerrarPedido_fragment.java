package com.example.pedidosacuadritos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.Observer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pedidosacuadritos.Entidades.Producto.Adulto;
import com.example.pedidosacuadritos.Entidades.Producto.Producto;
import com.example.pedidosacuadritos.Pedido.Pedido;
import com.example.pedidosacuadritos.Utilidades.BaseDatoService;
import com.example.pedidosacuadritos.Utilidades.PageViewModel;
import com.example.pedidosacuadritos.Entidades.Persona.Cliente;
import com.example.pedidosacuadritos.Utilidades.ProductosViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class CerrarPedido_fragment extends Fragment {

    private TextView tv_nombreCliente,tv_precio,tvdeprueba;
    private RadioGroup modoPago;
    private PageViewModel pageViewModel;
    private FloatingActionButton FAB_ConfirmarPedido;
    private Pedido nuevo_pedido;
    private Cliente cli_actual;
    private String pedidoSeleccionado;
    private ProductosViewModel productosViewModel;

    public CerrarPedido_fragment() {
        // Required empty public constructor
    }

        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pedido, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {

        tv_nombreCliente = getView().findViewById(R.id.tv_Titulo);

        tvdeprueba = getView().findViewById(R.id.tv_prueba);

        pageViewModel = ViewModelProviders.of(requireActivity()).get(PageViewModel.class);
        pageViewModel.getPedido().observe(getViewLifecycleOwner(), new Observer<Pedido>() { //Observer de clientes seleccionados en el fragments uno.
            @Override
            public void onChanged(Pedido pedido) {
                tv_nombreCliente.setText("CLIENTE : "+ pedido.getCliente().getNombre());
            }
        });


        String texto ="";
        productosViewModel = ViewModelProviders.of(this).get(ProductosViewModel.class);


        if (productosViewModel.getListProductos().size()>0){
            for (Producto producto : productosViewModel.getListProductos()){
                texto+=producto.getTela()+ " "+producto.getBies1()+"\n";
            }
            tvdeprueba.setText(texto);
        }


        FloatingActionButton FAB_ConfirmarPedido = getView().findViewById(R.id.fbt_confirmarPedido);
        FAB_ConfirmarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "Pedido agregado", Toast.LENGTH_SHORT).show();





            }
        });




    }




}
