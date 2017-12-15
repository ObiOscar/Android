package com.example.oscar.recycler;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclearView recView;
    private ArrayList<Titular> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicialización de la lista de datos de ejemplo
        datos = new ArrayList<Titular>();
        for(int i=0; i<50; i++) {
            datos.add(new Titular("Título " + i, "Subtítulo item " + i));
        }

        //Inicialización RecyclerView
        recView = (RecyclerView) findViewById(R.id.recView);
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


        // Utilizando LinearLayoutManager
        recView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        // Utilizando GridLayoutManager
        //recView.setLayoutManager(new GridLayoutManager(this,3));


        // Añadir separadores
        recView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        //recView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));

        // Añadir animacion
        recView.setItemAnimator(new DefaultItemAnimator());


        // Botones para comprobar la animacion

        // Inserta un nuevo elemento en la primera posicion de la lista
        Button btnInsertar = (Button)findViewById(R.id.botAdd);
        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.add(0, new Titular("Nuevo titular", "Subtitulo nuevo"));
                adap.notifyDataSetChanged();
            }
        });

    }
}