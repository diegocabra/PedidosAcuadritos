package com.example.pedidosacuadritos.Entidades;


public class Vendedor extends Persona {

    private int ganancia;

    public Vendedor(String id, String nombre, String telefono, String localidad , int ganancia) {
        super(id, nombre, telefono, localidad);
        this.ganancia = ganancia;
    }
    public Vendedor(){

    }

    public void setGanancia(int ganancia){
        this.ganancia = ganancia;
    }

    public int getGanancia(){
        return ganancia;
    }
}
