package com.example.diana.finalproject;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Andrea on 29/09/2015.
 */
public class Perfil extends AppCompatActivity {


    DataBaseHelper db;
    TextView experiencia, habilidades, intereses, proyectos, name, actividades;

    String image;
    ImageView imgView;
    String matricula;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        db = new DataBaseHelper(this);
        imgView = (ImageView)findViewById(R.id.imageView);
        name = (TextView) findViewById(R.id.name);
        experiencia = (TextView) findViewById(R.id.experiencia);
        habilidades = (TextView) findViewById(R.id.habilidades);
        intereses = (TextView) findViewById(R.id.intereses);
        proyectos = (TextView) findViewById(R.id.proyectos);
        actividades = (TextView) findViewById(R.id.actividades);

        Bundle b = getIntent().getExtras();
      //  image = b.getString("image");
        matricula = b.getString("matricula");

        getData(matricula);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_perfil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_edit) {
            finish();
            Intent i = new Intent().setClass(this, Editar_Perfil.class);
            Bundle c = new Bundle();
            c.putString("matricula", matricula);
            Log.d("Mat Per bundle", c.getString("matricula"));
            i.putExtras(c);
            startActivity(i);
            return true;
        }
        else if(id == R.id.action_logout){
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed()
    {
        if(getFragmentManager().getBackStackEntryCount()>0)
        {
            getFragmentManager().popBackStackImmediate();
        }else
        {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    public void getData(String matricula) {
        String userName;
        Cursor nombre = db.getNombre(matricula);
        if (nombre.getCount() == 0){
            Toast.makeText(this, "No existe usuario", Toast.LENGTH_LONG).show();
            return;
        } else {
            nombre.moveToFirst();
            userName = nombre.getString(0).concat(" ").concat(nombre.getString(1));
        }

        name.setText(userName);
        Cursor result = db.getDataProfile(matricula);
        if (result.getCount() == 0) {
            Toast.makeText(this, "No existe informacion del usuario", Toast.LENGTH_LONG).show();
            return;
        }
        result.moveToFirst();
        experiencia.setText(result.getString(1));
        proyectos.setText(result.getString(3));
        habilidades.setText(result.getString(2));
        intereses.setText(result.getString(4));
        actividades.setText(result.getString(5));

        if(result.getString(6)==null || result.getString(6).equals(" ")){
            imgView.setImageResource(R.drawable.samanta);
        }else{
            imgView.setImageBitmap(BitmapFactory
                    .decodeFile(result.getString(6))); //imgDecodableString
        }



    }
}


