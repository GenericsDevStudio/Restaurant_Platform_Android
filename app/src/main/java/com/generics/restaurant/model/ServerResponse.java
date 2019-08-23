package com.generics.restaurant.model;

public class ServerResponse {

    // VARIABLES CAN BE NULL, BE CAREFUL

    private int code;
    private String description;
    private String token;
    // FOR DISHES & CATEGORIES :
    private ServerObject[] list;
    // FOR USERS :
    private int id;

    ServerResponse(int code, String description, String token, ServerObject[] list){
        this.code = code;
        this.description = description;
        this.list = list;
    }

    ServerResponse(int code, String description, String token){
        this.code = code;
        this.description = description;
        this.token = token;
    }

    ServerResponse(int code, String description){
        this.code = code;
        this.description = description;
    }

    public int getCode() { return code; }

    public String getDescription() { return description; }

    public ServerObject[] getList() { return list; }

    public int getId() { return id; }

}
