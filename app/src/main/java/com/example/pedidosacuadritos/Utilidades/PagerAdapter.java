package com.example.pedidosacuadritos.Utilidades;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.pedidosacuadritos.First_ClienteFragment;
import com.example.pedidosacuadritos.Second_ProductoFragment;
import com.example.pedidosacuadritos.Third;

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
                return new First_ClienteFragment();
            case 1:
                return new Second_ProductoFragment();
            case 2:
                return new Third();
            default:
                return null;
        }
    }


    @Override
    public int getCount() {
        return tabsNumber;
    }
}
