package com.example.oscar.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recView;
    private ArrayList<Titular> datos;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datos = new ArrayList<Titular>();
        for (int i = 0; i < 50; i++) {
            datos.add(new Titular("Título " + i, "Sub item " + i));
        }
        recView = (RecyclerView) findViewById(R.id.recycler);
        recView.setHasFixedSize(true);
        final AdaptadorTitular adap = new AdaptadorTitular(datos);
        adap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.remove(recView.getChildAdapterPosition(v));
                adap.notifyDataSetChanged();
            }
        });
        recView.setAdapter(adap);



        recView.setAdapter(adap);
        recView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

       // recView.setLayoutManager(new GridLayoutManager(this,3));

        // Añadir separadores
        recView.addItemDecoration(new
                DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        // Añadir animacion
        recView.setItemAnimator(new DefaultItemAnimator());

        Button btnInsertar = (Button)findViewById(R.id.botAdd);
        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.add(0, new Titular("Nuevo titulo", "Subtitulo"));
                adap.notifyDataSetChanged();
            }
        });
    }



}

