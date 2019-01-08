package com.example.sunrin_08.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MainAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<Item> al;
    public MainAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        al = new ArrayList<Item>();
    }
    @Override
    public int getCount() {
        return al.size();
    }
    @Override
    public Item getItem(int position) {
        return al.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.ani_main, null);
        }
        TextView title = convertView.findViewById(R.id.title);
        TextView type = convertView.findViewById(R.id.type);
        title.setText(this.getItem(position).getTitle());
        type.setText(this.getItem(position).getType());
        return convertView;
    }


    public void putItem(Item i) {
        al.add(i);
    }
}
