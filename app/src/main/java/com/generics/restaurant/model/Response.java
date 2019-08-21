package com.generics.restaurant.model;

public class Response {
    private int code;
    private String description;
    private String token;
    // FOR DISHES & CATEGORIES :
    private Object[] list;
    // FOR USERS :
    private int id;

    Response(int code, String description, String token, Object[] list){
        this.code = code;
        this.description = description;
        this.token = token;
        this.list = list;
    }

    Response(int code, String description, String token, int id){
        this.code = code;
        this.description = description;
        this.token = token;
        this.id = id;
    }

    Response(int code, String description, String token){
        this.code = code;
        this.description = description;
        this.token = token;
    }


    public int getCode() { return code; }

    public String getDescription() { return description; }

    public Object[] getList() { return list; }

    public int getId() { return id; }
}
