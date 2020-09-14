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
    protected Date fecha;
    private static Pedido instance;

    private Pedido() {
        id= UUID.randomUUID().toString();
        productos = new LinkedList<Producto>();
        //this.vendedor = vendedor;  En un futuro podemos tomar nota de quien registro dicho pedido
        fecha = new Date();// fecha que se genera el pedido;
    }

    public static Pedido getInstance() {

        if (instance == null)
            instance = new Pedido();

        return instance;
    }


    public String getId(){

        return id;
    }

    public ModoPago getModoPago() {

        return modoPago;
    }

    public void setModoPago(ModoPago modoPago) {

        this.modoPago = modoPago;
    }

    public List<Producto> getProductos() {

        return productos;
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

    public Double getPreciototal(){
       return modoPago.getPrecioFinal();
    }

}
