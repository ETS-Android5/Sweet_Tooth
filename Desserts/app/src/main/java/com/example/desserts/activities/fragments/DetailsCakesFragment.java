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
        view = inflater.inflate(R.layout.fragment_list_cakes, container, false);

        TextView name = (TextView) view.findViewById(R.id.cake_title_details);
        name.setText(this.name);

        TextView description = (TextView) view.findViewById(R.id.cake_descrip_details);
        description.setText(this.description);

        TextView cost = (TextView) view.findViewById(R.id.cake_price_text);
        cost.setText(this.cost);

        ImageView image = (ImageView) view.findViewById(R.id.cake_image_card_details);
        String imageName = this.category + this.id + "_1";
        int id;
        try {
            id = R.drawable.class.getField(imageName).getInt(null);
            image.setImageResource(id);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        return binding.getRoot();

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