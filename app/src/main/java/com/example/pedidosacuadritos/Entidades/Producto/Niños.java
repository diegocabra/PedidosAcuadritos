package com.example.pedidosacuadritos.Entidades.Producto;

public abstract class Niños extends Producto {


    public Niños(String id,String tela, String bolsillo, String bies1, String bies2) {
        super(id,tela, bolsillo, bies1, bies2);
        cantCierres = 0;

    }
}
