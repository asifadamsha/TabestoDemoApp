package com.example.asif.tabestoapp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asif.tabestoapp.R;
import com.example.asif.tabestoapp.model.Meal;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.MyViewHolder> {

    private List<Meal> meals;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mealInfoText;
        public ImageView mealImage;

        public MyViewHolder(View view) {
            super(view);
            mealInfoText = view.findViewById(R.id.textViewMealInfo);
            mealImage = view.findViewById(R.id.mealImageView);
        }
    }

    public MealAdapter(Context context, List<Meal> meals) {
        this.context = context;
        this.meals = meals;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.meal_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Meal meal = meals.get(position);

        String mealInfoText = meal.getName() + " - "+ getRandomPrice()+" €";

        holder.mealInfoText.setText(mealInfoText);

        Picasso.with(context)
                .load(meal.getImageLink())
                .fit()
                .centerInside()
                .into(holder.mealImage);
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    private int getRandomPrice(){
        Random r = new Random();
        int valeur = 1 + r.nextInt(20 - 1);
        return valeur;
    }

}