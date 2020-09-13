package com.example.pedidosacuadritos.ModoPago;


import com.example.pedidosacuadritos.Entidades.Producto.Producto;

import java.util.List;

public class Efectivo extends ModoPago {

    public Efectivo(List<Producto> productos) {

        super(productos);
    }

    @Override
    public double getPrecioFinal() {
        double precioTotal=0;
        if (listproductos.size()>0)
            for (Producto p :listproductos)  {
                precioTotal+=p.getPrecio();
            }

        return precioTotal;
   }
}
