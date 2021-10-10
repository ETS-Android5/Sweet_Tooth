package com.example.desserts.structures;

import java.util.List;

/**
 * Coffee is a concrete Dessert class inheriting Drinkable.
 * @author Osama Kashif
 */
public class Coffee extends Drinkable {

    private final int percentCoffee;

    /**
     * Constructor for Coffee.
     * @param name - Name of Coffee
     * @param Id - ID of Coffee
     * @param cost - Cost of Coffee
     * @param basicDescription - Basic Description of Coffee
     * @param ingredientsContained - Ingredients contained in Coffee
     * @param dietsSuitableFor - Diets Coffee is suitable for
     * @param numberViewed - Number of times the Coffee is viewed
     * @param volume - Volume of one serving of Coffee
     * @param ice - Ice in one serving of Coffee
     * @param sugar - Sugar in one serving of Coffee
     * @param toppings - Toppings on Coffee
     * @param percentCoffee - Percentage of Coffee in the Coffee Dessert
     */
    public Coffee (String name, long Id, float cost, String basicDescription, List<String> ingredientsContained, List<String> dietsSuitableFor, long numberViewed, float volume, int ice, int sugar, List<String> toppings, int percentCoffee) {
        super(name, Id, cost, basicDescription, ingredientsContained, dietsSuitableFor, numberViewed, volume, ice, sugar, toppings);
        this.percentCoffee = percentCoffee;
        this.addDescription(this.specificDescription());
    }

    /**
     * Method to construct the customised full description for Coffee.
     * @return Full custom description for Coffee
     */
    private String specificDescription() {
        String description = "";
        description = description + this.getBasicDescription() + "\n" + this.getAdditionalDetails();
        description = description + "\nCoffee: " + percentCoffee + "%";
        return description;
    }
}
