package com.example.pedidosacuadritos.ModoPago;

import com.example.pedidosacuadritos.Productos.Producto;

public class Credito extends ModoPago {


    public Credito(Producto producto) {

        super(producto);
    }

    @Override
    public double obtenerGanancia() {

        return producto.getPrecio() * descuentoCredito;
    }

}
