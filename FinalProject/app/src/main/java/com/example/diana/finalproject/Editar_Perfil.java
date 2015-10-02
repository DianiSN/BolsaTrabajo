package com.example.diana.finalproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;
/**
 * Created by Andrea on 30/09/2015.
 */
public class Editar_Perfil extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.i("CREATION", "Editar Perfil");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editperfil); // edit perfil
    }

    public void onBackPressed()
    {
        Log.d("CREATION", "go back pressed!");
        if(getFragmentManager().getBackStackEntryCount()>0)
        {
            getFragmentManager().popBackStackImmediate();
        }
    }


}
