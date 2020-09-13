package com.example.pedidosacuadritos.ModoPago;

import com.example.pedidosacuadritos.Entidades.Producto.Producto;

import java.util.List;

public class Debito extends ModoPago {


    public Debito(List<Producto> productos) {
        super(productos);

    }

    @Override
    public double getPrecioFinal() {
        double precioTotal=0;
        if (listproductos.size()>0)
            for (Producto p :listproductos)  {
                precioTotal+=p.getPrecio();
            }
            double imp = 1+ impuestoDebito;
        return precioTotal* imp ;

    }


}

