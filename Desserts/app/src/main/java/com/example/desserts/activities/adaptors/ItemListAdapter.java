package com.example.desserts.activities.adaptors;

import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.example.desserts.R;
import com.example.desserts.activities.DetailsActivity;
import com.example.desserts.activities.ListActivity;
import com.example.desserts.cart.ShoppingCart;
import com.example.desserts.structures.Dessert;
import java.io.Serializable;
import java.util.List;
public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView priceTextView;
        public TextView titleTextView;
        public ImageView imageView;
        public ImageView viewItem;
        public ImageButton addButton;

        public ViewHolder(@NonNull View itemView, String category) {
            super(itemView);

            switch (category)
            {
                case "cake":
                    priceTextView = itemView.findViewById(R.id.cake_price);
                    titleTextView = itemView.findViewById(R.id.cake_mid_title);
                    imageView = itemView.findViewById(R.id.cake_image);
                    viewItem = itemView.findViewById(R.id.imageView);
                    addButton = itemView.findViewById(R.id.cake_add_button);
                    break;
                case "frozen":
                    priceTextView = itemView.findViewById(R.id.frozen_price);
                    titleTextView = itemView.findViewById(R.id.frozen_mid_title);
                    imageView = itemView.findViewById(R.id.frozen_image);
                    viewItem = itemView.findViewById(R.id.imageView);
                    addButton = itemView.findViewById(R.id.frozen_add_button);
                    break;
                case "drinks":
                    priceTextView = itemView.findViewById(R.id.drink_price);
                    titleTextView = itemView.findViewById(R.id.drink_mid_title);
                    imageView = itemView.findViewById(R.id.drink_image);
                    viewItem = itemView.findViewById(R.id.imageView);
                    addButton = itemView.findViewById(R.id.drink_add_button);
                    break;
                default:
                    priceTextView = itemView.findViewById(R.id.cake_price);
                    titleTextView = itemView.findViewById(R.id.cake_mid_title);
                    imageView = itemView.findViewById(R.id.cake_image);
                    viewItem = itemView.findViewById(R.id.imageView);
                    addButton = itemView.findViewById(R.id.cake_add_button);
                    break;
            }
        }

        @Override
        public void onClick(View v) {
        }
    }
    private List<Dessert> items;
    private FragmentActivity context;
    private Dessert currentItem;
    private String category;

    public ItemListAdapter(List<Dessert> items, FragmentActivity c, String category) {
        this.items = items;
        this.context = c;
        this.category = category;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate layout
        View dessertView;
        switch (this.category)
        {
            case "cake":
                dessertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_cake_list_item, parent, false);
                break;
            case "frozen":
                dessertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_frozen_list_item, parent, false);
                break;
            case "drinks":
                dessertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_drink_list_item, parent, false);
                break;
            default:
                dessertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_cake_list_item, parent, false);
                break;
        }

        // Return new holder instance
        ViewHolder viewHolder = new ViewHolder(dessertView, this.category);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListAdapter.ViewHolder holder, int position) {
        currentItem = items.get(position);

        TextView price = holder.priceTextView;
        TextView title = holder.titleTextView;
        ImageView image = holder.imageView;
//        TextView prevTitle = holder.prevTextView;
//        TextView nextTitle = holder.nextTextView;

        String cost = "$" + currentItem.getCost() + "0";
        price.setText(cost);
        price.setTypeface(null, Typeface.BOLD);
        title.setText(currentItem.getName());
        title.setTypeface(null, Typeface.BOLD);

        String imageName = currentItem.getCategory() + currentItem.getId() + "_1";
        int id;
        try {
            id = R.drawable.class.getField(imageName).getInt(null);
            image.setImageResource(id);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        holder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShoppingCart.getInstance().addDessert(items.get(holder.getAdapterPosition()));
            }
        });

        holder.viewItem.setOnClickListener(v -> {
            Intent switchActivityIntent = new Intent(context, DetailsActivity.class);
            items.get(holder.getAdapterPosition()).increaseNumberViewed();
            switchActivityIntent.putExtra("category", items.get(holder.getAdapterPosition()).getCategory());
            switchActivityIntent.putExtra("name", items.get(holder.getAdapterPosition()).getName());
            switchActivityIntent.putExtra("description", items.get(holder.getAdapterPosition()).getDescription());
            switchActivityIntent.putExtra("price", "$" + items.get(holder.getAdapterPosition()).getCost() + "0");
            switchActivityIntent.putExtra("id", "" + items.get(holder.getAdapterPosition()).getId());
            switchActivityIntent.putExtra("dessert", items.get(holder.getAdapterPosition()));
            context.startActivity(switchActivityIntent);
            switch (category) {
                case "drinks":
                    context.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    break;
                case "frozen":
                    context.overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
                    break;
                default:
                    context.overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
            }
        });
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