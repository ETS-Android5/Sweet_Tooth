package com.example.desserts.activities.fragments;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desserts.R;
import com.example.desserts.activities.MainActivity;
import com.example.desserts.activities.adaptors.ImageGalleryAdapter;
import com.example.desserts.activities.adaptors.ItemListAdapter;
import com.example.desserts.cart.ShoppingCart;
import com.example.desserts.databinding.FragmentDetailsCakesBinding;
import com.example.desserts.helper.Helpers;
import com.example.desserts.structures.Dessert;

import java.util.ArrayList;
import java.util.List;
public class DetailsCakesFragment extends Fragment {
    private FragmentDetailsCakesBinding binding;
    private View view;
    private String name;
    private String category;
    private String description;
    private String cost;
    private String id;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
//        binding = FragmentDetailsCakesBinding.inflate(inflater, container, false);
        view = inflater.inflate(R.layout.fragment_details_cakes, container, false);
        Bundle extras = getActivity().getIntent().getExtras();
        String category = extras.getString("category");
        String title = extras.getString("name");
        String description = extras.getString("description");
        String price = extras.getString("price");
        String id = extras.getString("id");
        Intent intent = getActivity().getIntent();
        Dessert dessert = (Dessert) intent.getSerializableExtra("dessert");
        System.out.println("dessert");
        System.out.println(dessert);

        TextView name = view.findViewById(R.id.cake_title_details);
        name.setText(title);
        name.setTypeface(null, Typeface.BOLD);
        name.setTextSize(16);

        TextView descriptionText = view.findViewById(R.id.cake_descrip_details);
        descriptionText.setText(description);
        descriptionText.setPadding(56,0,48,0);

        TextView cost = view.findViewById(R.id.cake_price_text);
        cost.setText(price);
        cost.setTypeface(null, Typeface.BOLD);

        List<String> images = new ArrayList<>();
        images.add(category + id + "_1");
        images.add(category + id + "_2");
        images.add(category + id + "_3");
        RecyclerView cakeRecyclerView = view.findViewById(R.id.cake_image_details);
        ImageGalleryAdapter imageGalleryAdapter = new ImageGalleryAdapter(images, getActivity());
        cakeRecyclerView.setAdapter(imageGalleryAdapter);
        cakeRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), RecyclerView.HORIZONTAL, false));
        view.findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
                switch (category) {
                    case "drinks":
                        getActivity().overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                        break;
                    case "icecream":
                        getActivity().overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
                        break;
                    default:
                        getActivity().overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
                }
            }
        });
        Button add = view.findViewById(R.id.cake_add_button_details);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Added to cart!", Toast.LENGTH_SHORT).show();
                ShoppingCart.getInstance().addDessert(dessert);
            }
        });
        TextView dietsTitle = view.findViewById(R.id.diets_suitable_for_title);
        TextView diets = view.findViewById(R.id.diets_suitable_for);
        if (dessert.getDietsSuitableFor().isEmpty()){
            dietsTitle.setVisibility(View.INVISIBLE);
            diets.setVisibility(View.INVISIBLE);
        } else {
            String dietsSuitableForWithBrackets =  dessert.getDietsSuitableFor().toString();
            String dietsSuitableFor =  Helpers.capitalizeWords(dietsSuitableForWithBrackets.substring(1, dietsSuitableForWithBrackets.length()-1));
            diets.setText(dietsSuitableFor);
        }

        return view;

    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                NavHostFragment.findNavController(CakesFragment.this)
////                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
//            }
//        });
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    public void populateData(String name, String category, String description, String cost, String id) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.cost = cost;
        this.id = id;
    }
}