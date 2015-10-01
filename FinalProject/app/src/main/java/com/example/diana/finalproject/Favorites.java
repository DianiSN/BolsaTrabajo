package com.example.diana.finalproject;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by Diana on 9/30/15.
 */
public class Favorites extends AppCompatActivity {

    GridView gv;
    Context context;
    ArrayList prgmName;

    //    name of the companies
    public static String [] favoriteCompany ={"Facebook","GE","Google","HP",
           "Oracle","TI","Yelp"};

    //    name of the images linked to the names
    public static int [] logo ={R.drawable.facebook,R.drawable.ge,R.drawable.google,R.drawable.hp,R.drawable.oracle,R.drawable.ti,R.drawable.yelp};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridfav);
        gv=(GridView) findViewById(R.id.gridView1);
        gv.setAdapter(new ShowFavorites(this, favoriteCompany, logo));
    }
}
