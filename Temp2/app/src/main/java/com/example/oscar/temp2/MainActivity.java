package com.example.oscar.temp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Titular> titulares = new ArrayList<Titular>();
        titulares.add(new Titular("Titulo1","Subtitulo1"));
        titulares.add(new Titular("Titulo2","Subtitulo2"));
        titulares.add(new Titular("Titulo3","Subtitulo3"));
        titulares.add(new Titular("Titulo4","Subtitulo4"));
        titulares.add(new Titular("Titulo5","Subtitulo5"));

        AdaptadorTitular at = new AdaptadorTitular(this,titulares);
        ListView lista = (ListView) findViewById(R.id.list_item);
        lista.setAdapter(at);
    }
}
