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
import android.widget.Toast;


/**
 * Created by Andrea on 30/09/2015.
 */
public class Editar_Perfil extends AppCompatActivity implements View.OnClickListener {
    Button bCancel, bSave,bFoto;
    ImageView imgPP;
    DataBaseHelper db;
    private static int RESULT_LOAD_IMG = 1;
    String imgDecodableString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editperfil); // edit perfil

        bCancel = (Button) findViewById(R.id.bCancel);
        bSave = (Button) findViewById(R.id.bSave);
        bFoto = (Button) findViewById(R.id.bfoto);
        imgPP = (ImageView) findViewById(R.id.profilePic);

        bCancel.setOnClickListener(this);
        bSave.setOnClickListener(this);
        bFoto.setOnClickListener(this);


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
            startActivity(intent);
        }
    }

    public void updateData(View view) {

        EditText experiencias,habilidades,proyectos,intereses,extra;
        experiencias = (EditText)view.findViewById(R.id.editExperiencia);
        habilidades = (EditText)view.findViewById(R.id.editHabilidades);
        proyectos = (EditText)view.findViewById(R.id.editPoyectos);
        intereses = (EditText)view.findViewById(R.id.editIntereses);
        extra = (EditText)view.findViewById(R.id.editActividades);

        String exp = experiencias.getText().toString();
        String hab = habilidades.getText().toString();
        String pro = proyectos.getText().toString();
        String inte= intereses.getText().toString();
        String ext = extra.getText().toString();

////        boolean isUpdated = db.updateDataProfile(matricula,exp,hab,pro,inte,ext);
//        if (isUpdated) {
//            Toast.makeText(this, "The data was updated", Toast.LENGTH_LONG);
//        } else {
//            Toast.makeText(this, "The data was not updated", Toast.LENGTH_LONG);
//
//        }
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
                Toast.makeText(this, "You haven't picked Image",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
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
            case R.id.bfoto:
                loadImagefromGallery(v);
//              Toast.makeText(this, "Change pic", Toast.LENGTH_LONG).show();

                break;

        }
    }

}
