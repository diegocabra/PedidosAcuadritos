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

import com.example.pedidosacuadritos.ModoPago.Credito;
import com.example.pedidosacuadritos.ModoPago.Debito;
import com.example.pedidosacuadritos.ModoPago.Efectivo;
import com.example.pedidosacuadritos.Pedido.Pedido;
import com.example.pedidosacuadritos.Utilidades.BaseDatoService;
import com.example.pedidosacuadritos.Utilidades.Detalle_Orden;
import com.example.pedidosacuadritos.Utilidades.PageViewModel;
import com.example.pedidosacuadritos.Utilidades.ProductosViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class CerrarPedido_fragment extends Fragment {

    private TextView tv_nombreCliente,tv_precio;
    private RadioGroup modoPago;
    private PageViewModel pageViewModel;
    private ListView lv_OrdenesActuales;

    private ProductosViewModel productosViewModel;   // ViewModel  alternativo
    private ArrayAdapter<Detalle_Orden> arrayAdapterOrdenes;
    private List<Detalle_Orden> ordenesActuales = new ArrayList<Detalle_Orden>();

    public CerrarPedido_fragment() {
        // Required empty public constructor
    }

        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

            return inflater.inflate(R.layout.cerrar_pedido_fragment, container, false);
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


        tv_precio  = getView().findViewById(R.id.tv_precio);
        CargarlistaPedidos();


        cargarPrecio();


        FloatingActionButton FAB_ConfirmarPedido = getView().findViewById(R.id.fbt_confirmarPedido);
        FAB_ConfirmarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

    private void cargarPrecio() {
        modoPago = getView().findViewById(R.id.rGroupModopago);
        int id = modoPago.getCheckedRadioButtonId();
        final RadioButton efectivo = getView().findViewById(R.id.rbt_Efectivo);
        final RadioButton credito = getView().findViewById(R.id.rbt_Credito);
        final RadioButton debito = getView().findViewById(R.id.rbt_Debito);
        Pedido p = Pedido.getInstance();

        tv_precio.setText(Double.toString(p.getPreciototal()));
       modoPago.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                Double precioTotal = 0.0;

                  Pedido p = Pedido.getInstance();


                if ( efectivo.isChecked())
                     p.setModoPago(new Efectivo(p.getOrdenes()));
                 if (debito.isChecked())
                     p.setModoPago(new Debito(p.getOrdenes()));
                 if (credito.isChecked())
                     p.setModoPago(new Credito(p.getOrdenes()));

                tv_precio.setText(Double.toString(p.getPreciototal()));
                }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        CargarlistaPedidos();
        cargarPrecio();


    }

    private void CargarlistaPedidos() {
        lv_OrdenesActuales = getView().findViewById(R.id.lv_productos);


        ordenesActuales = Pedido.getInstance().getOrdenes();
        arrayAdapterOrdenes = new ArrayAdapter<Detalle_Orden>(getActivity(), android.R.layout.simple_list_item_1, ordenesActuales);  // Armo un Array de productos para armar el ListView
        lv_OrdenesActuales.setAdapter(arrayAdapterOrdenes);
    }


}
