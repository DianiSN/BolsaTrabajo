package com.example.diana.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button bLogin;
    EditText eMatricula, eContrasena;
    TextView tvLinkRegistro, tvOlvidoPass;
    /*
        @Override
        public boolean onOptionsItemSelected(MenuItem item)
        {
            int id = item.getItemId();
            if (id == R.id.tvLinkRegistro)
            {
                Log.d("CREATION", "tvLinkRegistro is being executed!");
                finish();
                Intent i = new Intent(this,Registro.class);
                startActivity(i);
            }
            return super.onOptionsItemSelected(item);
        }
    */



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.i("CREATION", "holiwis");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eMatricula = (EditText)findViewById(R.id.eMatricula);
        eContrasena = (EditText)findViewById(R.id.eContrasena);
        bLogin = (Button) findViewById(R.id.bLogin);
        tvLinkRegistro = (TextView) findViewById(R.id.tvLinkRegistro);
        tvOlvidoPass = (TextView) findViewById(R.id.tvOlvidoPass);

        bLogin.setOnClickListener(this);
        tvLinkRegistro.setOnClickListener(this);
        tvOlvidoPass.setOnClickListener(this);
    }

    //@Override
    public void onClick(View v)
    {

        switch(v.getId())
        {
            case R.id.bLogin:

                Log.d("CREATION", "bLogin is being executed!");
                finish();
                startActivity(new Intent(getApplicationContext(), Inicio.class));
                break;

            case R.id.tvLinkRegistro:

                Log.d("CREATION", "tvLinkRegistro is being executed!");
                finish();
                Intent i = new Intent(this,Registro.class);
                startActivity(i);
                break;

            case R.id.tvOlvidoPass:
                Log.d("CREATION", "tvOlvidoPass is being executed!");
                finish();
                i = new Intent(this,Recupera.class);
                startActivity(i);
                break;

        }
    }
}
