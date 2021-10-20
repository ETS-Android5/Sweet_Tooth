package com.example.desserts.helper.comparators;

import com.example.desserts.structures.Dessert;

import java.util.Comparator;

/**
 * NameComparator compares Desserts based on Name.
 *
 * @author Osama Kashif
 */
public class NameComparator implements Comparator<Dessert> {

    /**
     * @param d1 - Dessert 1 to compare
     * @param d2 - Dessert 2 to compare
     * @return Integer, compareTo result of names of d1 and d2
     */
    @Override
    public int compare(Dessert d1, Dessert d2) {
        return d1.getName().compareTo(d2.getName());
    }

}