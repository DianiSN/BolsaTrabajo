package com.example.diana.finalproject;

import java.util.ArrayList;

/**
 * Created by Diana on 11/27/15.
 */
public class SingletonFavorites {

    public static ArrayList favCompany = new ArrayList();
    public static ArrayList favLogo = new ArrayList();

    private static SingletonFavorites instance = null;
    protected SingletonFavorites() {
        // Exists only to defeat instantiation.
    }
    public static SingletonFavorites getInstance() {
        if(instance == null) {

            instance = new SingletonFavorites();
        }
        return instance;
    }

    public int findCompany(String name){

        if(favCompany.contains(name)){

            return favCompany.indexOf(name);
        }else{
            return -1;
        }

    }

    public boolean removeCompany(int position){

        favCompany.remove(position);
        favLogo.remove(position);
        return true;
    }

    public boolean addCompany(String name, int image){

        if(this.findCompany(name) == -1){
            favCompany.add(name);
            favLogo.add(image);
            return true;
        }else{
            return false;
        }

    }

    public ArrayList getFavCompany(){


        return favCompany;

    }

    public ArrayList getFavLogo(){

        return favLogo;
    }



}
