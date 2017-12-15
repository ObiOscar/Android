package com.example.oscar.comunicaciones1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("nombre")) {
                String user = intent.getStringExtra("nombre");
                EditText nombreUusuarioMostrar = (EditText)findViewById(R.id.user2);
                nombreUusuarioMostrar.setText(user);
            }
            if (intent.hasExtra("contrasenia")) {
                String con = intent.getStringExtra("contrasenia");
                EditText contraseniaMostrar = (EditText)findViewById(R.id.con2);
                contraseniaMostrar.setText(con);
            }
        }

    }
}
