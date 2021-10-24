package com.example.desserts.activities.adaptors;

import android.content.ClipData;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desserts.R;
import com.example.desserts.cart.ShoppingCart;
import com.example.desserts.structures.Dessert;

import java.util.Collections;
import java.util.List;

public class ShoppingCartAdaptor  extends ArrayAdapter<Dessert> {

    private int resourceLayout;
    private Context mContext;
    private String category;


    public ShoppingCartAdaptor(@NonNull Context context, int resource) {
        super(context, resource, ShoppingCart.getInstance().getAllDessertsInCart());
        this.resourceLayout = resource;
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(mContext);
            v = vi.inflate(R.layout.template_cart_gallery, null);
        }

        Dessert p = getItem(position);
        if (p != null) {
//            TextView price = (TextView) v.findViewById(R.id.cake_price);
//            TextView title = (TextView) v.findViewById(R.id.cake_mid_title);
            ImageView image = (ImageView) v.findViewById(R.id.details_image);
//            price.setText("$" + p.getCost());
//            title.setText(p.getName());

            String imageName = p.getCategory() + p.getId() + "_1";
            Resources resources = mContext.getResources();
            final int imageResourceId = resources.getIdentifier(imageName, "drawable", mContext.getOpPackageName());
            image.setImageResource(imageResourceId);
    }

        return v;
    }

    @Override
    public int getCount() {
        return ShoppingCart.getInstance().getAllDessertsInCart().size();
    }

}