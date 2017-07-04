package com.example.erickgarcia.learningandroid_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private  List<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        // datos para a mostrar en el listView, es scrolleable
        names  = new ArrayList<>();
        names.add("erick");
        names.add("monse");
        names.add("abril");

        // Adaptador, la forma visual en que mostrare mis datos, este es el basico
        // ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
        // listView.setAdapter(adapter);

        // listener para el click de los elementos del listView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Clickeado: "+names.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        // enlazamos con nuestro adaptador personalizado
        MyAdapter myAdapter = new MyAdapter(MainActivity.this, R.layout.list_item, this.names);
        listView.setAdapter(myAdapter);
    }
}
