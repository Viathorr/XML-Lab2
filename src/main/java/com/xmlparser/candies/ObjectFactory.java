package com.xmlparser.candies;

public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.xmlparser.candies
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Candies }
     * 
     */
    public Candies createCandies() {
        return new Candies();
    }

    /**
     * Create an instance of {@link Candies.Candy }
     * 
     */
    public Candies.Candy createCandiesCandy() {
        return new Candies.Candy();
    }

    /**
     * Create an instance of {@link CandyType }
     * 
     */
    public CandyType createCandyType() {
        return new CandyType();
    }

    /**
     * Create an instance of {@link IngredientsType }
     * 
     */
    public IngredientsType createIngredientsType() {
        return new IngredientsType();
    }

    /**
     * Create an instance of {@link ValueType }
     * 
     */
    public ValueType createValueType() {
        return new ValueType();
    }

}
