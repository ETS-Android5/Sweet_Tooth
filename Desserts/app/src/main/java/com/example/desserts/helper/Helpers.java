package com.example.desserts.helper;

import com.example.desserts.helper.comparators.NumberViewedComparator;
import com.example.desserts.structures.Dessert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Static Helpers class to be used throughout the application.
 *
 * @author Osama Kashif
 */
public class Helpers {

    /**
     * The search methods search for the query in the objects provided.
     *
     * @param listToSearchIn - List of Desserts provided to search in.
     * @param searchQuery    - String query to search for.
     * @return searchResults - A List of Desserts which match query, If not found, list is empty.
     */
    public static List<Dessert> search(List<Dessert> listToSearchIn, String searchQuery) {
        List<Dessert> searchResults = new ArrayList<>();
        for (Dessert des : listToSearchIn) {
            boolean found = false;
            if ((Double.toString(des.getCost()).contains(searchQuery)) || (des.getDescription().contains(searchQuery)) || (des.getName().contains(searchQuery))) {
                searchResults.add(des);
                found = true;
            }
            if (!found) {
                for (String ing : des.getContainedIngredients()) {
                    if (ing.contains(searchQuery)) {
                        searchResults.add(des);
                        found = true;
                        break;
                    }
                }
            }
            if (!found) {
                for (String diets : des.getDietsSuitableFor()) {
                    if (diets.contains(searchQuery)) {
                        searchResults.add(des);
                        break;
                    }
                }
            }
        }
        return searchResults;
    }

    /**
     * top5 returns a list of the top 5 desserts from the provided list of desserts.
     *
     * @param allDesserts - List of all Desserts in the application.
     * @return - List of Top 5 Dessert based on number of times they are viewed.
     */
    public static List<Dessert> top5(List<Dessert> allDesserts) {
        Collections.sort(allDesserts, new NumberViewedComparator());
        return 5 > allDesserts.size() ? allDesserts : allDesserts.stream().limit(5).collect(Collectors.toList());
    }

    /**
     * Capitalises all the words of a String and returns that.
     * I did not make this function, but found it:
     * Reference: https://www.javatpoint.com/java-program-to-capitalize-each-word-in-string
     *
     * @param str - String to be capitalised.
     * @return - Capitalised String.
     */
    public static String capitalizeWords(String str) {
        String words[] = str.split("\\s");
        String capitalizeWords = "";
        for (String w : words) {
            String first = w.substring(0, 1);
            String afterfirst = w.substring(1);
            capitalizeWords += first.toUpperCase() + afterfirst + " ";
        }
        return capitalizeWords.trim();
    }

}
