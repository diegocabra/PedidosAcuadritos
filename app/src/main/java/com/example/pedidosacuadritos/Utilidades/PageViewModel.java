package com.example.pedidosacuadritos.Utilidades;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pedidosacuadritos.Entidades.Persona.Cliente;
import com.example.pedidosacuadritos.Pedido.Pedido;

import java.util.List;

public class PageViewModel extends ViewModel {
    /**
     * Instancia de Data "viva"
     *
     */

    private MutableLiveData<Pedido> mPedido = new MutableLiveData<>();
    private MutableLiveData<List<Cliente>> clientes;
    private MutableLiveData<List<Detalle_Orden>> ordenes;

    public void setPedido (Pedido p){
        mPedido.setValue(p);

    }


    public LiveData<Pedido> getPedido(){
        if (mPedido == null)
            mPedido = new MutableLiveData<Pedido>();

        return mPedido;
    }

    public LiveData<List<Cliente>> getClientes() {
        if (clientes == null) {
            clientes = new MutableLiveData<List<Cliente>>();
            loadUsers();
        }
        return clientes;
    }

    private void loadUsers() {

        BaseDatoService Basedatos = BaseDatoService.getInstance();
        List<Cliente> Lclientes = Basedatos.listarClientes();        // Descargo de la nube los clientes ya cargados para luego mostrar en el listView
       clientes.setValue(Lclientes);
    }





}
