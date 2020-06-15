package com.example.pedidosacuadritos.Entidades.Persona;


import com.example.pedidosacuadritos.Entidades.Persona.Persona;

public class Vendedor extends Persona {

    private int ganancia;

    public Vendedor(String id, String nombre, String telefono, String localidad , int ganancia , String email) {
        super(id, nombre, telefono, localidad, email);
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
