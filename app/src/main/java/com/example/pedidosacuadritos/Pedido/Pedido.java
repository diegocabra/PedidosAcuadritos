package com.example.pedidosacuadritos.Pedido;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.UUID;

import com.example.pedidosacuadritos.Entidades.Persona.Vendedor;
import com.example.pedidosacuadritos.Entidades.Producto.Producto;
import com.example.pedidosacuadritos.ModoPago.Efectivo;
import com.example.pedidosacuadritos.ModoPago.ModoPago;
import com.example.pedidosacuadritos.Entidades.Persona.Cliente;
import com.example.pedidosacuadritos.Utilidades.Detalle_Orden;

public class Pedido {

    protected String id;
    protected List<Detalle_Orden> ordenes;
    protected ModoPago modoPago;
    protected Cliente cliente;
    protected Vendedor vendedor;
    protected Date fecha;
    private static Pedido instance;

    private Pedido() {
        id= UUID.randomUUID().toString();
        ordenes = new LinkedList<Detalle_Orden>();
        //this.vendedor = vendedor;  En un futuro podemos tomar nota de quien registro dicho pedido
        fecha = new Date();// fecha que se genera el pedido;
        modoPago= new Efectivo(ordenes); // Por defecto se genera el pago con pago efectivo .
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

    public List<Detalle_Orden> getOrdenes() {

        return ordenes;
    }

    public void setCliente(Cliente c){
        cliente = c;
    }

    public void addOrden(Detalle_Orden orden) {
        ordenes.add(orden);
    }

    public Cliente getCliente(){
        return cliente;
    }

    public Double getPreciototal(){
       return modoPago.getPrecioFinal();
    }

}
