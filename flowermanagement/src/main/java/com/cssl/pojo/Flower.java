package com.cssl.pojo;

public class Flower {
    int id;
    String name;
    String authorName;
    String property;
    Double price;
    String production;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public Flower() {
    }

    public Flower(int id, String name, String authorName, String property, Double price, String production) {
        this.id = id;
        this.name = name;
        this.authorName = authorName;
        this.property = property;
        this.price = price;
        this.production = production;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authorName='" + authorName + '\'' +
                ", property='" + property + '\'' +
                ", price=" + price +
                ", production='" + production + '\'' +
                '}';
    }
}
