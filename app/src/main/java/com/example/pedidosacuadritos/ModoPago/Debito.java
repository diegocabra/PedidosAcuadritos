package com.example.pedidosacuadritos.ModoPago;

import com.example.pedidosacuadritos.Productos.Producto;

public class Debito extends ModoPago {


    public Debito(Producto producto, int descuentoDebito) {
        super(producto);

    }

    @Override
    public double obtenerGanancia() {
        return producto.getPrecio()*descuentoDebito;
    }

}

