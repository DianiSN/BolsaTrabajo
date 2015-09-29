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

    Button bRegistro, bSolicitud;
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
        bSolicitud = (Button) findViewById(R.id.bSolicitud);

        bRegistro.setOnClickListener(this);
        bSolicitud.setOnClickListener(this);

    }


    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.bRegistro:
                break;


            case R.id.bSolicitud:
                Log.d("CREATION", "SOLICITUD is being executed!");
                finish();
                startActivity(new Intent(getApplicationContext(), Solicitud.class));
                break;
        }
    }


}
