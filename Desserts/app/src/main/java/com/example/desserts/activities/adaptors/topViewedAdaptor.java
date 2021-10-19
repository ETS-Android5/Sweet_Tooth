package com.example.desserts.activities.adaptors;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;


public class topViewedAdaptor extends ArrayAdapter<ClipData.Item> {

    private int resourceLayout;
    private Context mContext;

    public topViewedAdaptor(Context context, int resource, List<ClipData.Item> items){
        super(context, resource, items);
        this.resourceLayout = resource;
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(mContext);
            v = vi.inflate(resourceLayout, null);
        }
        ClipData.Item p = getItem(position);

        if (p != null) {

        }

        return v;
    }

}
