package com.example.desserts.structures;

import android.media.Image;

import java.util.List;

abstract class Edible implements Dessert {

    String name;
    long Id;
    float cost;
    List<Image> images;
    String description;
    List<String> ingredientsContained;
    List<String> dietsSuitableFor;
    long numberViewed;
    int peopleServed;

    public Edible (String name, long Id, float cost, List<Image> images, String description, List<String> ingredientsContained, List<String> dietsSuitableFor, long numberViewed, int peopleServed) {
        this.name = name;
        this.Id = Id;
        this.cost = cost;
        this.images = images;
        this.description = description;
        this.ingredientsContained = ingredientsContained;
        this.dietsSuitableFor = dietsSuitableFor;
        this.numberViewed = numberViewed;
        this.peopleServed = peopleServed;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return Id;
    }

    public float getCost() {
        return cost;
    }

    public List<Image> getImages() {
        return images;
    }

    public Image getImage(int imageId) {
        return images.get(imageId);
    }

    public String getDescription() {
        return description;
    }

    public List<String> getContainedIngredients() {
        return ingredientsContained;
    }

    public List<String> getDietsSuitableFor() {
        return dietsSuitableFor;
    }

    public long getNumberViewed() {
        return numberViewed;
    }

    public String getAdditionalDetails() {
        return ("People served: " + peopleServed);
    }

}
