package com.example.pedidosacuadritos.Entidades;

public class Cliente extends Persona {
    private String talle;
    private String ocupacion;

    public Cliente(){

    }


    public Cliente(String id, String nombre, String telefono, String localidad) {
        super(id, nombre, telefono, localidad);
    }
    public Cliente(String id, String nombre, String telefono, String localidad, String talle, String ocupacion) {
        super(id, nombre, telefono, localidad);
        this.talle = talle;
        this.ocupacion = ocupacion;
    }

}
