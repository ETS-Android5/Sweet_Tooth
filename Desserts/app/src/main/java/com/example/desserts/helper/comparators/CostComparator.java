package com.example.desserts.helper.comparators;

import com.example.desserts.structures.Dessert;

import java.util.Comparator;

/**
 * CostComparator compares Desserts based on Cost.
 *
 * @author Osama Kashif
 */
public class CostComparator implements Comparator<Dessert> {

    /**
     * @param d1 - Dessert 1 to compare
     * @param d2 - Dessert 2 to compare
     * @return Integer, positive if d1 costs more than d2, negative if d2 costs more, and 0 if equal.
     */
    @Override
    public int compare(Dessert d1, Dessert d2) {
        return (int) (d1.getCost() - d2.getCost());
    }

}