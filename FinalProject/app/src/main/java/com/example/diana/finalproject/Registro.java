package com.example.diana.finalproject;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registro extends AppCompatActivity implements View.OnClickListener
{

    Button bRegistro, bVacante;
    EditText eNombre, eApellido, eCorreo, eMatricula, eContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        eNombre = (EditText) findViewById(R.id.eNombre);
        eCorreo = (EditText) findViewById(R.id.eCorreo);
        eMatricula = (EditText) findViewById(R.id.eMatricula);
        eContrasena = (EditText) findViewById(R.id.eContrasena);
        bRegistro = (Button) findViewById(R.id.bRegistro);
        bVacante = (Button) findViewById(R.id.bVacante);

        bRegistro.setOnClickListener(this);
        bVacante.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) //botones
    {
        switch(v.getId())
        {
            case R.id.bRegistro:
                break;


            case R.id.bVacante:
                Log.d("CREATION", "VACANTE is being executed!");
                finish();
                startActivity(new Intent(getApplicationContext(), Vacante.class));
                break;
        }
    }


}
