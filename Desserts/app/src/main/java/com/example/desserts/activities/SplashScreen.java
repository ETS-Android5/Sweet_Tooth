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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SplashScreen extends AppCompatActivity {

    private ActivityMainBinding binding;

    private List<Dessert> cakes = DBLoader.getAllCakes();
    private List<Dessert> icecream = DBLoader.getAllIceCreams();
    private List<Dessert> tea = DBLoader.getAllTeas();
    private List<Dessert> coffee = DBLoader.getAllCoffees();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ImageButton splashButton = findViewById(R.id.splash_button);
        splashButton.setOnClickListener(v -> {
            Toast.makeText(SplashScreen.this, "Main screen loading...", Toast.LENGTH_SHORT).show();
            switchToMainActivity();
        });
    }

    private void switchToMainActivity() {
        Intent switchActivityIntent = new Intent(this, Main.class);
        switchActivityIntent.putExtra("cake", (Serializable) cakes);
        switchActivityIntent.putExtra("cake", (Serializable) icecream);
        switchActivityIntent.putExtra("cake", (Serializable) tea);
        switchActivityIntent.putExtra("cake", (Serializable) coffee);
        startActivity(switchActivityIntent);
    }

}
