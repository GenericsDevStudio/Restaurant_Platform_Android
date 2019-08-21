package com.generics.restaurant.model;

public class User {

    private int id;
    private String fio;
    private String email;
    private String password;
    private String token;

    public User(int id, String fio, String email, String password, String token) {
        this.id = id;
        this.fio = fio;
        this.email = email;
        this.password = password;
        this.token = token;
    }

    public String getToken() { return token; }
}
