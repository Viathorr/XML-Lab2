package com.xmlparser.candies;

public class IngredientsType {

    protected int water;
    protected int sugar;
    protected int fructose;
    protected int vanillin;
    protected ChocolateTypeEnum chocolateType;

    /**
     * Gets the value of the water property.
     * 
     */
    public int getWater() {
        return water;
    }

    /**
     * Sets the value of the water property.
     * 
     */
    public void setWater(int value) {
        this.water = value;
    }

    /**
     * Gets the value of the sugar property.
     * 
     */
    public int getSugar() {
        return sugar;
    }

    /**
     * Sets the value of the sugar property.
     * 
     */
    public void setSugar(int value) {
        this.sugar = value;
    }

    /**
     * Gets the value of the fructose property.
     * 
     */
    public int getFructose() {
        return fructose;
    }

    /**
     * Sets the value of the fructose property.
     * 
     */
    public void setFructose(int value) {
        this.fructose = value;
    }

    /**
     * Gets the value of the vanillin property.
     * 
     */
    public int getVanillin() {
        return vanillin;
    }

    /**
     * Sets the value of the vanillin property.
     * 
     */
    public void setVanillin(int value) {
        this.vanillin = value;
    }

    /**
     * Gets the value of the chocolateType property.
     * 
     * @return
     *     possible object is
     *     {@link ChocolateTypeEnum }
     *     
     */
    public ChocolateTypeEnum getChocolateType() {
        return chocolateType;
    }

    /**
     * Sets the value of the chocolateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChocolateTypeEnum }
     *     
     */
    public void setChocolateType(ChocolateTypeEnum value) {
        this.chocolateType = value;
    }

}
