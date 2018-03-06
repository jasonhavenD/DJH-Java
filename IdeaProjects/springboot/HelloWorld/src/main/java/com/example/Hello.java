package com.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Jasonhaven.Dai on2018/3/5.
 **/
public class Hello {
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("Bill.Yang");
        p.setAge(30);

        Gson gson = new GsonBuilder().create();
        String pJson = gson.toJson(p);
        System.out.println("Hello," + pJson);
    }
}
