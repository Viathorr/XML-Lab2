package com.xmlparsers.candies;

import com.xmlparsers.SAXCandiesParser;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Candies {

    private static final Logger logger = Logger.getLogger(SAXCandiesParser.class.getName());

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
        logger.info("Sorting candies in ascending order by Energy value.");
        this.candies.sort(comparator);
    }


}
