package com.example.desserts.activities;

import android.content.Intent;
import android.os.Bundle;

import com.example.desserts.R;
import com.example.desserts.database.DBLoader;
import com.example.desserts.structures.Dessert;

import java.io.Serializable;
import java.util.List;


import android.app.Activity;
import android.os.Handler;

/**
 * SplashScreen for initial loading.
 *
 * @author Osama Kashif
 */
public class SplashScreen extends Activity {

    private List<Dessert> cakes = DBLoader.getAllCakes();
    private List<Dessert> iceCream = DBLoader.getAllIceCreams();
    private List<Dessert> teas = DBLoader.getAllTeas();
    private List<Dessert> coffees = DBLoader.getAllCoffees();

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashfile);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                switchToMainActivity();
                finish();
            }
        }, 3000);

    }

    private void switchToMainActivity() {
        Intent switchActivityIntent = new Intent(this, MainActivity.class);
        switchActivityIntent.putExtra("cakes", (Serializable) cakes);
        switchActivityIntent.putExtra("iceCream", (Serializable) iceCream);
        switchActivityIntent.putExtra("teas", (Serializable) teas);
        switchActivityIntent.putExtra("coffees", (Serializable) coffees);
        startActivity(switchActivityIntent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
