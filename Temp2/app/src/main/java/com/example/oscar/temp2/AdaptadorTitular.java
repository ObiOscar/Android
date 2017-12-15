package com.example.oscar.temp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by oski_ on 03/11/2017.
 */

public class AdaptadorTitular extends ArrayAdapter<Titular> {
    private  ArrayList<Titular> datos;

    static class ViewHolder {
        TextView titulo;
        TextView subtitulo;
    }


    public AdaptadorTitular(Context c, ArrayList<Titular> items){
        super(c,R.layout.listem_layaut,items);
        datos = items;
    }
   /* public View getView(int pos, View vista, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item=inflater.inflate(R.layout.listem_layaut,null);



        TextView titu=(TextView)item.findViewById(R.id.itemTitulo);
        titu.setText(datos.get(pos).getTitulo());

        TextView sub=(TextView)item.findViewById(R.id.itemSubtitulo);
        sub.setText(datos.get(pos).getSubtitulo());
        return item;
    }*/
    public View getView(int pos, View vista, ViewGroup parent) {
        View item = vista;
        ViewHolder holder;
        if(item == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            item = inflater.inflate(R.layout.listem_layaut, null);
            holder = new ViewHolder();
            holder.titulo = (TextView)item.findViewById(R.id.itemTitulo);
            holder.subtitulo =(TextView)item.findViewById(R.id.itemSubtitulo);
            item.setTag(holder);
        } else {
            holder = (ViewHolder)item.getTag();
        }
        holder.titulo.setText(datos.get(pos).getTitulo());
        holder.subtitulo.setText(datos.get(pos).getSubtitulo());
        return item;
    }

}

