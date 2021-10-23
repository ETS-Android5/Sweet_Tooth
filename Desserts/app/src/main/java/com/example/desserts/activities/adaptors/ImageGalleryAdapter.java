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
    private FragmentActivity context;
    private String currentImageName;

    public ImageGalleryAdapter(List<String> items, FragmentActivity c) {
        this.items = items;
//        this.context = c;
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


//  LISTVIEW ADAPTER
//    private int resourceLayout;
//    private Context mContext;
//    private String category;
//    private List<Dessert> items;

//    public ItemListAdapter(@NonNull Context context, int resource, @NonNull List<Dessert> items) {
//        super(context, resource, items);
//        this.resourceLayout = resource;
//        this.mContext = context;
//        this.items = items;
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable  View convertView, @NonNull ViewGroup parent) {
//        View v = convertView;
//
//        if (v == null) {
//            LayoutInflater vi;
//            vi = LayoutInflater.from(mContext);
//            v = vi.inflate(resourceLayout, null);
//        }
//
//        Dessert p = getItem(position);
//        if (p != null) {
//            TextView price = (TextView) v.findViewById(R.id.cake_price);
//            TextView title = (TextView) v.findViewById(R.id.cake_mid_title);
//            ImageView image = (ImageView) v.findViewById(R.id.cake_image);
//            TextView prevTitle = (TextView) v.findViewById(R.id.cake_prev_title);
//            TextView nextTitle = (TextView) v.findViewById(R.id.cake_next_title);
//            price.setText("$$" + p.getCost());
//            title.setText(p.getName());
//
//            String imageName = this.category + p.getId() + "_1";
//            Resources resources = mContext.getResources();
//            final int imageResourceId = resources.getIdentifier(imageName, "drawable", mContext.getOpPackageName());
//            image.setImageResource(imageResourceId);
//    }
//
//        return v;
//    }
//
//    @Override
//    public int getCount() {
//        return this.items.size();
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
}
