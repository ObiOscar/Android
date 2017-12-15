package com.example.oscar.ejemplomenu2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtMenu = (TextView)findViewById(R.id.txtMenu);
        registerForContextMenu(txtMenu);

            TextView txtLista = (TextView)findViewById(R.id.itemTitulo);
        registerForContextMenu(txtLista);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        if(v.getId() == R.id.txtMenu){
            inflater.inflate(R.menu.menu_lista, menu);
        }else{
            inflater.inflate(R.menu.menu, menu);

        }
        }

    public boolean onContextItemSelected(MenuItem item) {
        TextView texto = (TextView)findViewById(R.id.txtMensaje);
        TextView texto2 = (TextView)findViewById(R.id.itemSubTitulo);
        switch (item.getItemId()) {
            case R.id.opcBorrar:
                texto.setText(""); return true;
            case R.id.opcEscribir:
                texto.setText("Mensaje"); return true;
            case R.id.opcCopiar:
                texto2.setText("Copiar"); return true;
            case R.id.opcCortar:
                texto2.setText("Cortar"); return true;
            case R.id.opcPegar:
                texto2.setText("Pegar"); return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
