package com.example.pedidosacuadritos.Catalogo;

import com.example.pedidosacuadritos.Entidades.Producto.Producto;
import com.example.pedidosacuadritos.Utilidades.BaseDatoService;

import java.util.LinkedList;
import java.util.List;

public class Catalogo {
    /*
    La idea de esta clase es la de poder agregar o eliminar productos al Catalogo de productos
    */

    protected List<Producto> ListaProductos;

    //private static Catalogo instance;



    public Catalogo() {
        ListaProductos = new LinkedList<>();
         }

     public void AgregarProducto(Producto p){
        BaseDatoService Basedatos = BaseDatoService.getInstance();
        Basedatos.write(p);
    }


    public List<Producto> getCatalogoProductos() {
        BaseDatoService Basedatos = BaseDatoService.getInstance();
        ListaProductos = Basedatos.listarProductos();
         return ListaProductos;
    }




}
