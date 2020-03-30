package com.example.pedidosacuadritos.Entidades;

import java.io.Serializable;

public abstract class Persona implements Serializable {

    protected Integer id;
    protected String nombre;
    protected String telefono;
    protected String localidad;
    protected String direccion;


    public Persona(Integer id, String nombre, String telefono, String localidad) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.localidad = localidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}

