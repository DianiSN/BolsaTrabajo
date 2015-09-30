package com.example.diana.finalproject;

/**
 * Created by Lilly Ann on 30/09/2015.
 */

import android.os.Bundle;


public class Vacante_base
{
    public static final String EMPRESA = "NombreEmpresa";
    public static final String LOGO = "LogoEmpresa";


    private String NombreEmpresa;
    private int LogoEmpresa;

    public String getNombreEmpresa() {
        return NombreEmpresa;
    }

    public void setNombreEmpresa(String name) {
        this.NombreEmpresa = name;
    }

    public int getLogoEmpresa() {
        return LogoEmpresa;
    }

    public void setLogoEmpresa(int imageResource) {
        this.LogoEmpresa = imageResource;
    }

    public Vacante_base(String id, int imageResource)
    {
        this.NombreEmpresa = id;
        this.LogoEmpresa = imageResource;

    }

}
