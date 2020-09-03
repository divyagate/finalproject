package com.example.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListViewAdpter extends BaseAdapter {

    Context context;
    ArrayList<Punkapi> repoArrayList;
    LayoutInflater inflater;

    public ListViewAdpter(Context context, ArrayList<Punkapi> PunkArrayList) {
        this.context = context;
        this.repoArrayList = PunkArrayList;
    }

    @Override
    public int getCount() {
        return repoArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return repoArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
        {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.customview,parent,false);
        }


        TextView textView = convertView.findViewById(R.id.beer_txtV);
        ImageView imgView = convertView.findViewById(R.id.beer_img);

        textView.setText(repoArrayList.get(position).getName());
        Picasso.get().load(repoArrayList.get(position).getimage_url()).into(imgView);

        return convertView;
    }
}

