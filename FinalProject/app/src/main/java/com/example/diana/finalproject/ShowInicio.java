package com.example.diana.finalproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class ShowInicio extends BaseAdapter
{
    String [] result;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;

    public ShowInicio(Inicio inicio, String[] company, int[] logo)
    {

        result=company; //array of the companies names
        context=inicio;
        imageId=logo; //array of the companies logos

        inflater = ( LayoutInflater )context. getSystemService(Context.LAYOUT_INFLATER_SERVICE);

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
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        // carga este por cada empresa,
        // carga este por cada empresa cada que bajo la pantalla

        View rowView;
        TextView tv;
        ImageView img;
        rowView = inflater.inflate(R.layout.activity_inicio, null);
        tv=(TextView) rowView.findViewById(R.id.textView1);
        img=(ImageView) rowView.findViewById(R.id.imageView1);
        tv.setText(result[position]);
        img.setImageResource(imageId[position]);



        // cada que hay clic en una empresa

        rowView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context,Vacante.class);
                Bundle b = new Bundle();
                b.putInt("image",imageId[position]);
                b.putInt("position",position);
//                intent.putExtras(b);
                b.putString("name",result[position]);
                intent.putExtras(b);
                v.getContext().startActivity(intent);
                Log.i("CREATION", result[position]);
                // Conectar con Vacante.class *************


                // Carga la vacante dependiendo la empresa que se dio click
                // debo enviarle el result[position] para que cargue la debida información



            } });
        return rowView;

    }
}
