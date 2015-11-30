package com.example.diana.finalproject;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;


public class VacanteInformacion {

    private List<Vacante_base> vacante = new ArrayList<Vacante_base>();

    public List<Vacante_base> getVacante_base()
    {
        return vacante;
    }

    public VacanteInformacion()
    {
      //  Vacante_base.add(new Vacante_base("Apple", R.drawable.apple));
       // Vacante_base.add(new Vacante_base("Facebook", R.drawable.facebook));
        // Vacante_base.add(new Vacante_base("Oracle", R.drawable.oracle));



    }

}
