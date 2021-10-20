package com.example.desserts.activities.adaptors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desserts.R;
import com.example.desserts.structures.Dessert;

import java.util.List;

public class TopViewedAdapter extends RecyclerView.Adapter<TopViewedAdapter.ViewHolder> {

    private List<Dessert> top5Desserts;

    public TopViewedAdapter(List<Dessert> desserts) {
        this.top5Desserts = desserts;
    }

    @NonNull
    @Override
    public TopViewedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate layout
        View dessertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_topvieweditem, parent, false);

        // Return new holder instance
        TopViewedAdapter.ViewHolder viewHolder = new TopViewedAdapter.ViewHolder(dessertView);
        return viewHolder;
    }

    // Populates data into the item through holder
    @Override
    public void onBindViewHolder(TopViewedAdapter.ViewHolder holder, int position) {

        Dessert currentItem = top5Desserts.get(position);
        ImageView imageButton = holder.imageButton;

        String imageName = currentItem.getCategory() + currentItem.getId() + "_1";
        int id;
        try {
            id = R.drawable.class.getField(imageName).getInt(null);
            imageButton.setImageResource(id);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }


    @Override
    public int getItemCount() {
        return this.top5Desserts.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageButton = (ImageView) itemView.findViewById(R.id.top_viewed_button);

        }


    }

}
