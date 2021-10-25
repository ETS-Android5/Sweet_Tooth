package com.example.desserts.activities.adaptors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desserts.R;

import java.util.List;

/**
 * ImageGalleryAdapter is used to populate the Recycler View to showcase each item's images in the
 * DetailsActivity.
 *
 * @author Amy Lyu
 */
public class ImageGalleryAdapter extends RecyclerView.Adapter<ImageGalleryAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.details_image);
        }

        @Override
        public void onClick(View v) {

        }
    }

    private List<String> items;
    private String currentImageName;

    public ImageGalleryAdapter(List<String> items, FragmentActivity c) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate layout
        View dessertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_image_gallery, parent, false);

        // Return new holder instance
        ViewHolder viewHolder = new ViewHolder(dessertView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageGalleryAdapter.ViewHolder holder, int position) {
        currentImageName = items.get(position);

        ImageView image = holder.imageView;

        int id;
        try {
            id = R.drawable.class.getField(currentImageName).getInt(null);
            image.setImageResource(id);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

}