package com.example.oscar.ejemplomenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
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
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
    }
    public boolean onContextItemSelected(MenuItem item) {
        TextView texto = (TextView)findViewById(R.id.txtMensaje);
        switch (item.getItemId()) {
            case R.id.opcBorrar:
                texto.setText(""); return true;
            case R.id.opcEscribir:
                texto.setText("Mensaje"); return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
