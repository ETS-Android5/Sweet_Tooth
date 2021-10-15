package com.example.desserts.structures;

import com.example.desserts.database.DBLoader;

import java.util.List;

/**
 * Tea is a concrete Dessert class inheriting Drinkable.
 *
 * @author Osama Kashif
 */
public class Tea extends Drinkable {

    private final String teaBase;

    /**
     * Constructor for Tea.
     *
     * @param name                 - Name of Tea
     * @param Id                   - ID of Tea
     * @param cost                 - Cost of Tea
     * @param basicDescription     - Basic Description of Tea
     * @param ingredientsContained - Ingredients contained in Tea
     * @param dietsSuitableFor     - Diets Tea is suitable for
     * @param numberViewed         - Number of times the Tea is viewed
     * @param volume               - Volume of one serving of Tea
     * @param ice                  - Ice in one serving of Tea
     * @param sugar                - Sugar in one serving of Tea
     * @param toppings             - Toppings on Tea
     * @param teaBase              - Tea base for the Tea
     */
    public Tea(String name, long Id, float cost, String basicDescription, List<String> ingredientsContained, List<String> dietsSuitableFor, long numberViewed, float volume, int ice, int sugar, List<String> toppings, String teaBase) {
        super(name, Id, cost, basicDescription, ingredientsContained, dietsSuitableFor, numberViewed, volume, ice, sugar, toppings);
        this.teaBase = teaBase;
        this.addDescription(this.specificDescription());
    }

    /**
     * Method to construct the customised full description for Tea.
     *
     * @return Full custom description for Tea
     */
    private String specificDescription() {
        String description = "";
        description = description + this.getBasicDescription() + "\n" + this.getAdditionalDetails();
        description = description + "\nTea Base: " + teaBase;
        return description;
    }

    /**
     * Increases the number of people who viewed the app at runtime.
     */
    @Override
    public void increaseNumberViewed() {
        super.increaseNumberViewed();
        DBLoader.addNumberViewed("Drinkable", "Tea", this.getId(), this.getNumberViewed());
    }

}
