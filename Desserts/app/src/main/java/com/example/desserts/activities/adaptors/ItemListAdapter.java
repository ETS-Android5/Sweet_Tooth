package com.example.desserts.activities.adaptors;

import android.content.ClipData.Item;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desserts.R;
import com.example.desserts.structures.Dessert;

import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView priceTextView;
        public TextView titleTextView;
        public ImageView imageView;
        public TextView prevTextView;
        public TextView nextTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            priceTextView = (TextView) itemView.findViewById(R.id.cake_price);
            titleTextView = (TextView) itemView.findViewById(R.id.cake_mid_title);
            imageView = (ImageView) itemView.findViewById(R.id.cake_image);
            prevTextView = (TextView) itemView.findViewById(R.id.cake_prev_title);
            nextTextView = (TextView) itemView.findViewById(R.id.cake_next_title);
        }
    }

    private List<Dessert> items;
    private String category;

    public ItemListAdapter(List<Dessert> items, String category) {
        this.items = items;
        this.category = category;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate layout
        View dessertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_cakeitem, parent, false);

        // Return new holder instance
        ViewHolder viewHolder = new ViewHolder(dessertView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListAdapter.ViewHolder holder, int position) {
        Dessert currentItem = items.get(position);

        TextView price = holder.priceTextView;
        TextView title = holder.titleTextView;
        ImageView image = holder.imageView;
        TextView prevTitle = holder.prevTextView;
        TextView nextTitle = holder.nextTextView;

        price.setText("$" + currentItem.getCost());
        title.setText(currentItem.getName());

//        this.category + currentItem.getId() + "_1";
        String imageName = this.category + currentItem.getId() + "_1";
        int id;
        try {
            id = R.drawable.class.getField(imageName).getInt(null);
            image.setImageResource(id);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

//        int id = Resources.getSystem().getIdentifier(imageName, "drawable", "android");
//        image.setImageResource(id);
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
