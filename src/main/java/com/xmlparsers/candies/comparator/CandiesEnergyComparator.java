package com.xmlparsers.candies.comparator;

import generated.Candies.Candy;

import java.util.Comparator;

public class CandiesEnergyComparator implements Comparator<Candy> {
    @Override
    public int compare(Candy c1, Candy c2) {
        return Integer.compare(c1.getEnergy(), c2.getEnergy());
    }
}
