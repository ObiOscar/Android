package com.example.oscar.fragmentos;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends Activity{
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String s = extras.getString("value");
            TextView vista = (TextView)findViewById(R.id.txtTitulo);
            vista.setText(s);
        }
    }
}
