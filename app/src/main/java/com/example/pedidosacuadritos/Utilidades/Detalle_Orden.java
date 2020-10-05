package com.example.pedidosacuadritos.Utilidades;


import com.example.pedidosacuadritos.Entidades.Producto.Producto;

import java.util.UUID;


public class Detalle_Orden {

    /**
     *Esta clase va a representar cada renglon de mi listado del pedido .
     * Es decir , aqui voy a guardar el Producto , el talle de ese producto y la cantidad solicitada.
     */
    protected String id;
   protected Producto producto;
   protected String talle;
   protected int cantidad;

    public Detalle_Orden(Producto producto, String talle, int cantidad) {
        id= UUID.randomUUID().toString();
        this.cantidad = cantidad;
        this.talle = talle;
        this.producto = producto;
    }



    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String toString(){
        return producto.getTela() + " Talle : " +talle +"\n"+" Cantidad: "+ cantidad;
    }
}






