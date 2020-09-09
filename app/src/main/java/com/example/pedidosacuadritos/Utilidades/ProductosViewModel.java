package com.example.pedidosacuadritos.Utilidades;

import androidx.lifecycle.ViewModel;

import com.example.pedidosacuadritos.Entidades.Producto.Producto;
import com.example.pedidosacuadritos.Pedido.Pedido;

import java.util.ArrayList;
import java.util.List;

public class ProductosViewModel extends ViewModel {

    private List<Producto> ListProductos;

    public ProductosViewModel(){

        ListProductos = new ArrayList<>();
    }

    public void addProducto(Producto producto){
        ListProductos.add(producto);
    }

    private ProductosViewModel(List<Producto> productoList)
    {
        ListProductos = productoList;
    }

    public List<Producto> getListProductos() {

        return ListProductos;
    }

    public void setUserList(List<Producto> productoList) {
        ListProductos = productoList;
    }
}
