package com.example.desserts.activities;

import android.content.Intent;
import android.os.Bundle;

import com.example.desserts.R;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.app.NavUtils;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desserts.activities.adaptors.ShoppingCartAdaptor;
import com.example.desserts.activities.adaptors.TopViewedAdapter;
import com.example.desserts.cart.ShoppingCart;
import com.example.desserts.database.DBLoader;
import com.example.desserts.databinding.ActivityMainBinding;
import com.example.desserts.helper.Helpers;
import com.example.desserts.structures.Dessert;
import com.google.android.material.navigation.NavigationView;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private String selectedCategory;
    private List<Dessert> cakes = new ArrayList<>();
    private List<Dessert> iceCream = new ArrayList<>();
    private List<Dessert> teas = new ArrayList<>();
    private List<Dessert> coffees = new ArrayList<>();
    private SearchView mSearchView;
    private List<Dessert> allDesserts = new ArrayList<>();
    private List<Dessert> frozen = new ArrayList<>();
    private List<Dessert> drinks = new ArrayList<>();
    private List<Dessert> searchResults = new ArrayList<>();
    private TopViewedAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Intent intent = getIntent();
        cakes = (List<Dessert>) intent.getSerializableExtra("cakes");
        iceCream = (List<Dessert>) intent.getSerializableExtra("iceCream");
        teas = (List<Dessert>) intent.getSerializableExtra("teas");
        coffees = (List<Dessert>) intent.getSerializableExtra("coffees");

        frozen = iceCream;
        drinks.addAll(teas);
        drinks.addAll(coffees);
        allDesserts.addAll(cakes);
        allDesserts.addAll(frozen);
        allDesserts.addAll(drinks);

        // Set up the custom toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Dynamically set up the top 5 most viewed items
        RecyclerView recyclerView = findViewById(R.id.topViewedDesserts);
        adapter = new TopViewedAdapter(Helpers.top5(allDesserts), this, allDesserts);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
//        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        // Category buttons
        CardView cakesListButton = findViewById(R.id.button_cakes);
        cakesListButton.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Cakes list loading...", Toast.LENGTH_SHORT).show();
            selectedCategory = "cakes";
            switchToListActivity();
        });

        CardView drinksListButton = findViewById(R.id.button_drinks);
        drinksListButton.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Drinks list loading...", Toast.LENGTH_SHORT).show();
            selectedCategory = "drinks";
            switchToListActivity();
        });

        CardView frozenListButton = findViewById(R.id.button_frozen);
        frozenListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Frozen list loading...", Toast.LENGTH_SHORT).show();
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
        mSearchView = (SearchView) mSearch.getActionView();
        mSearchView.setQueryHint("Search");
        mSearchView.setMaxWidth(750);
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, "query submit", Toast.LENGTH_SHORT).show();
                String searchQuery = mSearchView.getQuery().toString();
                searchResults = Helpers.search(allDesserts,searchQuery);
                selectedCategory = "searchResults";
                switchToListActivity();
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
                    ShoppingCartAdaptor sA = new ShoppingCartAdaptor(this, R.layout.template_image_gallery);
                    ListView lV = findViewById(R.id.shopping_cart);
                    lV.setAdapter(sA);
                    TextView cost = findViewById(R.id.total_cost);
                    new Thread() {
                        public void run() {
                            while (true) {
                                try {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            cost.setText("Total cost: $"+ ShoppingCart.getInstance().getTotalCost()+"0");
                                        }
                                    });
                                    Thread.sleep(300);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }.start();
                    Button confirm = findViewById(R.id.confirm_order);
                    confirm.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ShoppingCart.getInstance().confirmOrder();
                            sA.notifyDataSetChanged();
                            Toast.makeText(MainActivity.this, "Your order has been confirmed!", Toast.LENGTH_LONG).show();
                        }
                    });
                    NavigationView navigation = findViewById(R.id.nav_view);
                    navigation.bringToFront();
                    drawer.openDrawer(GravityCompat.END);
                }
                return true;
            case R.id.action_search:
                Toast.makeText(MainActivity.this, "searching", Toast.LENGTH_SHORT).show();
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
        switchActivityIntent.putExtra("cakes", (Serializable) cakes);
        switchActivityIntent.putExtra("frozen", (Serializable) frozen);
        switchActivityIntent.putExtra("drinks", (Serializable) drinks);
        switchActivityIntent.putExtra("searchResults", (Serializable) searchResults);
        switchActivityIntent.putExtra("allDesserts", (Serializable) allDesserts);
        startActivity(switchActivityIntent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}