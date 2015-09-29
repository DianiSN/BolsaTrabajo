package com.example.diana.finalproject;

import android.sax.TextElementListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Solicitud extends AppCompatActivity implements View.OnClickListener
{

    Button bEnviar;
    EditText eCorreo, eCelular, eMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.i("CREATION", "Solicitud");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud);

        bEnviar = (Button) findViewById(R.id.bEnviar);
        eCorreo = (EditText) findViewById(R.id.eCorreo);
        eCelular = (EditText) findViewById(R.id.eCelular);
        eMensaje = (EditText)findViewById(R.id.eMensaje);


    }

    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.bEnviar:
                Log.i("CREATION", "Enviar solicitud");
                break;
        }
    }

}
