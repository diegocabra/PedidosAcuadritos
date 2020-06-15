package com.example.pedidosacuadritos.Entidades.Producto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Inventario {

    protected LinkedList<Producto> Lista;
    private static Inventario instance;



    private Inventario() {
        Lista = new LinkedList<>();

    }

    // Utilizamos el patron Singleton para que exista un unico inventario y llevar un control de productos

    public static Inventario getInstance() {

        if (instance == null)
            instance = new Inventario();

        return instance;

   }

   /**En cuestiones de buena programacion y/o Orientado a objetos, que es lo correcto ?
    Hago una clase de inventario , en donde almaceno todos los productos generados o
    subo cada producto generado y lo descargo cada vez que necesito el inventario?

    De ultima , puedo subir cada producto generado y descargarlos todos a mi clase inventario y trabajar con esta clase.
    de esta manera tenemos una sola conexion con el servidor.


    **/

    public void AgregarProducto(Producto p){
        Lista.add(p);

    }

    // TODO: 14/06/20  Descargar productos desde la nube y actualizar la lista de productos.


    public LinkedList<Producto> getLista() {
        return Lista;
    }

    public static ArrayList<Producto> createProductoList(int numProducto) {
        ArrayList<Producto> contacts = new ArrayList<Producto>();

        for (int i = 1; i <= numProducto; i++) {
            contacts.add(new Producto(Integer.toString(i),"cuadrille azul " ,"flores grandes","negro liso", "lunares blancos") {
            });
        }

        return contacts;
    }



}
