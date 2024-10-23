package com.xmlparsers.candies;

import com.xmlparsers.candies.enums.ChocolateTypeEnum;

import java.util.Objects;

public class IngredientsType {

    protected int water;
    protected int sugar;
    protected int fructose;
    protected int vanillin;
    protected ChocolateTypeEnum chocolateType;

    public IngredientsType() {}

    public IngredientsType(int water, int sugar, int fructose, int vanillin, ChocolateTypeEnum chocolateType) {
        this.water = water;
        this.sugar = sugar;
        this.fructose = fructose;
        this.vanillin = vanillin;
        this.chocolateType = chocolateType;
    }

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

    @Override
    public String toString() {
        return "Ingredients {" +
                "water=" + water +
                ", sugar=" + sugar +
                ", fructose=" + fructose +
                ", vanillin=" + vanillin +
                ", chocolateType=" + (chocolateType != null ? chocolateType.value() : "no chocolate") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IngredientsType that = (IngredientsType) o;

        return water == that.water && sugar == that.sugar && fructose == that.fructose && vanillin == that.vanillin
                && chocolateType == that.chocolateType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(water, sugar, fructose, vanillin, chocolateType);
    }
}
