package com.example.pedidosacuadritos.Utilidades;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.pedidosacuadritos.Cliente_fragment;
import com.example.pedidosacuadritos.Producto_fragment;
import com.example.pedidosacuadritos.CerrarPedido_fragment;

public class PagerAdapter extends FragmentPagerAdapter {
private int tabsNumber;

    public PagerAdapter(@NonNull FragmentManager fm,int behavior,int tabs) {
        super(fm, behavior);
        this.tabsNumber =tabs;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Cliente_fragment();
            case 1:
                return new Producto_fragment();
            case 2:
                return new CerrarPedido_fragment();
            default:
                return null;
        }
    }


    @Override
    public int getCount() {
        return tabsNumber;
    }
}
