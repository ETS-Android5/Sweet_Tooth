package com.example.desserts.activities.adaptors;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desserts.R;
import com.example.desserts.activities.DetailsActivity;
import com.example.desserts.activities.ListActivity;
import com.example.desserts.structures.Dessert;

import java.io.Serializable;
import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView priceTextView;
        public TextView titleTextView;
        public ImageView imageView;
        public TextView prevTextView;
        public TextView nextTextView;
//        public ImageView showCardView;
//        public TextView description;
//        private List<Dessert> dessertList;

        public ViewHolder(@NonNull View itemView, List<Dessert> dessertList) {
            super(itemView);

//            this.dessertList = dessertList;

            priceTextView = (TextView) itemView.findViewById(R.id.cake_price);
            titleTextView = (TextView) itemView.findViewById(R.id.cake_mid_title);
            imageView = (ImageView) itemView.findViewById(R.id.cake_image);
            prevTextView = (TextView) itemView.findViewById(R.id.cake_prev_title);
            nextTextView = (TextView) itemView.findViewById(R.id.cake_next_title);
//            showCardView = (ImageView) itemView.findViewById(R.id.imageView);
//            description = (TextView) itemView.findViewById(R.id.cake_descrip_details);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }

    private List<Dessert> items;
    private FragmentActivity context;
    private Dessert currentItem;
//    private ViewHolder viewHolder;
//    private RecyclerView recyclerView;

    public ItemListAdapter(List<Dessert> items, FragmentActivity c) {
        this.items = items;
        this.context = c;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate layout
        View dessertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_cake_list_item, parent, false);
//        recyclerView = (RecyclerView) parent.getRootView();

        // Return new holder instance
        ViewHolder viewHolder = new ViewHolder(dessertView, items);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListAdapter.ViewHolder holder, int position) {
        currentItem = items.get(position);
//        this.viewHolder = holder;

        TextView price = holder.priceTextView;
        TextView title = holder.titleTextView;
        ImageView image = holder.imageView;
        TextView prevTitle = holder.prevTextView;
        TextView nextTitle = holder.nextTextView;

        price.setText("$" + currentItem.getCost());
        title.setText(currentItem.getName());

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
//
//        ItemOnClickListener itemOnClickListener = new ItemOnClickListener()
//
        holder.itemView.setOnClickListener(v -> {
//            int itemPosition = this.recyclerView.getChildLayoutPosition(v);
//            Dessert item = this.items.get(itemPosition);
            Intent switchActivityIntent = new Intent(context, DetailsActivity.class);
            switchActivityIntent.putExtra("category", items.get(holder.getAdapterPosition()).getCategory());
            switchActivityIntent.putExtra("name", items.get(holder.getAdapterPosition()).getName());
            switchActivityIntent.putExtra("description", items.get(holder.getAdapterPosition()).getDescription());
            switchActivityIntent.putExtra("price", "$" + items.get(holder.getAdapterPosition()).getCost());
            switchActivityIntent.putExtra("id", "" + items.get(holder.getAdapterPosition()).getId());
            context.startActivity(switchActivityIntent);
            context.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ItemOnClickListener implements View.OnClickListener {
        private RecyclerView recyclerView;
        private List<Dessert> items;
        private String category;

        public ItemOnClickListener(RecyclerView recyclerView, List<Dessert> items, String category) {
            this.recyclerView = recyclerView;
            this.items = items;
            this.category = category;
        }

        @Override
        public void onClick(View v) {
            int itemPosition = this.recyclerView.getChildLayoutPosition(v);
            Dessert item = this.items.get(itemPosition);
            long id = item.getId();
            Intent switchActivityIntent = new Intent(context, DetailsActivity.class);
            switchActivityIntent.putExtra("category", this.category);
            switchActivityIntent.putExtra("name", item.getName());
            switchActivityIntent.putExtra("description", item.getDescription());
            switchActivityIntent.putExtra("price", "$" + item.getCost());
            switchActivityIntent.putExtra("id", "" + id);
            context.startActivity(switchActivityIntent);
            context.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
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
