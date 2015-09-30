package com.example.diana.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Vacante extends AppCompatActivity implements View.OnClickListener
{

    Button bAplicar;
    TextView tvDescripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacante);


        bAplicar = (Button) findViewById(R.id.bAplicar);
        bAplicar.setOnClickListener(this);

        // dependiendo del click, carga la info correspondiente



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) // menu dropdown
    {
        int id = item.getItemId();
        if (id == R.id.action_logout)
        {
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }



    public void onClick(View v) // botones
    {
        switch (v.getId())
        {
            case R.id.bAplicar: // se ha picado el boton para aplicar a la vacante
                Log.i("CREATION", "Aplicar");
                break;
        }
    }

}
