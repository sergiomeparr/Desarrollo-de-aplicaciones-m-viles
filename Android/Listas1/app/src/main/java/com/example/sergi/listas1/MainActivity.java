package com.example.sergi.listas1;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {
    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        ListAdapter la = crearAdapter();
        setListAdapter(la);
    }
    protected ListAdapter crearAdapter(){
        String[] s = new String[] {
                "Elemento1",
                "Elemento2",
                "Elemento3"
        };
        ListAdapter la2 = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, s);
        return la2;
    }
}
