package com.schoolcasa.model;

import javax.persistence.*;

@Entity
@Table
public class ItemListing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String productName;
    private double price;
    private String address;
    private String description;
    private String imageurl;
    private String category;
    private String age;
    private String warranty;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public ItemListing setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public ItemListing setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ItemListing setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemListing setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageURL() {
        return imageurl;
    }

    public ItemListing setImageURL(String imageurl) {
        this.imageurl = imageurl;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ItemListing setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getAge() {
        return age;
    }

    public ItemListing setAge(String age) {
        this.age = age;
        return this;
    }

    public String getWarranty() {
        return warranty;
    }

    public ItemListing setWarranty(String warranty) {
        this.warranty = warranty;
        return this;
    }


}
