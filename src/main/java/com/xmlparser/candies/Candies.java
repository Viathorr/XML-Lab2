package com.xmlparser.candies;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Candies {

    protected List<Candy> candies;

    public void setEmptyListOfCandies() {
        this.candies = new ArrayList<>();
    }

    public List<Candy> getCandies() {
        return this.candies;
    }

    public void addCandy(Candy candy) {
        this.candies.add(candy);
    }

    public void sortCandies(Comparator<Candy> comparator) {
        this.candies.sort(comparator);
    }


}
