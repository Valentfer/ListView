package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private List<Personas> listPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listV);

        listPersonas = new ArrayList<>();
        listPersonas.add(new Personas("Miguel", "López Sánchez","H", "ASIR"));
        listPersonas.add(new Personas("Juan", "Pérez Pérez","H", "DAW"));
        listPersonas.add(new Personas("Maria", "Martínez Fernández","M", "DAM"));
        listPersonas.add(new Personas("Antonio", "González García","H", "DAM"));
        listPersonas.add(new Personas("Ana", "Díaz Torres","M", "ASIR"));

        Miadapter miadapter = new Miadapter(this, R.layout.elementos, listPersonas);

        listView.setAdapter(miadapter);
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intentMod = new Intent(this, ActivityModulos.class);
        intentMod.putExtra("ciclo", listPersonas.get(i).getCiclo());
        startActivity(intentMod);
    }
}