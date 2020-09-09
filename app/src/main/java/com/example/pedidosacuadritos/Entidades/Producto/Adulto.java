package com.example.pedidosacuadritos.Entidades.Producto;

import java.io.Serializable;

public class Adulto extends Producto implements Serializable {

    public Adulto(String tela, String bolsillo, String bies1, String bies2) {
        super(tela, bolsillo, bies1, bies2);
        precio = 950;
        cantTela = 0.95;
        cantCierres = 0;
    }

    public Adulto(){
        // ESTA MIERDA ES NECESARIA PARA FIREBASEE
    }
}
