package com.example.desserts.structures;

import java.util.List;

/**
 * The Edible abstract class implements the Dessert Interface and is used to have the common
 * features for edible dessert items.
 * @author Osama Kashif
 */
abstract class Edible implements Dessert {

    private final String name;
    private final long Id;
    private final double cost;
    private final String basicDescription;
    private String description = null;
    private final List<String> ingredientsContained;
    private final List<String> dietsSuitableFor;
    private long numberViewed;
    private final int peopleServed;

    /**
     * Constructor for Edible Dessert.
     * @param name - name of Edible Dessert
     * @param Id - ID of Edible Dessert
     * @param cost - Cost of Edible Dessert
     * @param basicDescription - Basic Description of Edible Dessert
     * @param ingredientsContained - Ingredients Contained in the Edible Dessert
     * @param dietsSuitableFor - Diets the Edible Dessert is Suitable For
     * @param numberViewed - Number of times the Edible Dessert has been viewed
     * @param peopleServed - People served by 1 serving of the Edible Dessert
     */
    public Edible (String name, long Id, double cost, String basicDescription, List<String> ingredientsContained, List<String> dietsSuitableFor, long numberViewed, int peopleServed) {
        this.name = name;
        this.Id = Id;
        this.cost = cost;
        this.basicDescription = basicDescription;
        this.ingredientsContained = ingredientsContained;
        this.dietsSuitableFor = dietsSuitableFor;
        this.numberViewed = numberViewed;
        this.peopleServed = peopleServed;
    }

    /**
     * Gets the name of the Dessert.
     * @return String name of Dessert
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the ID of the Edible Dessert.
     * @return long ID.
     */
    public long getId() {
        return Id;
    }

    /**
     * Gets the cost of the Dessert.
     * @return double cost.
     */
    public double getCost() {
        return cost;
    }

    /**
     * Gets the description of the Edible Dessert.
     * @return String description
     */
    public String getDescription() {
        if (description == null) {
            return basicDescription;
        } else {
            return description;
        }
    }

    /**
     *  Gets basic description of the Edible Dessert.
     * @return String basic Description of Edible Dessert.
     */
    public String getBasicDescription() {
        return basicDescription;
    }

    /**
     * Used to edit the full description of the Edible Dessert.
     * @param description - To enter the full custom description of the Edible Dessert.
     */
    public void addDescription (String description) {
        this.description = description;
    }

    /**
     * Gets some of the ingredients contained in the Edible Dessert for allergy reasons.
     * @return List of Ingredients Contained
     */
    public List<String> getContainedIngredients() {
        return ingredientsContained;
    }

    /**
     * Gets the diets the Edible Dessert is suitable for.
     * @return List of Diets the Edible Dessert is suitable for
     */
    public List<String> getDietsSuitableFor() {
        return dietsSuitableFor;
    }

    /**
     * Gets the number of times the Edible Dessert has been viewed.
     * @return long number viewed.
     */
    public long getNumberViewed() {
        return numberViewed;
    }

    /**
     * Increases the number of people who viewed the app at runtime.
     */
    public void increaseNumberViewed() {numberViewed++;}

    /**
     * Gets the people served by the Edible Dessert.
     * Specific for  Edible Desserts.
     * @return Number of people served by one serving of the Edible Dessert
     */
    public String getAdditionalDetails() {
        return ("People served: " + peopleServed);
    }

}
