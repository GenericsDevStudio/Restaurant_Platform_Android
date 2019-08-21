package com.generics.restaurant.network;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Link {

    @POST("registration?")
    Call<Response> registerUser(
            @Query("fio") String fio,
            @Query("email") String email,
            @Query("pass") String md5Password
    );

    @POST("login?")
    Call<Response> loginUser(
            @Query("pass") String md5Password,
            @Query("email") String email
    );

    @GET("getCategories")
    Call<Response> getCategories();

    @GET("getDishesByCategory")
    Call<Response> getDishes(
            @Query("categoryId") int categoryId
    );

    @GET("addOrder")
    Call<Response> addOrder(
            @Query("token") String token,
            @Query("dishes") String JSONDishesArray,
            @Query("userId") int userId,
            @Query("restaurantId") int restaurantId
    );
}
