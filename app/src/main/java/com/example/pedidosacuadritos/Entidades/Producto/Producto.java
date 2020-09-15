package com.example.pedidosacuadritos.Entidades.Producto;
import java.io.Serializable;
import java.util.UUID;

public class Producto implements Serializable {
    protected double precio;
    protected double cantTela;
    protected String tela;
    protected String bolsillo;
    protected String detalle1;
    protected String detalle2;
    protected String id;
    protected int costoConfeccion;// La intencion futura es sacar costos que se deben pagar por mano de obra por cada producto , para luego obtener el total por pedido , etc.  .



    public  Producto(){
    }

    public Producto(String tela, String bolsillo, String bies1, String bies2) {
        id= UUID.randomUUID().toString();
        this.tela = tela;
        this.bolsillo = bolsillo;
        this.detalle1 = bies1;
        this.detalle2 = bies2;
        this.precio = precio;
    }

   public double getPrecio() {

        return precio;
    }


    public String getId(){
        return id;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setCantTela(int cantTela) {
        this.cantTela = cantTela;
    }

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

    public String getDetalle1() {
        return detalle1;
    }

    public void setDetalle1(String detalle1) {
        this.detalle1 = detalle1;
    }

    public String getDetalle2() {
        return detalle2;
    }

    public void setDetalle2(String detalle2) {
        this.detalle2 = detalle2;
    }

    public String toString(){
        return tela+"\n" + " "+ bolsillo;
    }

}
