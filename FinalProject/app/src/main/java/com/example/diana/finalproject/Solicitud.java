package com.example.diana.finalproject;

import android.content.Intent;
import android.net.Uri;
import android.sax.TextElementListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class Solicitud extends AppCompatActivity implements View.OnClickListener
{

    public static final String EMPRESA_BUNDLE = "EMPRESA_BUNDLE";
    Button bEnviar;
    EditText eCorreo, eCelular, eMensaje;
    String vacancy;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.i("CREATION", "Solicitud");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud);

        Bundle b = getIntent().getExtras();
        vacancy = b.getString("vacancy");

        bEnviar = (Button) findViewById(R.id.bEnviar);
        eCorreo = (EditText) findViewById(R.id.eCorreo);
        eCelular = (EditText) findViewById(R.id.eCelular);
        eMensaje = (EditText) findViewById(R.id.eMensaje);


        bEnviar.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)  // menu dropdown
    {
        int id = item.getItemId();
        if (id == R.id.action_logout)
        {
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
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
            Intent intent = new Intent(this, ShowTabs.class);
            startActivity(intent);
        }
    }

    protected void sendEmail() {
        //Getting content for email
        String email = "diansanieto@gmail.com";
        String subject = vacancy;
        String message = eMensaje.getText().toString().trim() + "\nNúmero de contacto: "+ eCelular.getText().toString().trim();

        //Creating SendMail object
        SendMail sm = new SendMail(this, email, subject, message);

        //Executing sendmail to send email
        sm.execute();
    }

    @Override
    public void onClick(View v) //botones
    {
        switch (v.getId())
        {
            case R.id.bEnviar: // se ha picado el boton enviar
                Log.i("CREATION", "Enviar solicitud");
                sendEmail();
                Log.i("CREATION", "solicitud Enviada");
                break;
        }
    }


}