package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class Miadapter extends ArrayAdapter {

    private Context ctx;
    private int layoutTem;
    private List<Personas> personasList;


    public Miadapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.layoutTem = resource;
        this.personasList = objects;
    }

    public View getView(int position, View converView, ViewGroup parent){
        View v = LayoutInflater.from(ctx).inflate(layoutTem, parent, false);

        Personas elementoActual = personasList.get(position);

        ImageView imageViewAl = v.findViewById(R.id.imgAl);
        TextView txtNombre = v.findViewById(R.id.txtNom);
        TextView txtApell = v.findViewById(R.id.txtApel);
        TextView txtCiclo = v.findViewById(R.id.txtCiclo);

        txtNombre.setText(elementoActual.getNombre());
        txtApell.setText(elementoActual.getApellidos());
        txtCiclo.setText(elementoActual.getCiclo());

        if (elementoActual.getSexo().equals("H") ){
            imageViewAl.setImageResource(R.drawable.boy);
        }else if (elementoActual.getSexo().equals("M")){
            imageViewAl.setImageResource(R.drawable.girl);
        }
        return v;
    }
}
