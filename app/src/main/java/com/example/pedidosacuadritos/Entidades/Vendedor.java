package com.example.pedidosacuadritos.Entidades;


public class Vendedor extends Persona {

    private int ganancia;

    public Vendedor(Integer id, String nombre, String telefono, String localidad , int ganancia) {
        super(id, nombre, telefono, localidad);
        this.ganancia = ganancia;
    }

    public void setGanancia(int ganancia){
        this.ganancia = ganancia;
    }

    public int getGanancia(){
        return ganancia;
    }
}
