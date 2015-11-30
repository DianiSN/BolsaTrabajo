package com.example.diana.finalproject;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Recupera extends AppCompatActivity implements View.OnClickListener
{
    Button bEnviar;
    EditText eCorreo;
    DataBaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrasenia);
        db = new DataBaseHelper(this);
        eCorreo = (EditText)findViewById(R.id.eCorreo);
        bEnviar = (Button)findViewById(R.id.bEnviar);
        bEnviar.setOnClickListener(this);
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

    protected void sendEmail() {
        //Getting content for email
        String contra = "";
        Cursor result = db.getInicio(eCorreo.getText().toString());

        if (result.getCount() == 0) {
            Toast.makeText(this, "The user doesn't exist", Toast.LENGTH_LONG).show();
        }

        while(result.moveToNext()) {
            contra = result.getString(0);
        }


        String email = eCorreo.getText().toString()+"@itesm.mx";
        String subject = "Recuperación Bolsa de Trabajo";
        String message =  "Tu contraseña para la Bolsa de Trabajo es: "+ contra;

        //Creating SendMail object
        SendMail sm = new SendMail(this, email, subject, message);

        //Executing sendmail to send email
        sm.execute();
    }


    @Override
    public void onClick(View v) //botones
    {
        switch(v.getId())
        {
            case R.id.bEnviar:
                sendEmail();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;

        }
    }

}
