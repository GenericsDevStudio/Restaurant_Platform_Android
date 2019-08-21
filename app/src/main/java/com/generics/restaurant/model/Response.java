package com.generics.restaurant.model;

public class Response {
    private int code;
    private String description;
    private String token;
    private Object[] list;

    Response(int code, String description, String token, Object[] list){
        this.code = code;
        this.description = description;
        this.token = token;
        this.list = list;
    }

    public int getCode() { return code; }

    public String getDescription() { return description; }

    public Object[] getList() { return list; }
}
