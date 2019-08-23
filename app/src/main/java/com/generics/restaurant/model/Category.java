package com.generics.restaurant.model;

public class Category extends ServerObject{

    private int id;
    private String name;

    public Category(int id, String name) {
        super(id, name);
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }

    public String getName() { return name; }
}
