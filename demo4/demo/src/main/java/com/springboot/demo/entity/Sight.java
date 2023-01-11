package com.springboot.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Optional;

@Document(collection = "Sights")//which collection to store in
public class Sight {
    //to make sure that the item is not blank by annotating it with @NotBlank annotation.
    //creates a unique index on name field.  @Indexed(unique = true)
    private String sightName = "";
    private String zone = "";
    private String category = "";
    private String photoURL = "";
    private String Description = "";
    private String address = "";


    public void setSightName(String sightName) {
        this.sightName = sightName;
    }

    public String getSightName() {
        return sightName;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getZone() {
        return zone;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDescription() {
        return Description;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "SightName: " + sightName + "\nZone: " + zone +
                "\nCategory: " + category + "\nPhotoURL: " + photoURL +
                "\nDescription: " + Description + "\nAddress: " + address + "\n";
    }
}
