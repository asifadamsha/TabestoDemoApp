package com.example.asif.tabestoapp.Activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.asif.tabestoapp.API.Client;
import com.example.asif.tabestoapp.API.MealsService;
import com.example.asif.tabestoapp.Adapters.MealAdapter;
import com.example.asif.tabestoapp.R;
import com.example.asif.tabestoapp.model.Meal;
import com.example.asif.tabestoapp.model.Restaurant;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView mealListView;
    private MealsService mealsService;
    private MealAdapter mealAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mealListView = findViewById(R.id.mealListView);


        mealsService = Client.getClient().create(MealsService.class);

        mealsService.getMeals().enqueue(new Callback<Restaurant>() {
            @Override
            public void onResponse(Call<Restaurant> call, Response<Restaurant> response) {
                if (response.isSuccessful()) {

                    List<Meal> meals = response.body().getMeals();

                    if(meals != null && meals.size() > 0){
                        mealAdapter = new MealAdapter(getBaseContext(), meals);
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        mealListView.setLayoutManager(mLayoutManager);
                        mealListView.setItemAnimator(new DefaultItemAnimator());
                        mealListView.setAdapter(mealAdapter);
                    }

                } else {

                    Log.i(TAG, "error code : " + response.code());

                }
            }

            @Override
            public void onFailure(Call<Restaurant> call, Throwable t) {
                Log.i(TAG, "on fail : " + t.getMessage());
            }
        });

    }
}
