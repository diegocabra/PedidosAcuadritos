package com.example.pedidosacuadritos.Entidades.Producto;

public class jardin extends Niños {
    protected double cintaRaso;
    public jardin(String id, String tela, String bolsillo, String bies1, String bies2) {
        super(id,tela, bolsillo, bies1, bies2);
        precio = 580;
        cantTela = 0.4;
        cintaRaso = 0.10;
    }
}
