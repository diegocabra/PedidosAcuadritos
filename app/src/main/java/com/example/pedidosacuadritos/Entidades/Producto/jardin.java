package com.example.pedidosacuadritos.Entidades.Producto;

import java.io.Serializable;

public class jardin extends Niños implements Serializable {

    public jardin(String tela, String bolsillo, String bies1, String bies2) {
        super(tela, bolsillo, bies1, bies2);
        precio = 580;
        cantTela = 0.4;

    }
}
