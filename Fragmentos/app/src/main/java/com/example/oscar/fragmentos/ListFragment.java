package com.example.oscar.fragmentos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListFragment extends android.app.ListFragment {
    private String[] valores = {"Cupcake", "Donut", "Eclair", "Froyo",
            "GingerBread", "HoneyComb","Ice Cream Sandwich", "Jelly Bean",
            "KitKat", "Lollipop", "Marshmallow", "Nougat", "Oreo"};
    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>
                (getActivity(), android.R.layout.simple_expandable_list_item_1, valores);
        setListAdapter(adaptador);
    }
    @Override
    public void onListItemClick (ListView l, View v, int pos, long id) {
        String item = (String)getListAdapter().getItem(pos);
        DetailFragment fragment = (DetailFragment)getFragmentManager().
                findFragmentById(R.id.detailFragment);
        if (fragment != null && fragment.isInLayout()) {
            fragment.setText(item);
        } else {
            Intent intent = new Intent(getActivity(), DetailActivity.class);
            intent.putExtra("value", item);
            startActivity(intent);
        }
    }
}
