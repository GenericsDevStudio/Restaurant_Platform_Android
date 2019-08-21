package com.generics.restaurant.network;

import com.generics.restaurant.model.ServerResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Resources{

    // FIELDS

    private static final Gson gson = new GsonBuilder().create();
    private static final String URL = "https://restaurant-platform-project.herokuapp.com/";
    private static final Retrofit MAIN = new Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
    private static final Link link = MAIN.create(Link.class);

    // METHODS

    private static String toMD5Hash(String toHash){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(toHash.getBytes());
            byte[] digest = md.digest();
            StringBuilder hexString = new StringBuilder();
            for (byte aDigest : digest) {
                String hex = Integer.toHexString(0xFF & aDigest);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        }catch (NoSuchAlgorithmException nsae){
            return null;
        }
    }

    public static void registerUser(String fio, String email, String password, ResponseHandler handler){
        Call<ServerResponse> call = link.registerUser(fio, email, toMD5Hash(password));
        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                handler.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                handler.onFailure(t);
            }
        });
    }

    public static void loginUser(String password, String email, ResponseHandler handler){
        Call<ServerResponse> call = link.loginUser(toMD5Hash(password), email);
        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                handler.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                handler.onFailure(t);
            }
        });
    }

    public static void getCategories(ResponseHandler handler){
        Call<ServerResponse> call = link.getCategories();
        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                handler.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                handler.onFailure(t);
            }
        });
    }

    public static void getDishes(int categoryId, ResponseHandler handler){
        Call<ServerResponse> call = link.getDishes(categoryId);
        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                handler.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                handler.onFailure(t);
            }
        });
    }

    public static void addOrder(String token, String JSONDishesArray, int userId, int restarauntId, ResponseHandler handler){
        Call<ServerResponse> call = link.addOrder(token, JSONDishesArray, userId, restarauntId);
        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                handler.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                handler.onFailure(t);
            }
        });
    }
}
