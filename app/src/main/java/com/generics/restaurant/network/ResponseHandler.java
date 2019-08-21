package com.generics.restaurant.network;
import com.generics.restaurant.model.ServerResponse;


public interface ResponseHandler {
    void onResponse(ServerResponse response);
    void onFailure(Throwable t);
}
