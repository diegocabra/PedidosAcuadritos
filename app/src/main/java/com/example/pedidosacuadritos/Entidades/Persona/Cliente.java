package com.example.pedidosacuadritos.Entidades.Persona;

public class Cliente extends Persona {
    private String talle;
    private String ocupacion;

    public Cliente(){

    }


    public Cliente(String id, String nombre, String telefono, String localidad,String email) {
        super(id, nombre, telefono, localidad,email);
    }
    public Cliente(String id, String nombre, String telefono, String localidad, String talle, String ocupacion,String email) {
        super(id, nombre, telefono, localidad,email);
        this.talle = talle;
        this.ocupacion = ocupacion;
    }

}
