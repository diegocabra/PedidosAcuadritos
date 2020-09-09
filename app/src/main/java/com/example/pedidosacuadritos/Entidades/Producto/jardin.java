package com.example.pedidosacuadritos.Entidades.Producto;

import java.io.Serializable;

public class jardin extends Niños implements Serializable {
    protected double cintaRaso;
    public jardin(String tela, String bolsillo, String bies1, String bies2) {
        super(tela, bolsillo, bies1, bies2);
        precio = 580;
        cantTela = 0.4;
        cintaRaso = 0.10;
    }
}
