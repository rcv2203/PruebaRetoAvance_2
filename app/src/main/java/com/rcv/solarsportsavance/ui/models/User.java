package com.rcv.solarsportsavance.ui.models;

import android.app.Application;
import android.util.Log;

import com.google.gson.Gson;

public class User extends Application {
    private static User user;

    public String id;
    public String name;
    public String surName;
    public String email;
    public Long phone;
    public String password;


    public User() {
        this.name = "";
        this.surName = "";
        this.email = "";
        this.phone = 0L;
        this.password = "";


    }

    public User(String id, String name, String surName, String email, Long phone, String password) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.phone = phone;
        this.password = password;

    }


    public String objetcToJSON (){

        String jsonData = new Gson().toJson(this);
        Log.e("msg", "User to json: " + jsonData);

        return jsonData;

    }

}
