package com.example.pedidosacuadritos.Utilidades;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.pedidosacuadritos.Entidades.Persona.Cliente;
import com.example.pedidosacuadritos.Pedido.Pedido;

public class PageViewModel extends ViewModel {
    /**
     * Instancia de Data "viva"
     */

    private MutableLiveData<Pedido> mPedido = new MutableLiveData<>();


    public void setPedido (Pedido p){
        mPedido.setValue(p);

    }


    public LiveData<Pedido> getPedido(){
        if (mPedido == null)
            mPedido = new MutableLiveData<Pedido>();

        return mPedido;
    }



}
