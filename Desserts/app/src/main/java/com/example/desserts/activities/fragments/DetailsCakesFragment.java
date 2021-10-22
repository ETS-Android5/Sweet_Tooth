package com.example.desserts.activities.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desserts.R;
import com.example.desserts.databinding.FragmentDetailsCakesBinding;
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

        TextView name = (TextView) view.findViewById(R.id.cake_title_details);
        name.setText(title);

        TextView descriptionText = (TextView) view.findViewById(R.id.cake_descrip_details);
        descriptionText.setText(description);

        TextView cost = (TextView) view.findViewById(R.id.cake_price_text);
        cost.setText(price);

        ImageView image = (ImageView) view.findViewById(R.id.cake_image_details);
        String imageName = category + id + "_1";
        int imageId;
        try {
            imageId = R.drawable.class.getField(imageName).getInt(null);
            image.setImageResource(imageId);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
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