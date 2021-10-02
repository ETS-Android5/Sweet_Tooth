package com.example.desserts.structures;

import android.media.Image;

import java.util.List;

public interface Dessert {

    public String getName();

    public long getId();

    public float getCost();

    public List<Image> getImages();

    public Image getImage(int imageId);

    public String getDescription();

    public List<String> getContainedIngredients();

    public List<String> getDietsSuitableFor();

    public long getNumberViewed();

    public String getAdditionalDetails();

}
