package com.example.desserts.structures;

import android.media.Image;

import java.util.List;

abstract class Drinkable implements Dessert {

    String name;
    long Id;
    float cost;
    List<Image> images;
    String description;
    List<String> ingredientsContained;
    List<String> dietsSuitableFor;
    long numberViewed;
    float volume;
    int ice;
    int sugar;
    List<String> toppings;

    public Drinkable (String name, long Id, float cost, List<Image> images, String description, List<String> ingredientsContained, List<String> dietsSuitableFor, long numberViewed, float volume, int ice, int sugar, List<String> toppings) {
        this.name = name;
        this.Id = Id;
        this.cost = cost;
        this.images = images;
        this.description = description;
        this.ingredientsContained = ingredientsContained;
        this.dietsSuitableFor = dietsSuitableFor;
        this.numberViewed = numberViewed;
        this.volume = volume;
        this.ice = ice;
        this.sugar = sugar;
        this.toppings = toppings;
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
        StringBuilder details = new StringBuilder("Volume: " + volume + "ml\nIce: " + ice + "%\nSugar: " + sugar + "%");
        boolean startOfToppings = true;
        for (String topping: toppings) {
            if (startOfToppings) {
                details.append("\nToppings:");
                startOfToppings = false;
            }
            details.append("\n").append(topping);
        }
        return details.toString();
    }

}
