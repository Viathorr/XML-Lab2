package com.xmlparsers.candies;

public class ValueType {

    protected int protein;
    protected int fat;
    protected int carbohydrate;

    public ValueType() {}

    public ValueType(int protein, int fat, int carbohydrate) {
        this.protein = protein;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
    }

    /**
     * Gets the value of the protein property.
     * 
     */
    public int getProtein() {
        return protein;
    }

    /**
     * Sets the value of the protein property.
     * 
     */
    public void setProtein(int value) {
        this.protein = value;
    }

    /**
     * Gets the value of the fat property.
     * 
     */
    public int getFat() {
        return fat;
    }

    /**
     * Sets the value of the fat property.
     * 
     */
    public void setFat(int value) {
        this.fat = value;
    }

    /**
     * Gets the value of the carbohydrate property.
     * 
     */
    public int getCarbohydrate() {
        return carbohydrate;
    }

    /**
     * Sets the value of the carbohydrate property.
     * 
     */
    public void setCarbohydrate(int value) {
        this.carbohydrate = value;
    }

    @Override
    public String toString() {
        return "Value {" +
                "protein=" + protein +
                ", fat=" + fat +
                ", carbohydrate=" + carbohydrate +
                '}';
    }
}
