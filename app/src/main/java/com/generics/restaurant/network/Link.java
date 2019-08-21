package com.generics.restaurant.network;

import com.generics.restaurant.model.ServerResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Link {

    @POST("registration?")
    Call<ServerResponse> registerUser(
            @Query("fio") String fio,
            @Query("email") String email,
            @Query("pass") String md5Password
    );

    @POST("login?")
    Call<ServerResponse> loginUser(
            @Query("pass") String md5Password,
            @Query("email") String email
    );

    @GET("getCategories")
    Call<ServerResponse> getCategories();

    @GET("getDishesByCategory")
    Call<ServerResponse> getDishes(
            @Query("categoryId") int categoryId
    );

    @GET("addOrder")
    Call<ServerResponse> addOrder(
            @Query("token") String token,
            @Query("dishes") String JSONDishesArray,
            @Query("userId") int userId,
            @Query("restaurantId") int restaurantId
    );
}
