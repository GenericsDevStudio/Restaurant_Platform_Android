package com.generics.restaurant.model;

public class ServerObject {

    private int id;
    private int categoryId;
    private String name;
    private String description;
    private double price;

    public ServerObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ServerObject(int id, int categoryId, String name, String description, double price) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public String getDescription() { return description; }

    public double getPrice() { return price; }

    public int getCategoryId() { return categoryId; }

    public static Dish toDish(ServerObject object){
        return new Dish(object.getId(), object.getCategoryId(), object.getName(),
                object.getDescription(), object.getPrice());
    }

    public static Category toCategory(ServerObject object){
        return new Category(object.getId(), object.getName());
    }
}
