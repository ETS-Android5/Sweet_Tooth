package com.example.desserts.cart;

import com.example.desserts.structures.Dessert;

import java.util.ArrayList;
import java.util.List;

/**
 * ShoppingCart singleton class, made for the shopping cart instance of the application.
 *
 * @author Osama Kashif
 */
public class ShoppingCart {
    
    private static ShoppingCart cart_instance = null;

    private List<Dessert> desserts;
    private float totalCost;

    /**
     * ShoppingCart private constructor restricted to the class itself.
     */
    private ShoppingCart() {
        desserts = new ArrayList<Dessert>();
        totalCost = 0;
    }

    /**
     * getInstance returns a singleton instance of ShoppingCart, creating a new one if one doesn't
     * exist already.
     *
     * @return ShoppingCart instance
     */
    public static ShoppingCart getInstance() {
        if (cart_instance == null)
            cart_instance = new ShoppingCart();
        return cart_instance;
    }

    /**
     * Adds input dessert to the cart.
     * @param dessert - Dessert to be added to the cart.
     */
    public void addDessert (Dessert dessert) {
        desserts.add(dessert);
        totalCost += dessert.getCost();
    }

    /**
     * Removes input dessert from the cart.
     * @param dessert - Dessert to be removed from the Cart
     */
    public void removeDessert (Dessert dessert) {
        if (desserts.contains(dessert)) {
            totalCost -= dessert.getCost();
            desserts.remove(dessert);
        }
    }

    /**
     * getAllDessertsInCart gets all the desserts which the user has added to the cart.
     * @return List of Desserts added to the cart
     */
    public List<Dessert> getAllDessertsInCart () {
        return desserts;
    }

    /**
     * getTotalCost gets the total cost of the desserts in the cart.
     * @return total cost in the cart
     */
    public float getTotalCost () {
        return (float) (Math.round(totalCost* 100.0) / 100.0);
    }

}
