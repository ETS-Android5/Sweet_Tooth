package com.example.desserts.activities;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;
import com.example.desserts.R;
import com.example.desserts.activities.adaptors.ShoppingCartAdaptor;
import com.example.desserts.activities.fragments.CakesFragment;
import com.example.desserts.activities.fragments.DetailsCakesFragment;
import com.example.desserts.activities.fragments.DrinksFragment;
import com.example.desserts.activities.fragments.FrozenFragment;
import com.example.desserts.cart.ShoppingCart;
import com.example.desserts.databinding.ActivityDetailsBinding;
import com.example.desserts.structures.Dessert;
import java.util.List;
public class DetailsActivity extends AppCompatActivity {
    private AppBarConfiguration appBarConfiguration;
    private ActivityDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Set up the custom toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Dynamically load the fragment
        Bundle extras = getIntent().getExtras();
        String category = extras.getString("category");
        String name = extras.getString("name");
        String description = extras.getString("description");
        String cost = extras.getString("price");
        String id = extras.getString("id");
        if (category != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            DetailsCakesFragment cF = new DetailsCakesFragment();
//                    cF.populateData(name, category, description, cost, id);
            ft.replace(R.id.details_fragment_placeholder, cF);
//            switch (category) {
//                case "cake":
//                    DetailsCakesFragment cF = new DetailsCakesFragment();
////                    cF.populateData(name, category, description, cost, id);
//                    ft.replace(R.id.details_fragment_placeholder, cF);
//                    break;
//                case "drinks":
//                    ft.replace(R.id.details_fragment_placeholder, new DrinksFragment());
//                    break;
//                case "frozen":
//                    ft.replace(R.id.details_fragment_placeholder, new FrozenFragment());
//                    break;
//            }
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
                Toast.makeText(DetailsActivity.this, "query submit", Toast.LENGTH_SHORT).show();
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
                    drawer.openDrawer(GravityCompat.END);
                }
                return true;
            case R.id.action_search:
                Toast.makeText(DetailsActivity.this, "searching", Toast.LENGTH_SHORT).show();
                return true;
            case android.R.id.home:
//                onBackPressed();
                NavUtils.navigateUpFromSameTask(this);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}