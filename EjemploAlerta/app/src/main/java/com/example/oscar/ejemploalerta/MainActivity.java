package com.example.oscar.ejemploalerta;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botEnviar = (Button)findViewById(R.id.botonEnviar);
        botEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editNombre = (EditText)findViewById(R.id.editNombre);
                String nombre = editNombre.getText().toString();
                if(nombre.equals("")){
                    //Alerta, esta vacio
                /*    AlertDialog.Builder alerta =
                            new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("No se ha introducido el nombre");
                    alerta.setPositiveButton(android.R.string.ok, null);
                    alerta.show();*/

                    // Alerta: Toast
                /*    int duracion = Toast.LENGTH_SHORT;
                    String mensa = "No se ha introducido el nombre";
                    Toast alerta = Toast.makeText(MainActivity.this,mensa,duracion);
                    alerta.show();*/

                    // Alerta: Snackbar
                    int duracion = Snackbar.LENGTH_LONG;
                    String mensa = "No se ha introducido el nombre";
                    Snackbar alerta = Snackbar.make(view, mensa, duracion);
                    alerta.show();

                }else{
                    TextView txtMensa = (TextView)findViewById(R.id.txtMensa);
                    txtMensa.setText("Bienvenido " + nombre);
                }
            }
        });
    }

}
