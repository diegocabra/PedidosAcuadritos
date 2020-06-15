package com.example.pedidosacuadritos.Pedido;

import java.util.Date;

import com.example.pedidosacuadritos.Entidades.Persona.Vendedor;
import com.example.pedidosacuadritos.Entidades.Producto.Producto;
import com.example.pedidosacuadritos.ModoPago.ModoPago;
import com.example.pedidosacuadritos.Entidades.Persona.Cliente;

public class Pedido {

    protected Producto producto;
    protected ModoPago modoPago;
    protected Cliente cliente;
    protected Vendedor vendedor;
    protected int ganancia;
    protected Date fecha;

    public Pedido(Producto producto, Cliente cliente, Vendedor vendedor) {
        this.producto = producto;
        this.cliente = cliente;
        this.vendedor = vendedor;
        fecha = new Date();// fecha que se genera el pedido;
    }

    public Pedido(Producto producto, ModoPago modoPago, Cliente cliente, Vendedor vendedor) {
        this.producto = producto;
        this.modoPago = modoPago;
        this.cliente = cliente;
        this.vendedor = vendedor;
        fecha = new Date();// fecha que se genera el pedido;
    }

    public ModoPago getModoPago() {

        return modoPago;
    }

    public void setModoPago(Producto producto) {

        this.modoPago = modoPago;
    }

    public Producto getProducto() {

        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;

    }


}
