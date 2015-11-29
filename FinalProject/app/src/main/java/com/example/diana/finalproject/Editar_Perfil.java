package com.example.diana.finalproject;

import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Editar_Perfil extends AppCompatActivity implements View.OnClickListener {
    TextView name;
    Button bCancel, bSave,bFoto;
    ImageView imgPP;
    DataBaseHelper db;
    private static int RESULT_LOAD_IMG = 1;
    String imgDecodableString;
    String matricula;

    EditText experiencias,habilidades,proyectos,intereses,extra,actividades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editperfil); // edit perfil

        db = new DataBaseHelper(this);
        name = (TextView) findViewById(R.id.name);
        bCancel = (Button) findViewById(R.id.bCancel);
        bSave = (Button) findViewById(R.id.bSave);
        bFoto = (Button) findViewById(R.id.bfoto);
        imgPP = (ImageView) findViewById(R.id.profilePic);

        bCancel.setOnClickListener(this);
        bSave.setOnClickListener(this);
        bFoto.setOnClickListener(this);

        Bundle b = getIntent().getExtras();
        matricula = b.getString("matricula");
        Log.d("Editar_perf", matricula);
        getName(matricula);

        // load previous info

       getData(matricula);
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
            Intent intent = new Intent(this, ShowTabs.class);
            Bundle b = new Bundle();
            b.putString("image",imgDecodableString);
            b.putString("matricula",matricula);
            b.putInt("current",2);
            intent.putExtras(b);
            startActivity(intent);
        }
    }

    public void getName(String matricula){
        String userName;
        Cursor nombre = db.getNombre(matricula);
        if (nombre.getCount() == 0){
            Toast.makeText(this, "No existe usuario", Toast.LENGTH_LONG).show();
            return;
        } else {
            nombre.moveToFirst();
            userName = nombre.getString(0).concat(" ").concat(nombre.getString(1));
        }
        name.setText(userName);
    }

    public void updateData()
    {
        experiencias = (EditText)findViewById(R.id.editExperiencia);
        habilidades = (EditText)findViewById(R.id.editHabilidades);
        proyectos = (EditText)findViewById(R.id.editPoyectos);
        intereses = (EditText)findViewById(R.id.editIntereses);
        extra = (EditText)findViewById(R.id.editActividades);

        String exp = experiencias.getText().toString();
        String hab = habilidades.getText().toString();
        String pro = proyectos.getText().toString();
        String inte = intereses.getText().toString();
        String ext = extra.getText().toString();

        boolean isUpdated = db.updateDataProfile(matricula, exp, hab, pro, inte, ext);
        if (isUpdated)
        {
            Toast.makeText(this, "Perfil editado.", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "Perfil no editado. Intente de nuevo.", Toast.LENGTH_LONG).show();

        }
    }

    public void getData(String matricula) {
        String userName;

        Cursor nombre = db.getNombre(matricula);
        if (nombre.getCount() == 0){
            Toast.makeText(this, "No existe usuario", Toast.LENGTH_LONG).show();
            return;
        } else {
            nombre.moveToFirst();
            userName = nombre.getString(0).concat(" ").concat(nombre.getString(1));
        }


        Cursor result = db.getDataProfile(matricula);
        if (result.getCount() == 0) {
            Toast.makeText(this, "No existe informacion del usuario", Toast.LENGTH_LONG).show();
            return;
        }
        result.moveToFirst();
        experiencias = (EditText)findViewById(R.id.editExperiencia);
        habilidades = (EditText)findViewById(R.id.editHabilidades);
        proyectos = (EditText)findViewById(R.id.editPoyectos);
        intereses = (EditText)findViewById(R.id.editIntereses);
        extra = (EditText)findViewById(R.id.editActividades);


        experiencias.setText(result.getString(1));
        proyectos.setText(result.getString(3));
        habilidades.setText(result.getString(2));
        intereses.setText(result.getString(4));
       extra.setText(result.getString(5));
    }

    public void loadImagefromGallery(View view) {
        // Create intent to Open Image applications like Gallery, Google Photos
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        // Start the Intent
        startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK
                    && null != data) {
                // Get the Image from data

                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };

                // Get the cursor
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableString = cursor.getString(columnIndex);
                cursor.close();

                // Set the Image in ImageView after decoding the String
                imgPP.setImageBitmap(BitmapFactory
                        .decodeFile(imgDecodableString));

            } else {
                Toast.makeText(this, "No elegiste una imagen",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Oops hubo un problema", Toast.LENGTH_LONG)
                    .show();
        }

    }

    public void onClick(View v) // botones
    {
        switch(v.getId())
        {
            case R.id.bSave:

                updateData();
                finish();
                Intent i = new Intent(getApplicationContext(), ShowTabs.class);
                Bundle b = new Bundle();
                b.putString("image",imgDecodableString);
                b.putInt("current", 2);
                b.putString("matricula",matricula);
                i.putExtras(b);
                startActivity(i);
                break;

            case R.id.bCancel:
                finish();
                Intent in = new Intent(getApplicationContext(), ShowTabs.class);
                Bundle bi = new Bundle();
                bi.putString("image","");
                bi.putInt("current",2);
                bi.putString("matricula",matricula);
                in.putExtras(bi);
                startActivity(in);
                break;
            case R.id.bfoto:
                loadImagefromGallery(v);
//              Toast.makeText(this, "Change pic", Toast.LENGTH_LONG).show();
                break;

        }
    }

}
