package com.example.desserts.activities.adaptors;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desserts.R;
import com.example.desserts.activities.DetailsActivity;
import com.example.desserts.structures.Dessert;

import java.io.Serializable;
import java.util.List;

public class TopViewedAdapter extends RecyclerView.Adapter<TopViewedAdapter.ViewHolder> {

    private List<Dessert> top5Desserts;
    private FragmentActivity c;
    private List<Dessert> allDesserts;

    public TopViewedAdapter(List<Dessert> desserts, FragmentActivity c, List<Dessert> allDesserts) {
        this.top5Desserts = desserts;
        this.c = c;
        this.allDesserts = allDesserts;
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
        ImageView imageButton = holder.getImageButton();

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

        holder.getImageButton().setOnClickListener(v -> {
            Intent switchActivityIntent = new Intent(c, DetailsActivity.class);
            this.top5Desserts.get(holder.getAdapterPosition()).increaseNumberViewed();
            switchActivityIntent.putExtra("category", this.top5Desserts.get(holder.getAdapterPosition()).getCategory());
            switchActivityIntent.putExtra("name", this.top5Desserts.get(holder.getAdapterPosition()).getName());
            switchActivityIntent.putExtra("description", this.top5Desserts.get(holder.getAdapterPosition()).getDescription());
            switchActivityIntent.putExtra("price", "$" + this.top5Desserts.get(holder.getAdapterPosition()).getCost() + "0");
            switchActivityIntent.putExtra("id", "" + this.top5Desserts.get(holder.getAdapterPosition()).getId());
            switchActivityIntent.putExtra("dessert", this.top5Desserts.get(holder.getAdapterPosition()));
            switchActivityIntent.putExtra("allDesserts", (Serializable) allDesserts);
            c.startActivity(switchActivityIntent);
            c.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });
    }


    @Override
    public int getItemCount() {
        return this.top5Desserts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageButton = (ImageView) itemView.findViewById(R.id.top_viewed_button);

        }

        public ImageView getImageButton() {
            return imageButton;
        }
    }

}