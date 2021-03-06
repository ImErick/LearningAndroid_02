package com.example.erickgarcia.learningandroid_02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by erickgarcia on 04/07/17.
 * Para que sirve el adpatador customizado exactamente?
 * Sirve pa meter el list_item customizado
 */

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> names;

    public MyAdapter(Context context, int layout, List<String> names){
        this.context = context;
        this.layout =layout;
        this.names = names;
    }

    // devuelve el tamaño de la lista a iterar
    @Override
    public int getCount() {
        return this.names.size();
    }

    // devuelve un item de esa coleccion
    @Override
    public Object getItem(int position) {
        return this.names.get(position);
    }

    // no voy a usar a este weon, pero awebo lo tengo que tener aqui
    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        // view Holder Pattern
        ViewHolder holder;
        if (convertView == null){
            // inflamos la vista que nos ha llegado con nuestro layout personalizado (list_item.xml)
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(this.layout, null);

            holder = new ViewHolder();
            // referenciamos el elemento a modificar y lo rellenamos
            holder.nameTextView = (TextView) convertView.findViewById(R.id.textView2);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // nos traemos el valor actual dependiendo de la posicion
        String currentName = this.names.get(position);

        // referenciamos el elemento a modificar y lo rellenamos
        holder.nameTextView.setText(currentName);

        return convertView;
    }

    static class ViewHolder{
        private  TextView nameTextView;
    }
}
