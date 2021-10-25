package com.example.desserts.activities.adaptors;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.desserts.R;
import com.example.desserts.cart.ShoppingCart;
import com.example.desserts.structures.Dessert;

/**
 * ShoppingCartAdaptor is used to populate the List View inside the shopping cart drawer.
 * @author Amy Lyu
 * @author Osama Kashif
 */
public class ShoppingCartAdaptor  extends ArrayAdapter<Dessert> {

    private Context mContext;


    public ShoppingCartAdaptor(@NonNull Context context, int resource) {
        super(context, resource, ShoppingCart.getInstance().getAllDessertsInCart());
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
            ImageView image = (ImageView) v.findViewById(R.id.details_image);

            String imageName = p.getCategory() + p.getId() + "_1";
            Resources resources = mContext.getResources();
            final int imageResourceId = resources.getIdentifier(imageName, "drawable", mContext.getOpPackageName());
            image.setImageResource(imageResourceId);

            ImageButton close = v.findViewById(R.id.remove_from_cart);
            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ShoppingCart.getInstance().removeDessert(p);
                    notifyDataSetChanged();
                }
            });
    }

        return v;
    }

    @Override
    public int getCount() {
        return ShoppingCart.getInstance().getAllDessertsInCart().size();
    }

}
