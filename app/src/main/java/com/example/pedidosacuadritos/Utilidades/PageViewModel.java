package com.example.pedidosacuadritos.Utilidades;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pedidosacuadritos.Entidades.Persona.Cliente;

public class PageViewModel extends ViewModel {
    /**
     * Instancia de Data "viva"
     */

    private MutableLiveData<Cliente> mPedido = new MutableLiveData<>();

    public void setCliente (Cliente c){
        mPedido.setValue(c);

    }


    public LiveData<Cliente> getPedido(){
        return mPedido;
    }



}
