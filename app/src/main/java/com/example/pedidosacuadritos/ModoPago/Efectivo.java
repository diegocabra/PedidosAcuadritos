package com.example.pedidosacuadritos.ModoPago;


import com.example.pedidosacuadritos.Productos.Producto;

public class Efectivo extends ModoPago {

    public Efectivo(Producto producto) {
        super(producto);
    }

    @Override
    public double obtenerGanancia() {
        return producto.getPrecio();
    }
}
