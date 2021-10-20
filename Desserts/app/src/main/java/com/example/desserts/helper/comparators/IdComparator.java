package com.example.desserts.helper.comparators;

import com.example.desserts.structures.Dessert;

import java.util.Comparator;

/**
 * IdComparator compares Desserts based on Id.
 *
 * @author Osama Kashif
 */
public class IdComparator implements Comparator<Dessert> {

    /**
     * @param d1 - Dessert 1 to compare
     * @param d2 - Dessert 2 to compare
     * @return Integer, positive if d1 has Id greater than d2, negative if d2 has greater Id, and 0 if equal.
     */
    @Override
    public int compare(Dessert d1, Dessert d2) {
        return Math.toIntExact(d1.getId() - d2.getId());
    }

}
