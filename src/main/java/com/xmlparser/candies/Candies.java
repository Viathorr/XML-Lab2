//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.2 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.10.19 at 03:37:28 PM EEST 
//


package com.xmlparser.candies;

import java.util.List;
import java.util.ArrayList;

public class Candies {

    protected List<Candy> candies;

    public List<Candy> getCandy() {
        if (candies == null) {
            candies = new ArrayList<Candy>();
        }
        return this.candies;
    }

    public void addCandy(Candy candy) {
        this.candies.add(candy);
    }
}
