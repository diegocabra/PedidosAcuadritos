package com.example.pedidosacuadritos.ModoPago;

import com.example.pedidosacuadritos.Entidades.Producto.Producto;
import com.example.pedidosacuadritos.Utilidades.Detalle_Orden;

import java.util.List;

public class Debito extends ModoPago {


    public Debito(List<Detalle_Orden> ordenes) {
        super(ordenes);

    }

    @Override
    public double getPrecioFinal() {
        double precioTotal=getPrecio();

            double imp = 1+ impuestoDebito;
        return precioTotal* imp ;

    }


}

