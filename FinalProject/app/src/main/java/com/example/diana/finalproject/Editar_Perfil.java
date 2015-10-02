package com.example.diana.finalproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;


/**
 * Created by Andrea on 30/09/2015.
 */
public class Editar_Perfil extends AppCompatActivity implements View.OnClickListener {
    Button bCancel, bSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editperfil); // edit perfil

        bCancel = (Button) findViewById(R.id.bCancel);
        bSave = (Button) findViewById(R.id.bSave);

        bCancel.setOnClickListener(this);
        bSave.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_logout) {
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));

            return true;
        }

        return super.onOptionsItemSelected(item);
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
            Intent intent = new Intent(this, Perfil.class);
            startActivity(intent);
        }
    }

    public void onClick(View v) // botones
    {
        switch(v.getId())
        {
            case R.id.bSave:
                finish();
                startActivity(new Intent(getApplicationContext(), Perfil.class));
                break;

            case R.id.bCancel:
                finish();
                startActivity(new Intent(getApplicationContext(), Perfil.class));
                break;

        }
    }

}
