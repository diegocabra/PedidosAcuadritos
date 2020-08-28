package com.example.pedidosacuadritos.ModoPago;

import com.example.pedidosacuadritos.Entidades.Producto.Producto;

public abstract class ModoPago {
    protected Producto producto;
    protected double descuentoCredito;
    protected double descuentoDebito;

    public ModoPago(Producto producto){
        this.producto = producto;
    }
    public abstract double obtenerGanancia();


    public double getDescuentoCredito() {

        return descuentoCredito;
    }

    public void setDescuentoCredito(double descuentoCredito) {

        this.descuentoCredito = descuentoCredito;
    }


    public double getDescuentoDebito() {
        return descuentoDebito;
    }

    public void setDescuentoDebito(double descuentoDebito) {
        this.descuentoDebito = descuentoDebito;
    }
}
