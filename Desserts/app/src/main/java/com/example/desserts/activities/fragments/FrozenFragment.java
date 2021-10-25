package com.example.desserts.activities.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desserts.R;
import com.example.desserts.activities.adaptors.ItemListAdapter;
import com.example.desserts.databinding.FragmentListCakesBinding;
import com.example.desserts.structures.Dessert;

import java.util.ArrayList;
import java.util.List;

/**
 * FrozenFragment it dynamically creates each frozen item in the Frozen category list.
 *
 * @author Amy Lyu
 * @author Osama Kashif
 */
public class FrozenFragment extends Fragment {

    private FragmentListCakesBinding binding;
    private View view;
    private List<Dessert> frozenList = new ArrayList<>();
    private List<Dessert> allDesserts = new ArrayList<>();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        view = inflater.inflate(R.layout.fragment_list_frozen, container, false);
        RecyclerView frozenRecyclerView = (RecyclerView) view.findViewById(R.id.frozen_listview);
        ItemListAdapter itemListAdapter = new ItemListAdapter(frozenList, getActivity(), "frozen", allDesserts);
        frozenRecyclerView.setAdapter(itemListAdapter);
        frozenRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), RecyclerView.HORIZONTAL, false));

        return view;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void populate(List<Dessert> frozen) {
        frozenList = frozen;
    }

    public void populateAllDesserts(List<Dessert> allDesserts) {
        this.allDesserts = allDesserts;
    }

}