package com.example.pedidosacuadritos.Entidades.Producto;
import java.util.ArrayList;
public abstract class Producto {
    protected double precio;
    protected double cantTela;
    protected String tela;
    protected String bolsillo;
    protected String bies1;
    protected String bies2;
    protected String id;

    public int getCantCierres() {
        return cantCierres;
    }

    public void setCantCierres(int cantCierres) {
        this.cantCierres = cantCierres;

    }

    protected int cantCierres;
    //protected int costoConfeccion

    public String getTela() {
        return tela;
    }

    public void setTela(String tela) {
        this.tela = tela;
    }

    public String getBolsillo() {
        return bolsillo;
    }

    public void setBolsillo(String bolsillo) {
        this.bolsillo = bolsillo;
    }

    public String getBies1() {
        return bies1;
    }

    public void setBies1(String bies1) {
        this.bies1 = bies1;
    }

    public String getBies2() {
        return bies2;
    }

    public void setBies2(String bies2) {
        this.bies2 = bies2;
    }

    public Producto(String id,String tela, String bolsillo, String bies1, String bies2) {
        this.id = id;
        this.tela = tela;
        this.bolsillo = bolsillo;
        this.bies1 = bies1;
        this.bies2 = bies2;
    }

    public double getPrecio() {

        return precio;
    }

    public double getCantTela() {

        return cantTela;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setCantTela(int cantTela) {
        this.cantTela = cantTela;
    }




}
