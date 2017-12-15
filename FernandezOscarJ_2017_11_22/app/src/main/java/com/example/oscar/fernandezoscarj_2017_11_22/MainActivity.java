package com.example.oscar.fernandezoscarj_2017_11_22;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    protected int contador;
    public ArrayList<Integer> imagenes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtMenu = (TextView)findViewById(R.id.itemNombre);
        registerForContextMenu(txtMenu);

        ArrayList<ListContactos> contactosIniciales = new ArrayList<ListContactos>();
        contactosIniciales.add(new ListContactos("Pedro","Picapiedra",677888999));
        contactosIniciales.add(new ListContactos("Vilma","Picapiedra",655444333));
        contactosIniciales.add(new ListContactos("Pablo","Mármol",678678678));

        AdaptadorContacto adaptadorCont = new AdaptadorContacto(this,contactosIniciales);
        ListView listaContactos = (ListView) findViewById(R.id.botonEnviar);
        listaContactos.setAdapter(adaptadorCont);

        final TextView etiquetaNombre = (TextView)findViewById(R.id.itemNombre);
        final TextView etiquetaApellido = (TextView)findViewById(R.id.itemApellido);
        final TextView etiquetaTelefono = (TextView)findViewById(R.id.itemNumero);
        final Button botonGuardar = (Button)findViewById(R.id.botonEnviar);
        final Button botonCancelar = (Button)findViewById(R.id.botonCancelar);

        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String textoNombre = etiquetaNombre.getText().toString();
                String textoApellido = etiquetaApellido.getText().toString();
                int numero = etiquetaTelefono.getText().toString();

                if (textoNombre.equals("") || textoApellido.equals("") || etiquetaTelefono.equals("")) {
                    // Alerta: Toast
                    int duracion = Toast.LENGTH_SHORT;
                    String mensa = "Faltan datos";
                    Toast alerta = Toast.makeText(MainActivity.this, mensa, duracion);
                    alerta.show();
                }

                ListContactos txtNombre = (ListContactos) findViewById(R.id.itemNombre);
                txtNombre.setText(textoNombre);

                ListContactos txtApellido = (ListContactos) findViewById(R.id.itemApellido);
                txtNombre.setText(textoApellido);

                ListContactos txtNumero = (ListContactos) findViewById(R.id.itemNumero);
                txtNombre.setText(numero);

            }else{
                    int duracion = Toast.LENGTH_SHORT;
                    String mensa = "Contacto Agregado";
                    Toast alerta = Toast.makeText(MainActivity.this,mensa,duracion);
                    alerta.show();
                }


                //guarda las cosas;
            }
        });

        botonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0)
            {

                ListContactos txtNombre = (ListContactos)findViewById(R.id.itemNombre);
                txtNombre.setText("");

                ListContactos txtApellido = (ListContactos)findViewById(R.id.itemApellido);
                txtNombre.setText("");

                ListContactos txtNumero = (ListContactos)findViewById(R.id.itemNumero);
                txtNombre.setText("");
            }
        });

        final RadioGroup grupoRadio = (RadioGroup)findViewById(R.id.sexo);
        grupoRadio.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        Context c = getApplicationContext();
                        String imgName = "icon_male";
                        String paquete = c.getPackageName();
                        int id = c.getResources().getIdentifier(imgName,"drawable",paquete);
                    }
                });

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
    }
    public boolean onContextItemSelected(MenuItem item) {
        TextView texto = (TextView)findViewById(R.id.itemNombre);
        switch (item.getItemId()) {
            case R.id.opcEditar:
                texto.setText(""); return true;
            case R.id.opcEliminar:
                texto.setText(""); return true;
            default:
                return super.onContextItemSelected(item);
        }
       /* contador = 0;
        imagenes = obtenerIDs(R.drawable.class, "icon_");
        Button btn = (Button) findViewById(R.id.botNext);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador++;
                int numImg = imagenes.size();
                int id = imagenes.get(contador % numImg);
                ImageView im = (ImageView) findViewById(R.id.imagen);
                im.setImageResource(id);
            }
        });*/
        }
    }




