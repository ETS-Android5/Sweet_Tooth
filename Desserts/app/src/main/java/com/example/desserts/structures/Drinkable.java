package com.example.desserts.structures;

import java.util.List;

/**
 * The Drinkable abstract class implements the Dessert Interface and is used to have the common
 * features for drinkable dessert items.
 * @author Osama Kashif
 */
abstract class Drinkable implements Dessert {

    private final String name;
    private final long Id;
    private final double cost;
    private final String basicDescription;
    private String description = null;
    private final List<String> ingredientsContained;
    private final List<String> dietsSuitableFor;
    private long numberViewed;
    private final long volume;
    private final int ice;
    private final int sugar;
    private final List<String> toppings;

    /**
     * Constructor for Drinkable Dessert.
     * @param name - name of Dessert
     * @param Id - ID of Dessert
     * @param cost - Cost of Dessert
     * @param basicDescription - Basic Description of Dessert
     * @param ingredientsContained - Ingredients Contained in the Dessert
     * @param dietsSuitableFor - Diets the Dessert is Suitable For
     * @param numberViewed - Number of times the Dessert has been viewed
     * @param volume - Volume of Drinkable Dessert
     * @param ice - Ice in Drinkable Dessert
     * @param sugar - Sugar in Drinkable Dessert
     * @param toppings - Toppings for the Drinkable Dessert
     */
    public Drinkable (String name, long Id, double cost, String basicDescription, List<String> ingredientsContained, List<String> dietsSuitableFor, long numberViewed, int volume, int ice, int sugar, List<String> toppings) {
        this.name = name;
        this.Id = Id;
        this.cost = cost;
        this.basicDescription = basicDescription;
        this.ingredientsContained = ingredientsContained;
        this.dietsSuitableFor = dietsSuitableFor;
        this.numberViewed = numberViewed;
        this.volume = volume;
        this.ice = ice;
        this.sugar = sugar;
        this.toppings = toppings;
    }

    /**
     * Gets the name of the Dessert.
     * @return String name of Dessert
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the ID of the Drinkable Dessert.
     * @return long ID.
     */
    public long getId() {
        return Id;
    }

    /**
     * Gets the cost of the Drinkable Dessert.
     * @return double cost.
     */
    public double getCost() {
        return cost;
    }

    /**
     * Gets the description of the Drinkable Dessert.
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
     *  Gets basic description of the Drinkable Dessert.
     * @return String basic Description of Drinkable Dessert.
     */
    public String getBasicDescription() {
        return basicDescription;
    }

    /**
     * Used to edit the full description of the Drinkable Dessert.
     * @param description - To enter the full custom description of the Drinkable Dessert.
     */
    public void addDescription (String description) {
        this.description = description;
    }

    /**
     * Gets some of the ingredients contained in the Drinkable Dessert for allergy reasons.
     * @return List of Ingredients Contained
     */
    public List<String> getContainedIngredients() {
        return ingredientsContained;
    }

    /**
     * Gets the diets the Drinkable Dessert is suitable for.
     * @return List of Diets the Drinkable Dessert is suitable for
     */
    public List<String> getDietsSuitableFor() {
        return dietsSuitableFor;
    }

    /**
     * Gets the number of times the Drinkable Dessert has been viewed.
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
     * Gets the volume, ice, sugar and toppings (if any) of the Drinkable Dessert
     * @return String (formatted) of volume, ice, sugar, and toppings of the Drinkable Dessert.
     */
    public String getAdditionalDetails() {
        StringBuilder details = new StringBuilder("Volume: " + volume + "ml\nIce: " + ice + "%\nSugar: " + sugar + "%");
        boolean startOfToppings = true;
        for (String topping: toppings) {
            if (startOfToppings) {
                details.append("\nTopping(s):");
                startOfToppings = false;
            }
            details.append("\n").append(topping);
        }
        return details.toString();
    }

}
