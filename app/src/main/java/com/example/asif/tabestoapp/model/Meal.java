package com.example.asif.tabestoapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Meal {

    @SerializedName("idMeal")
    @Expose
    private int id;

    @SerializedName("strMeal")
    @Expose
    private String name;

    @SerializedName("strMealThumb")
    @Expose
    private String imageLink;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageLink() {
        return imageLink;
    }
}
