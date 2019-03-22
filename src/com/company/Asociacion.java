package com.company;

import java.util.Map;

public class Asociacion<K,V> implements Map.Entry<K,V>{

    protected K key;
    protected V valor;

    // Constructor
    public Asociacion(K key, V valor) {
        this.key = key;
        this.valor = valor;
    }

    //
    public Asociacion(K key)
    {
        this(key, null);
    }

    @Override
    public V getValue()
    {
        return valor;
    }

    @Override
    public K getKey()
    {
        return key;
    }


    @Override
    public V setValue(V nuevoValor) {
        V oldV = valor;
        valor = nuevoValor;
        return oldV;
    }

    @Override
    public boolean equals (Object objeto) {
        Asociacion objetoNuevo = (Asociacion) objeto;
        return getKey().equals(objetoNuevo.getKey());
    }

}


