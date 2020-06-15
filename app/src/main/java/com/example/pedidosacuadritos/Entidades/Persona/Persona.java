package com.example.pedidosacuadritos.Entidades.Persona;

import java.io.Serializable;

public abstract class Persona implements Serializable {

    protected String id;
    protected String nombre;
    protected String telefono;
    protected String localidad;
    protected String direccion;
    protected String email;

    public Persona(){

    }
    public Persona(String id, String nombre, String telefono, String localidad,String email) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.localidad = localidad;
        this.email = email;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public String toString(){
        return nombre;
    }
}

