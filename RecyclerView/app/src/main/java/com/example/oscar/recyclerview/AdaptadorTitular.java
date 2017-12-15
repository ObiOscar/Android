package com.example.oscar.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorTitular extends RecyclerView.Adapter<AdaptadorTitular.TitularViewHolder>
implements View.OnClickListener{
    private ArrayList<Titular> datos;
    private View.OnClickListener listener;

    public AdaptadorTitular(ArrayList<Titular> datos) {
        this.datos = datos;
    }

    @Override
    public void onClick(View view) {
        if(listener != null) listener.onClick(view);
    }

    public void setOnClickListener (View.OnClickListener listen){
        this.listener = listen; }

    public static class TitularViewHolder extends RecyclerView.ViewHolder {

        private TextView txtTitu;
        private TextView txtSub;

        public TitularViewHolder(View itemView) {
            super(itemView);
            txtTitu =(TextView)itemView.findViewById(R.id.itemTitulo);
            txtSub = (TextView)itemView.findViewById(R.id.itemSubtitulo); }

        public void bindTitular(Titular t) {
            txtTitu.setText(t.getTitulo());
            txtSub.setText(t.getSubtitulo());}
    }

    @Override
    public TitularViewHolder onCreateViewHolder
            (ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.listem_layaout, parent, false);
        TitularViewHolder holder = new TitularViewHolder(itemView);
        return holder;
    }
    @Override
    public void onBindViewHolder(TitularViewHolder holder, int pos) {
        Titular item = datos.get(pos);
        holder.bindTitular(item);
    }
    @Override
    public int getItemCount() {
        return datos.size();
    }
    }
