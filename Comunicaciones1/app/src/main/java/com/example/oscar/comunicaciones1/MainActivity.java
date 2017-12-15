package com.example.oscar.comunicaciones1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botEnviar = (Button)findViewById(R.id.botEnviarDatos);
        botEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText textoNombreUusario = (EditText)findViewById(R.id.recogoUsuario);
                EditText textoContrasena = (EditText)findViewById(R.id.recogoContrasenna);
                String usu = textoNombreUusario.getText().toString().trim();
                String pass = textoContrasena.getText().toString().trim();

                if(!usu.equals("") && !pass.equals("")){
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra("nombre", usu);
                    intent.putExtra("contrasenia", pass);
                    startActivity(intent);
                }
                else{
                    Toast mensajeError = Toast.makeText(getApplicationContext(),"Faltan datos", Toast.LENGTH_SHORT);
                    mensajeError.show();
                }
            }
        });
    }
}
