package com.schoolcasa.model;

import javax.persistence.*;

@Entity
@Table
public class ApartmentListing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int bedrooms;
    private int bathrooms;
    private double rent;
    private String address;
    private String description;
    @Column(columnDefinition = "tinyint(1) default 0")
    private boolean isParkingAvailable;
    @Column(columnDefinition = "tinyint(1) default 0")
    private boolean isDeleted;
    private String imageURL;

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }


    public boolean isParkingAvailable() {
        return isParkingAvailable;
    }

    public void setParkingAvailable(boolean parkingAvailable) {
        isParkingAvailable = parkingAvailable;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
