package com.example.diana.finalproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Diana on 9/30/15.
 */
public class ShowFavorites extends BaseAdapter {

    ArrayList result;
    Context context;
    ArrayList imageId;
    private static LayoutInflater inflater=null;

    public ShowFavorites(Favorites favorites, ArrayList favoriteCompany, ArrayList logo) {

        result=favoriteCompany;
        context=favorites;
        imageId=logo;

        inflater = ( LayoutInflater )context. getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }

    @Override
    public int getCount() {
        return result.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View rowView;
        TextView tv;
        ImageView img;
        rowView = inflater.inflate(R.layout.activity_fav, null);
        tv=(TextView) rowView.findViewById(R.id.textView1);
        img=(ImageView) rowView.findViewById(R.id.imageView1);
        tv.setText(result.get(position).toString());
        img.setImageResource((Integer)imageId.get(position));
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Toast.makeText(context, "You Clicked " + result[position], Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context,Vacante.class);
                Bundle b = new Bundle();
                b.putInt("image",(Integer)imageId.get(position));
                b.putInt("position",position);
//                intent.putExtras(b);
                b.putString("name",result.get(position).toString());
                intent.putExtras(b);
                v.getContext().startActivity(intent);
                Log.i("CREATION", result.get(position).toString());
            } });
        return rowView;
    }
}
