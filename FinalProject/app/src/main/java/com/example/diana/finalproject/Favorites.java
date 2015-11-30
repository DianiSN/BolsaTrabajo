package com.example.diana.finalproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by Diana on 9/30/15.
 */
public class Favorites extends AppCompatActivity {

    GridView gv;
    Context context;
    ArrayList prgmName;

    SingletonFavorites favs;
    //name of the companies
//    public static String [] favoriteCompany ={"Facebook","GE","Google","HP",
//           "Oracle","TI","Yelp"};

//    public static ArrayList favCompany = new ArrayList();
//    public static ArrayList favLogo = new ArrayList();

    public static ArrayList favCompany;
    public static ArrayList favLogo;
    String matricula;

    //name of the images linked to the names
//    public static int [] logo ={R.drawable.facebook,R.drawable.ge,R.drawable.google,R.drawable.hp,R.drawable.oracle,R.drawable.ti,R.drawable.yelp};


    public Favorites() {


//        favCompany.add("Facebook");
//        favCompany.add("GE");
//        favLogo.add(R.drawable.facebook);
//        favLogo.add(R.drawable.ge);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        favCompany = favs.getInstance().getFavCompany();
        favLogo = favs.getInstance().getFavLogo();
//        boolean result = favs.getInstance().addCompany("GE", R.drawable.ge);
//        boolean result1 =favs.getInstance().addCompany("Facebook",R.drawable.facebook);
//        if(result1 == false || result == false){
//
//            Log.d("CREATION","Company not added");
//
//        }

//        if(favs.getInstance().findCompany("GE") != 1){
//
//            Log.d("CREATE","GE FOUND favorites");
//
//
//        }


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gridfav);
        Bundle b = getIntent().getExtras();
        matricula = b.getString("matricula");
        gv=(GridView) findViewById(R.id.gridView1);
        gv.setAdapter(new ShowFavorites(this,favCompany,favLogo,matricula));
    }

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
//        else if (id == R.id.action_fav)
//        {
//            finish();
//            startActivity(new Intent(getApplicationContext(), Favorites.class));
//
//        }else if (id == R.id.action_perfil)
//        {
//            finish();
//            startActivity(new Intent(getApplicationContext(), Perfil.class));
//        }

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
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

//    public int findCompany(String name){
//
//        if(favCompany.contains(name)){
//
//            return favCompany.indexOf(name);
//        }else{
//            return -1;
//        }
//
//    }
//
//    public boolean removeCompany(int position){
//
//        favCompany.remove(position);
//        favLogo.remove(position);
//        return true;
//    }
//
//    public boolean addCompany(String name, int image){
//
//        favCompany.add(name);
//        favLogo.add(image);
//        return true;
//
//    }









}
