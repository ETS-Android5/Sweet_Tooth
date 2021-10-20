package com.example.desserts.activities;

import android.content.Intent;
import android.os.Bundle;

import com.example.desserts.R;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desserts.activities.adapters.TopViewedAdapter;
import com.example.desserts.database.DBLoader;
import com.example.desserts.databinding.ActivityMainBinding;
import com.example.desserts.structures.Dessert;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.List;

public class Main extends AppCompatActivity {

//        private AppBarConfiguration appBarConfiguration;
        private ActivityMainBinding binding;
        private String selectedCategory;

        private TopViewedAdapter adapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = ActivityMainBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());

            // Set up the custom toolbar
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setDisplayShowHomeEnabled(true);


            // Set up recyclerview showing the most top viewed items
//            RecyclerView rvDesserts = (RecyclerView) findViewById(R.id.topViewedDesserts);
            // get the top 5 most viewed desserts list (replace)
//            List<Dessert> desserts = DBLoader.getAllCake();

            // desserts = top 5 items list
//            adapter = new TopViewedAdapter(desserts);
//            rvDesserts.setAdapter(adapter);


            // Category buttons
            ImageButton cakesListButton = findViewById(R.id.button_cakes);
            cakesListButton.setOnClickListener(v -> {
                Toast.makeText(Main.this, "Cakes list loading...", Toast.LENGTH_SHORT).show();
                selectedCategory = "cakes";
                switchToListActivity();
            });

            ImageButton drinksListButton = findViewById(R.id.button_drinks);
            drinksListButton.setOnClickListener(v -> {
                Toast.makeText(Main.this, "Drinks list loading...", Toast.LENGTH_SHORT).show();
                selectedCategory = "drinks";
                switchToListActivity();
            });

            ImageButton frozenListButton = findViewById(R.id.button_frozen);
            frozenListButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Main.this, "Frozen list loading...", Toast.LENGTH_SHORT).show();
                    selectedCategory = "frozen";
                    switchToListActivity();
                }
            });
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.activity_menu, menu);
            MenuItem mSearch = menu.findItem(R.id.action_search);
            SearchView mSearchView = (SearchView) mSearch.getActionView();
            mSearchView.setQueryHint("Search");
            mSearchView.setMaxWidth(750);
            mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    Toast.makeText(Main.this, "query submit", Toast.LENGTH_SHORT).show();
                    return true;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });
            return super.onCreateOptionsMenu(menu);
        }


        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            switch (item.getItemId()) {
                case R.id.action_cart:
                    if (drawer.isDrawerOpen(GravityCompat.END)) {
                        drawer.closeDrawer(GravityCompat.END);
                    } else {
                        drawer.openDrawer(GravityCompat.END);
                    }
                    return true;
                case R.id.action_search:
                    Toast.makeText(Main.this, "searching", Toast.LENGTH_SHORT).show();
                    return true;
                case android.R.id.home:
                    NavUtils.navigateUpFromSameTask(this);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                    return true;
            }
            return super.onOptionsItemSelected(item);
        }


        private void switchToListActivity() {
            Intent switchActivityIntent = new Intent(this, ListActivity.class);
            switchActivityIntent.putExtra("category", selectedCategory);
            startActivity(switchActivityIntent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }

}
