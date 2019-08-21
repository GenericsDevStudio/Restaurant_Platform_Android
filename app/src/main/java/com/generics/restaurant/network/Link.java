package com.generics.restaurant.network;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.POST;

public interface Link {
    @POST("registration?")
    Call<Response> registerUser(

    );
}
