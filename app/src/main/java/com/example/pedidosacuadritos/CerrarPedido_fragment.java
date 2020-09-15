package com.example.pedidosacuadritos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.Observer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pedidosacuadritos.Entidades.Producto.Adulto;
import com.example.pedidosacuadritos.Entidades.Producto.Producto;
import com.example.pedidosacuadritos.ModoPago.Credito;
import com.example.pedidosacuadritos.ModoPago.Debito;
import com.example.pedidosacuadritos.ModoPago.Efectivo;
import com.example.pedidosacuadritos.ModoPago.ModoPago;
import com.example.pedidosacuadritos.Pedido.Pedido;
import com.example.pedidosacuadritos.Utilidades.BaseDatoService;
import com.example.pedidosacuadritos.Utilidades.PageViewModel;
import com.example.pedidosacuadritos.Entidades.Persona.Cliente;
import com.example.pedidosacuadritos.Utilidades.ProductosViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class CerrarPedido_fragment extends Fragment {

    private TextView tv_nombreCliente,tv_precio,tvdeprueba;
    private RadioGroup modoPago;
    private PageViewModel pageViewModel;
    private ListView lv_prodSeleccionados;
    private FloatingActionButton FAB_ConfirmarPedido;
    private Pedido nuevo_pedido;
    private Cliente cli_actual;
    private String pedidoSeleccionado;
    private ProductosViewModel productosViewModel;
    private ArrayAdapter<Producto> arrayAdapterProductos;
    private List<Producto> lista_prodSeleccionados = new ArrayList<Producto>();

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
        pageViewModel = ViewModelProviders.of(requireActivity()).get(PageViewModel.class);
        pageViewModel.getPedido().observe(getViewLifecycleOwner(), new Observer<Pedido>() { //Observer de clientes seleccionados en el fragments uno.
            @Override
            public void onChanged(Pedido pedido) {
                tv_nombreCliente.setText("CLIENTE : "+ pedido.getCliente().getNombre());
            }
        });


        productosViewModel = ViewModelProviders.of(requireActivity()).get(ProductosViewModel.class);

        tv_precio  = getView().findViewById(R.id.tv_precio);

        lv_prodSeleccionados = getView().findViewById(R.id.lv_productos);
        lista_prodSeleccionados = Pedido.getInstance().getProductos();
        arrayAdapterProductos = new ArrayAdapter<Producto>(getActivity(), android.R.layout.simple_list_item_1, lista_prodSeleccionados);  // Armo un Array de productos para armar el ListView
        lv_prodSeleccionados.setAdapter(arrayAdapterProductos);


        modoPago = getView().findViewById(R.id.rGroupModopago);
        int id = modoPago.getCheckedRadioButtonId();
        final RadioButton efectivo = getView().findViewById(R.id.rbt_Efectivo);
        final RadioButton credito = getView().findViewById(R.id.rbt_Credito);
        final RadioButton debito = getView().findViewById(R.id.rbt_Debito);
        modoPago.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                    Pedido p = Pedido.getInstance();

                Double precioTotal = 0.0;
                ModoPago mp = null;
                if ( efectivo.isChecked())
                     p.setModoPago(new Efectivo(p.getProductos()));
                 if (debito.isChecked())
                     p.setModoPago(new Debito(p.getProductos()));
                 if (credito.isChecked())
                     p.setModoPago(new Credito(p.getProductos()));

                tv_precio.setText(Double.toString(p.getPreciototal()));
            }
        });



        FloatingActionButton FAB_ConfirmarPedido = getView().findViewById(R.id.fbt_confirmarPedido);
        FAB_ConfirmarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseDatoService datoService = BaseDatoService.getInstance();
                pageViewModel.getPedido().observe(getViewLifecycleOwner(), new Observer<Pedido>() {
                    @Override
                    public void onChanged(Pedido pedido) {
                        BaseDatoService Basedatos = BaseDatoService.getInstance();
                        Basedatos.write(pedido);
                        Toast.makeText(getActivity(), "Pedido Confirmado" , Toast.LENGTH_LONG).show();

                        }
                });

            }
        });



    }




}
