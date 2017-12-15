package com.example.oscar.fernandezoscarj_2017_11_22;

/**
 * Created by oski_ on 22/11/2017.
 */

public class ListContactos {
    private String nombre;
    private String apellido;
    private int telefono;

    public ListContactos(String nomb, String apell, int tele){
        nombre = nomb;
        apellido = apell;
        telefono = tele;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public int getTelefono(){
        return telefono;
    }
}