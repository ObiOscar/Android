package com.example.alumno.fragmentos;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Alumno on 30/11/2017.
 */

public class DetailFragment extends Fragment {
    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView (LayoutInflater inflater,
                              ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.details,container,false);
        return vista;
    }
    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
    public void setText (String item) {
        TextView vista=(TextView)getView().findViewById(R.id.txtTitulo);
        vista.setText(item);
    }
}
