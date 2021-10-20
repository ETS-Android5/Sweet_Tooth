package com.example.desserts.helper.comparators;

import com.example.desserts.structures.Dessert;

import java.util.Comparator;

/**
 * NumberViewedComparator compares Desserts based on NumberViewed.
 */
public class NumberViewedComparator implements Comparator<Dessert> {

    /**
     * @param d1 - Dessert 1 to compare
     * @param d2 - Dessert 2 to compare
     * @return Integer, positive if d1 has more views than d2, negative if d2 has more, and 0 if equal.
     */
    @Override
    public int compare(Dessert d1, Dessert d2) {
        return Math.toIntExact(d1.getNumberViewed() - d2.getNumberViewed());
    }

}
