package com.example.pedidosacuadritos.Pedido;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.UUID;

import com.example.pedidosacuadritos.Entidades.Persona.Vendedor;
import com.example.pedidosacuadritos.Entidades.Producto.Producto;
import com.example.pedidosacuadritos.ModoPago.ModoPago;
import com.example.pedidosacuadritos.Entidades.Persona.Cliente;

public class Pedido {

    protected String id;
    protected List<Producto> productos;
    protected ModoPago modoPago;
    protected Cliente cliente;
    protected Vendedor vendedor;
    protected int ganancia;
    protected Date fecha;


    public Pedido(Cliente cliente) {
        id= UUID.randomUUID().toString();
        this.cliente = cliente;
        productos = new LinkedList<Producto>();
        //this.vendedor = vendedor;  En un futuro podemos tomar nota de quien registro dicho pedido
        fecha = new Date();// fecha que se genera el pedido;
    }

    public Pedido(Producto producto, ModoPago modoPago, Cliente cliente) {
        id= UUID.randomUUID().toString();

        this.modoPago = modoPago;
        this.cliente = cliente;
        fecha = new Date();// fecha que se genera el pedido;
    }

    public Pedido (){

    }


    public String getId(){
        return id;
    }

    public ModoPago getModoPago() {

        return modoPago;
    }

    public void setModoPago(Producto producto) {

        this.modoPago = modoPago;
    }

    public ListIterator<Producto> getProductos() {

        return productos.listIterator();
    }

    public void setCliente(Cliente c){
        cliente = c;
    }

    public void addProducto(Producto producto) {
        productos.add(producto);
    }

    public Cliente getCliente(){
        return cliente;
    }


}
