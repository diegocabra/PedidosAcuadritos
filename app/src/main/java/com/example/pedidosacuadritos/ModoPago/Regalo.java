package com.example.pedidosacuadritos.ModoPago;

import com.example.pedidosacuadritos.Productos.Producto;

public class Regalo extends ModoPago {
    public Regalo(Producto producto) {
        super(producto);
    }

    @Override
    public double obtenerGanancia() {
        return 0;
    }
}
