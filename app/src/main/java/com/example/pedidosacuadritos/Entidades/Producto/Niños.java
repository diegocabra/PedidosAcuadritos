package com.example.pedidosacuadritos.Entidades.Producto;

import java.io.Serializable;

public abstract class Niños extends Producto implements Serializable {


    public Niños(String tela, String bolsillo, String bies1, String bies2) {
        super(tela, bolsillo, bies1, bies2);
        precio =550;


    }
}
