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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.i("CREATION", "Solicitud");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud);

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
        Intent chooser;
        Log.i("Send email", "");

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));



        String[] TO = {"a01320622@gmail.com"};
        String[] CC = {"diansanieto@gmail.com"};

        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");
        emailIntent.setType("message/rfc822");

        chooser = Intent.createChooser(emailIntent,"Send email");


        try {
            startActivity(chooser);
            finish();
            Log.d("CREATE", "email sent with vacancy");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Solicitud.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) //botones
    {
        switch (v.getId())
        {
            case R.id.bEnviar: // se ha picado el boton enviar
                Log.i("CREATION", "Enviar solicitud");
                sendEmail();
                break;
        }
    }


}