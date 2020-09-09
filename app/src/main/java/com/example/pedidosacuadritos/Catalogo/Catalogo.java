package com.example.pedidosacuadritos.Catalogo;

import com.example.pedidosacuadritos.Entidades.Producto.Producto;
import com.example.pedidosacuadritos.Pedido.Pedido;
import com.example.pedidosacuadritos.Utilidades.BaseDatoService;

import java.util.LinkedList;
import java.util.List;

public class Catalogo {
    /*
    La idea de esta clase es la de poder agregar o eliminar productos al Catalogo de productos
    */

    protected List<Producto> ListaProductos;
    protected List<Pedido>   ListaPedidos;
    //private static Catalogo instance;



    public Catalogo() {
        ListaProductos = new LinkedList<>();
        ListaPedidos = new LinkedList<>();


    }

    // En un primer momento me parecio util que sea un singleton , pero fue al pedo porque los productos los bajo y subo desde la nube.
    // Utilizamos el patron Singleton para que exista un unico inventario y llevar un control de productos

    /*public static Catalogo getInstance() {

        if (instance == null)
            instance = new Catalogo();

        return instance;

   }*/

   /**En cuestiones de buena programacion y/o Orientado a objetos, que es lo correcto ?
    Hago una clase de inventario , en donde almaceno todos los productos generados o
    subo cada producto generado y lo descargo cada vez que necesito el inventario?

    De ultima , puedo subir cada producto generado y descargarlos todos a mi clase inventario y trabajar con esta clase.
    de esta manera tenemos una sola conexion con el servidor.


    **/

    public void AgregarProducto(Producto p){
        BaseDatoService Basedatos = BaseDatoService.getInstance();
        Basedatos.write(p);

    }

    public void AgregarPedido(Pedido p){
        BaseDatoService Basedatos = BaseDatoService.getInstance();
        Basedatos.write(p);

    }


    public List<Producto> getCatalogoProductos() {
        BaseDatoService Basedatos = BaseDatoService.getInstance();
        ListaProductos = Basedatos.listarProductos();
         return ListaProductos;
    }

    public List<Pedido> getCatalogoPedidos() {
        BaseDatoService Basedatos = BaseDatoService.getInstance();
        ListaPedidos = Basedatos.listarPedidos();
        return ListaPedidos;
    }



}
