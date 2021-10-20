package com.example.desserts.activities.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desserts.R;
import com.example.desserts.structures.Dessert;

import java.util.List;

public class TopViewedAdapter extends RecyclerView.Adapter<TopViewedAdapter.ViewHolder>{

    // Stores the most viewed desserts
    private List<Dessert> topDesserts;

    /**
     * Initialise the dataset of the Adapter
     *
     * @param desserts List<> containing the data of top viewed desserts
     */
    public TopViewedAdapter (List<Dessert> desserts){
        topDesserts = desserts;
    }

    // Inflate a layout from xml and returns the holder
    @Override
    public TopViewedAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View dessertView = inflater.inflate(R.layout.template_mostviewed, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(dessertView);
        return viewHolder;
    }


    // Populates data into the item through holder
    @Override
    public void onBindViewHolder(TopViewedAdapter.ViewHolder holder, int position) {

        // Get the data model based on position
        Dessert dessert = topDesserts.get(position);

        // Set item views based on your views and data model
//        holder.itemButton.setImageResource(dessert.getName());
    }


    // Return the size of the top viewed desserts in the list
    @Override
    public int getItemCount() {
        return topDesserts.size();
    }


    // Provide a direct reference to each of the views within a dessert item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageButton itemButton;

        public ViewHolder(View itemView){
            super(itemView);

            itemButton = (ImageButton) itemView.findViewById(R.id.mostViewedButton);
        }
    }
}
