package com.example.asif.tabestoapp.API;

import com.example.asif.tabestoapp.model.Meal;
import com.example.asif.tabestoapp.model.Restaurant;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MealsService {

    @GET("1/latest.php")
    Call<Restaurant> getMeals();

}
