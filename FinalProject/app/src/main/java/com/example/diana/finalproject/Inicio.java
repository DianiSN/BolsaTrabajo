package com.example.diana.finalproject;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by Diana on 9/29/15.
 */
public class Inicio extends AppCompatActivity {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        gv=(GridView) findViewById(R.id.gridView1);
        gv.setAdapter(new ShowInicio(this, company, logo));
    }
}
