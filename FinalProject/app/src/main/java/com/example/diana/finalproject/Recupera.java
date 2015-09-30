package com.example.diana.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class Recupera extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrasenia);
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

}
