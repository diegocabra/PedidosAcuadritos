package com.example.pedidosacuadritos.Utilidades;


import com.example.pedidosacuadritos.Entidades.Producto.Producto;



public class Detalle_Pedido {

    /**
     *Esta clase va a representar cada renglon de mi listado del pedido .
     * Es decir , aqui voy a guardar el Producto , el talle de ese producto y la cantidad solicitada.
     */

   protected Producto producto;
   protected String talle;
   protected int cantidad;

    public Detalle_Pedido(Producto producto, String talle,int cantidad) {
        this.cantidad = cantidad;
        this.talle = talle;
        this.producto = producto;
    }


    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}







/*
Mi pregunta es la siguiente, estoy armando la aplicacion , aprendi firebase, aprendi lo basico de android,
aprendi a manejar un tablayout, fragments , etc

La idea de mi aplicacion es que tengas 3 fragments en la cual podes cargar distintos datos en cada fragments para en el fragment final , tener una vista previa de lo solicitado para poder "confirmar el pedido " y
luego subirlo a la nube.
para luego mostrar estadisticas .


Mi consulta es la siguiente....  que nivel de "desarrollo" le doy?
porque ahora estoy complicaco con pasar "Clases" entre fragments,
Es decir , en el primer fragment puedo crear un nuevo cliente o seleccopnar uno de un listado , en el segundo puedo seleccionar un modelo de indumentaria ,
en el tercer fragment muestra  ( "o deberia  mostrar" ) , el nombre del cliente seleccionado y el producto ,para luego confirmar el talle y la cantidad de productos.
En caso de que haya un error o "arrepentimiento" puedo simplemente deslizar el fragment hacia atras para corregir ese error y luego ir al final y cerrar el pedido .

Entonces en el tercer fragment necesito , nombre del cliente de la clase cliente, que corresponde ?
que arme una clase pedido  por cada vez que "abro la app" y le voy cargando los datos del cliente ?
o guardo los datos de los pedidos de manera temporal y le cargo los datos a la clase pedido una vez confirmado , todos los datos ? ???
HELP "




 */
