package com.example.diana.finalproject;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Andrea on 29/09/2015.
 */
public class Perfil extends AppCompatActivity {

    String image;
    ImageView imgView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        imgView = (ImageView)findViewById(R.id.imageView);
        Bundle b = getIntent().getExtras();
        image = b.getString("image");
        if(image == null){

            imgView.setImageResource(R.drawable.samanta);

        }else{

            imgView.setImageBitmap(BitmapFactory
                    .decodeFile(image));

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_perfil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_edit) {
            finish();
            startActivity(new Intent(getApplicationContext(), Editar_Perfil.class));

            return true;
        }
        else if(id == R.id.action_logout){
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed()
    {
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


