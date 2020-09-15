package com.example.pedidosacuadritos.ModoPago;

import com.example.pedidosacuadritos.Utilidades.Detalle_Orden;

import java.util.List;

public abstract class ModoPago {
    protected List<Detalle_Orden> listOrdenes;
    protected double impuestoCredito = 0.15;
    protected double impuestoDebito = 0.08;


    public ModoPago(List<Detalle_Orden> ordenes){
        listOrdenes = ordenes;
    }

    /**
     *
     * @return el valor del producto mas los impuestos por comprar con el metodo de pago elegido . "Retorna precio final/cliente"
     */
    public abstract double getPrecioFinal();

    public double getImpuestoCredito() {

        return impuestoCredito;
    }
    // Expresado en porcentaje , ejemplo todas las ventas con credito tienen un impuesto de 7% . Ingresar un numero mayor a 0
    public void setImpuestoCredito(double impuestoCredito) {

        this.impuestoCredito = (impuestoCredito/100);
    }

    public double getImpuestoDebito() {
        return impuestoDebito;
    }

    public void setImpuestoDebito(double impuestoDebito) {
        this.impuestoDebito = impuestoDebito/100;
    }

    protected double getPrecio() {
        double precioTotal = 0;

        if (listOrdenes.size() > 0)
            for (Detalle_Orden orden : listOrdenes) {
                precioTotal += orden.getProducto().getPrecio() * orden.getCantidad();
            }
        return precioTotal;
    }

}
