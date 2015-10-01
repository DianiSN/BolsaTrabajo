package com.example.diana.finalproject;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
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
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button bLogin;
    EditText eMatricula, eContrasena;
    TextView tvLinkRegistro, tvOlvidoPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.i("CREATION", "holi guapas");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // activity_main

        eMatricula = (EditText)findViewById(R.id.eMatricula);
        eContrasena = (EditText)findViewById(R.id.eContrasena);
        bLogin = (Button) findViewById(R.id.bLogin);
        tvLinkRegistro = (TextView) findViewById(R.id.tvLinkRegistro);
        tvOlvidoPass = (TextView) findViewById(R.id.tvOlvidoPass);

        bLogin.setOnClickListener(this);
        tvLinkRegistro.setOnClickListener(this);
        tvOlvidoPass.setOnClickListener(this);
    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Toast.makeText(MainActivity.this, "Ayyyyy!",
                    Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void onBackPressed()


    {
        Log.d("CREATION", "go back pressed!");
        if(getFragmentManager().getBackStackEntryCount()>0)
        {
            getFragmentManager().popBackStackImmediate();

        }
    }


    //@Override
    public void onClick(View v) // botones
            {

                switch(v.getId())
                {
                    case R.id.bLogin:

                Log.d("CREATION", "INICIO is being executed!");
                finish();
                startActivity(new Intent(getApplicationContext(), Inicio.class));
                break;

            case R.id.tvLinkRegistro:

                Log.d("CREATION", "REGISTRO is being executed!");
                finish();
                Intent i = new Intent(this,Registro.class);
                startActivity(i);
                break;

            case R.id.tvOlvidoPass:
                Log.d("CREATION", "FORGOTTEN PASS is being executed!");
                finish();
                i = new Intent(this,Recupera.class);
                startActivity(i);
                break;

        }
    }
}
