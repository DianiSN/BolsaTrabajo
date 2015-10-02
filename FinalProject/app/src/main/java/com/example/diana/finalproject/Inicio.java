package com.example.diana.finalproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.Menu;
import android.widget.GridView;

import java.util.ArrayList;

public class Inicio extends AppCompatActivity
{

    GridView gv;
    Context context;
    ArrayList prgmName;

    //    name of the companies
    public static String [] company ={"Amazon","Apple","Cisco","Dell","Ebay","Facebook","GE","Google","HP",
            "Intel","Logitech","Microsoft","Oracle","TI","Yelp"};

    //    name of the images linked to the names
    public static int [] logo ={R.drawable.amazon,R.drawable.apple,R.drawable.cisco,R.drawable.dell
            ,R.drawable.ebay,R.drawable.facebook,R.drawable.ge,R.drawable.google,R.drawable.hp,R.drawable.intel
            ,R.drawable.logitech,R.drawable.microsoft,R.drawable.oracle,R.drawable.ti,R.drawable.yelp};



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)  // menu dropdown
    {
        Log.i("CREATION", "Menu dropdown");
        int id = item.getItemId();
        if (id == R.id.action_logout)
        {
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
        else if (id == R.id.action_fav)
        {
            finish();
            startActivity(new Intent(getApplicationContext(), Favorites.class));

        }else if (id == R.id.action_perfil)
        {
            finish();
            startActivity(new Intent(getApplicationContext(), Perfil.class));
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed()
    {
        Log.d("CREATION", "go back pressed!");
        if(getFragmentManager().getBackStackEntryCount()>0)
        {
            Intent intent = new Intent(this, Inicio.class);
            startActivity(intent);

        }else
        {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_perfil);
        setContentView(R.layout.activity_gridinicio);
        gv=(GridView) findViewById(R.id.gridView1);
        gv.setAdapter(new ShowInicio(this, company, logo));
    }
}
