package com.example.diana.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Diana on 9/29/15.
 */
public class ShowInicio extends BaseAdapter {
    String [] result;
    Context context; int [] imageId;
    private static LayoutInflater inflater=null;

    public ShowInicio(Inicio inicio, String[] prgmNameList, int[] prgmImages) {

        result=prgmNameList;
        context=inicio;
        imageId=prgmImages;

        inflater = ( LayoutInflater )context. getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    public class Holder {
        TextView tv;
        ImageView img;
    }

    @Override
    public int getCount() {
        return result.length;
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
        Holder holder = new Holder();
        rowView = inflater.inflate(R.layout.activity_inicio, null); holder.tv=(TextView) rowView.findViewById(R.id.textView1);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView1);
        holder.tv.setText(result[position]); holder.img.setImageResource(imageId[position]);
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
            } });
        return rowView;

    }
}
