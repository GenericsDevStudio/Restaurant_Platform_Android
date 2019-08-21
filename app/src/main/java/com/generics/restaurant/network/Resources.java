package com.generics.restaurant.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Resources {

    private final Gson gson = new GsonBuilder().create();
    private final String URL = "https://restaurant-platform-project.herokuapp.com/";
    private final Retrofit MAIN = new Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();


}
