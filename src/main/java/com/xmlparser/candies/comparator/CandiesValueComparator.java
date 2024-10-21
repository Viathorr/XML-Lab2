package com.xmlparser.candies.comparator;

import com.xmlparser.candies.Candy;

import java.util.Comparator;

public class CandiesValueComparator implements Comparator<Candy> {
    @Override
    public int compare(Candy c1, Candy c2) {
        return Integer.compare(c1.getEnergy(), c2.getEnergy());
    }
}
