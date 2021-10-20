package com.example.desserts.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.desserts.R;
import com.example.desserts.database.DBLoader;
import com.example.desserts.databinding.ActivityMainBinding;
import com.example.desserts.helper.Helpers;
import com.example.desserts.structures.Dessert;

import java.util.ArrayList;
import java.util.List;

public class SplashScreen extends AppCompatActivity {

    private ActivityMainBinding binding;

    private List<Dessert> cakes = DBLoader.getAllCakes();
    private List<Dessert> icecream = DBLoader.getAllIceCreams();
    private List<Dessert> tea = DBLoader.getAllTeas();
    private List<Dessert> coffee = DBLoader.getAllCoffees();
    private List<Dessert> allDessertsList;
    private List<Dessert> topDesserts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        allDessertsList = new ArrayList<>();
        topDesserts = new ArrayList<>();

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // get the top 5 most viewed desserts list
        createAllDessertsList();
        topDesserts = Helpers.top5(allDessertsList);

        ImageButton splashButton = findViewById(R.id.splash_button);
        splashButton.setOnClickListener(v -> {
            Toast.makeText(SplashScreen.this, "Main screen loading...", Toast.LENGTH_SHORT).show();
            switchToMainActivity();
        });
    }

    public void createAllDessertsList(){
        allDessertsList.addAll(cakes);
        allDessertsList.addAll(icecream);
        allDessertsList.addAll(tea);
        allDessertsList.addAll(coffee);
    }

    private void switchToMainActivity() {
        Intent switchActivityIntent = new Intent(this, Main.class);
        switchActivityIntent.putExtra("main", (Parcelable) topDesserts);
        startActivity(switchActivityIntent);
    }

}
