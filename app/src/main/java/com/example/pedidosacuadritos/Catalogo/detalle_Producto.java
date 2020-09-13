package com.example.pedidosacuadritos.Catalogo;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pedidosacuadritos.Entidades.Producto.Producto;
import com.example.pedidosacuadritos.Pedido.Pedido;
import com.example.pedidosacuadritos.R;
import com.example.pedidosacuadritos.Utilidades.PageViewModel;
import com.example.pedidosacuadritos.Utilidades.ProductosViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class detalle_Producto extends AppCompatActivity {
    TextView tvTitulo, tv_descripcion,tv_prueba;
    EditText etCantidad;
    FloatingActionButton agregarPedido;
    private ProductosViewModel productosViewmodel;
    private PageViewModel pageViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_producto);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        tvTitulo = findViewById(R.id.tv_Ttuloppal);
        tv_descripcion =findViewById(R.id.tv_descripcion);
        etCantidad = findViewById(R.id.eT_Cantidad);

        //Mediante un "tag" Consigo el producto seleccionado en el adapter para luego conseguir el titulo y descripcion ( o lo que necesite)
        Intent i = getIntent();
        final Producto prodSeleccionado = (Producto) i.getSerializableExtra("Producto");
        String Titulo = prodSeleccionado.getTela();
        String descripcion = prodSeleccionado.getBolsillo();

        tvTitulo.setText(Titulo);
        tv_descripcion.setText(descripcion);




        productosViewmodel = ViewModelProviders.of(this).get(ProductosViewModel.class);
        productosViewmodel.addProducto(prodSeleccionado);

        /** Floating Button         */
        agregarPedido = findViewById(R.id.FAB_agregarProducto);

        agregarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Pedido pedidoTemporal = Pedido.getInstance();
                pedidoTemporal.addProducto(prodSeleccionado);
                Toast.makeText(getApplication(),"Producto agregado",Toast.LENGTH_LONG).show();
                //Toast.makeText(getActivity(), p.getCliente().getNombre(), Toast.LENGTH_SHORT).show();

            }
        });



      }





}
