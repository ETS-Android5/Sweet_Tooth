package com.example.desserts.structures;

import android.media.Image;

import java.util.List;

/**
 * IceCream is a concrete Dessert class inheriting Edible.
 * @author Osama Kashif
 */
public class IceCream extends Edible {
    private final int scoops;
    private final boolean cone;

    /**
     * Constructor for IceCream
     * @param name - Name of IceCream
     * @param Id - ID of IceCream
     * @param cost - Cost of IceCream
     * @param images - Images for IceCream
     * @param basicDescription - Basic Description of IceCream
     * @param ingredientsContained - Ingredients contained in IceCream
     * @param dietsSuitableFor - Diets IceCream is suitable for
     * @param numberViewed - Number of times the IceCream is viewed
     * @param peopleServed - People served by one serving of IceCream
     * @param scoops - Scoops in one serving of IceCream
     * @param cone - If the serving of IceCream is with a cone
     */
    public IceCream (String name, long Id, float cost, List<Image> images, String basicDescription, List<String> ingredientsContained, List<String> dietsSuitableFor, long numberViewed, int peopleServed, int scoops, boolean cone) {
        super(name, Id, cost, images, basicDescription, ingredientsContained, dietsSuitableFor, numberViewed, peopleServed);
        this.scoops = scoops;
        this.cone = cone;
        this.addDescription(this.specificDescription());
    }

    /**
     * Method to construct the customised full description for IceCream.
     * @return Full custom description for IceCream
     */
    private String specificDescription() {
        String description = "";
        description = description + this.getBasicDescription() + "\n" + this.getAdditionalDetails();
        description = description + "\nScoop: " + scoops;
        if (cone) {
            description = description + "\nComes in a cone.";
        }
        return description;
    }

}
