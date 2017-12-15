package com.example.oscar.fernandezoscarj_2017_11_22;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by oski_ on 22/11/2017.
 */

public class AdaptadorContacto extends ArrayAdapter<ListContactos> {
    private ArrayList<ListContactos> contacto;

    static class ViewHolder {
        TextView nombre;
        TextView apellido;
        TextView telefono;
    }


    public AdaptadorContacto(Context c, ArrayList<ListContactos> items){
        super(c,R.layout.layaout_contactos,items);
        contacto = items;
    }

    public View getView(int pos, View vista, ViewGroup parent) {
        View item = vista;
        ViewHolder holder;
        if(item == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            item = inflater.inflate(R.layout.layaout_contactos, null);
            holder = new ViewHolder();
            holder.nombre = (TextView)item.findViewById(R.id.itemNombre);
            holder.apellido =(TextView)item.findViewById(R.id.itemApellido);
            holder.telefono =(TextView)item.findViewById(R.id.itemNumero);
            item.setTag(holder);
        } else {
            holder = (ViewHolder)item.getTag();
        }
        holder.nombre.setText(contacto.get(pos).getNombre());
        holder.apellido.setText(contacto.get(pos).getApellido());
        holder.telefono.setText(contacto.get(pos).getTelefono());
        return item;
    }

}
