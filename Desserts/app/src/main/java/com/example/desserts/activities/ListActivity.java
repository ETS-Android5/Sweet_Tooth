package com.example.desserts.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.desserts.R;
import com.example.desserts.activities.adaptors.ShoppingCartAdaptor;
import com.example.desserts.activities.fragments.CakesFragment;
import com.example.desserts.activities.fragments.DrinksFragment;
import com.example.desserts.activities.fragments.FrozenFragment;
import com.example.desserts.cart.ShoppingCart;
import com.example.desserts.databinding.ActivityListBinding;
import com.example.desserts.structures.Dessert;
import com.google.android.material.navigation.NavigationView;

import androidx.core.app.NavUtils;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.List;

public class ListActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Set up the custom toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        TextView noResults = findViewById(R.id.no_results);

        // Dynamically load the fragment
        Bundle extras = getIntent().getExtras();
        String category = extras.getString("category");
        Intent intent = getIntent();
        List<Dessert> cakes = (List<Dessert>) intent.getSerializableExtra("cakes");
        List<Dessert> frozen = (List<Dessert>) intent.getSerializableExtra("frozen");
        List<Dessert> drinks = (List<Dessert>) intent.getSerializableExtra("drinks");
        List<Dessert> searchResults = (List<Dessert>) intent.getSerializableExtra("searchResults");
        if (category != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            switch (category) {
                case "cakes":
                    if (!cakes.isEmpty()) {
                        noResults.setVisibility(View.GONE);
                    }
                    CakesFragment cF = new CakesFragment();
                    cF.populateCakes(cakes);
                    ft.replace(R.id.list_fragment_placeholder, cF);
                    break;
                case "drinks":
                    if (!drinks.isEmpty()) {
                        noResults.setVisibility(View.GONE);
                    }
                    //---------Uncomment after implementation
                    DrinksFragment dF = new DrinksFragment();
                    dF.populateCakes(drinks);
                    ft.replace(R.id.list_fragment_placeholder, dF);
//                    CakesFragment dF = new CakesFragment();
//                    dF.populateCakes(drinks);
//                    ft.replace(R.id.list_fragment_placeholder, dF);
                    break;
                case "frozen":
                    if (!frozen.isEmpty()) {
                        noResults.setVisibility(View.GONE);
                    }
                    //---------Uncomment after implementation
                    FrozenFragment fF = new FrozenFragment();
                    fF.populateCakes(frozen);
                    ft.replace(R.id.list_fragment_placeholder, fF);
//                    CakesFragment fF = new CakesFragment();
//                    fF.populateCakes(frozen);
//                    ft.replace(R.id.list_fragment_placeholder, fF);
                    break;
                case "searchResults":
                    if (!searchResults.isEmpty()) {
                        noResults.setVisibility(View.GONE);
                    }
                    CakesFragment sRF = new CakesFragment();
                    sRF.populateCakes(searchResults);
                    ft.replace(R.id.list_fragment_placeholder, sRF);
                    break;
            }
            ft.commit();
        }
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
                Toast.makeText(ListActivity.this, "query submit", Toast.LENGTH_SHORT).show();
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
                    cost.setText("Total cost: $"+ ShoppingCart.getInstance().getTotalCost());
                    NavigationView navigation = findViewById(R.id.nav_view);
                    navigation.bringToFront();
                    drawer.openDrawer(GravityCompat.END);
                }
                return true;
            case R.id.action_search:
                Toast.makeText(ListActivity.this, "searching", Toast.LENGTH_SHORT).show();
                return true;
            case android.R.id.home:
                onBackPressed();
//                NavUtils.navigateUpFromSameTask(this);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}