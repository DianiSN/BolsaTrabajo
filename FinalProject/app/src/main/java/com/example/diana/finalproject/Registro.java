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
import android.widget.Toast;

public class Registro extends AppCompatActivity implements View.OnClickListener
{
    DataBaseHelper database;
    Button bRegistro;
    EditText eNombre, eApellido, eCorreo, eMatricula, contrasenia, contrasenia2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        database = new DataBaseHelper(this);
        eNombre = (EditText) findViewById(R.id.eNombre);
        eApellido = (EditText) findViewById(R.id.eApellido);
        eCorreo = (EditText) findViewById(R.id.eCorreo);
        eMatricula = (EditText) findViewById(R.id.eMatricula);
        contrasenia = (EditText) findViewById(R.id.contrasena);
        contrasenia2 = (EditText) findViewById(R.id.contrasena2);
        bRegistro = (Button) findViewById(R.id.bRegistro);

        bRegistro.setOnClickListener(this);

    }

    @Override
    public void onBackPressed()
    {
        Log.d("CREATION", "go back pressed!");
        if(getFragmentManager().getBackStackEntryCount()>0)
        {
            getFragmentManager().popBackStackImmediate();
        }else
        {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    public void registerUser()
    {
        String nombre =  eNombre.getText().toString();
        String apellido = eApellido.getText().toString();
        String correo = eCorreo.getText().toString();
        String matricula = eMatricula.getText().toString();
        String contraseniaa = contrasenia.getText().toString();
        String contraseniaa2 = contrasenia2.getText().toString();

        Boolean isInserted = false;
        if(contraseniaa.equals(contraseniaa2))
        {
            isInserted = database.registerUser(matricula, nombre, apellido, correo, contraseniaa);

            if (isInserted)
            {
                Toast.makeText(this, "The data was inserted", Toast.LENGTH_LONG).show();
            } else
            {
                Toast.makeText(this, "The data was not inserted", Toast.LENGTH_LONG).show();
            }
        }else
        {
            Toast.makeText(this, "Las contraseñas no coinciden. Intente de nuevo.", Toast.LENGTH_LONG).show();
        }
    }
        @Override
    public void onClick(View v) //botones
    {
        switch(v.getId())
        {
            case R.id.bRegistro:
                    registerUser();
                break;



        }
    }


}
