package com.example.diana.finalproject;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
/**
 * Created by Diana on 11/16/15.
 */
public class ShowTabs extends Activity {

    private TabHost myTabHost;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabhost);
//        widget = (TabWidget)findViewById(R.id.lltab1);
//        get tabHost

        LocalActivityManager mLocalActivityManager = new LocalActivityManager(this,false);
        mLocalActivityManager.dispatchCreate(savedInstanceState); // state will be bundle your activity state which you get in onCreate


        myTabHost = (TabHost) findViewById(R.id.tabHost);


//        set up the tabhost

        myTabHost.setup(mLocalActivityManager);


//        FIRST TAB - Favorites  SECOND TAB - Vacancy THIRD TAB - Profile

        TabHost.TabSpec tabFav,tabVacancy,tabProfile;

        tabFav = myTabHost.newTabSpec("favorites");
        tabVacancy = myTabHost.newTabSpec("vacancy");
        tabProfile = myTabHost.newTabSpec("tabProfile");

//        FAVORITES

        Intent intentFav = new Intent().setClass(this, Favorites.class);
        tabFav.setContent(intentFav);
        tabFav.setIndicator("Favoritos");
        myTabHost.addTab(tabFav);

//        VACANCY
        Intent intentVacancy = new Intent().setClass(this, Inicio.class);
        tabVacancy.setContent(intentVacancy);
        tabVacancy.setIndicator("Vacantes");
        myTabHost.addTab(tabVacancy);

//        PROFILE

        Intent intentProfile = new Intent().setClass(this, Perfil.class);
        tabProfile.setContent(intentProfile);
        tabProfile.setIndicator("Perfil");
        myTabHost.addTab(tabProfile);

        myTabHost.setCurrentTab(1);

    }


}
