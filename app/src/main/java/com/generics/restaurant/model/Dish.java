package com.generics.restaurant.model;

public class Dish {

    private int id;
    private int categoryId;
    private String name;
    private String description;
    private double price;

    Dish(int id, int categoryId, String name, String description, double price){
       this.id = id;
       this.categoryId = categoryId;
       this.name = name;
       this.description = description;
       this. price = price;
    }

    public int getId() { return id; }

    public int getCategoryId() { return categoryId; }

    public String getName() { return name; }

    public String getDescription() { return description; }

    public double getPrice() { return price; }
}
