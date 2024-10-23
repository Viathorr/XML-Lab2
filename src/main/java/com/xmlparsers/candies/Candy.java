package com.xmlparsers.candies;

import com.xmlparsers.candies.enums.CandyTypeEnum;

public class Candy {

    protected String name;
    protected CandyTypeEnum type;
    protected String filling;
    protected IngredientsType ingredients;
    protected int energy;
    protected ValueType value;
    protected String production;
    protected String id;

    public Candy() {}

    public Candy(String name, CandyTypeEnum type,
                 String filling, IngredientsType ingredients,
                 int energy, ValueType value,
                 String production, String id) {
        this.name = name;
        this.type = type;
        this.filling = filling;
        this.ingredients = ingredients;
        this.energy = energy;
        this.value = value;
        this.production = production;
        this.id = id;
    }

    /**
     * Gets the value of the name property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the type property.
     *
     * @return
     *     possible object is
     *     {@link CandyTypeEnum }
     *
     */
    public CandyTypeEnum getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value
     *     allowed object is
     *     {@link CandyTypeEnum }
     *
     */
    public void setType(CandyTypeEnum value) {
        this.type = value;
    }

    /**
     * Gets the value of the filling property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFilling() {
        return filling;
    }

    /**
     * Sets the value of the filling property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFilling(String value) {
        this.filling = value;
    }

    /**
     * Gets the value of the ingredients' property.
     *
     * @return
     *     possible object is
     *     {@link IngredientsType }
     *
     */
    public IngredientsType getIngredients() {
        return ingredients;
    }

    /**
     * Sets the value of the ingredients' property.
     *
     * @param value
     *     allowed object is
     *     {@link IngredientsType }
     *
     */
    public void setIngredients(IngredientsType value) {
        this.ingredients = value;
    }

    /**
     * Gets the value of the energy property.
     *
     */
    public int getEnergy() {
        return energy;
    }

    /**
     * Sets the value of the energy property.
     *
     */
    public void setEnergy(int value) {
        this.energy = value;
    }

    /**
     * Gets the value of the value property.
     *
     * @return
     *     possible object is
     *     {@link ValueType }
     *
     */
    public ValueType getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value
     *     allowed object is
     *     {@link ValueType }
     *
     */
    public void setValue(ValueType value) {
        this.value = value;
    }

    /**
     * Gets the value of the production property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getProduction() {
        return production;
    }

    /**
     * Sets the value of the production property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setProduction(String value) {
        this.production = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param id
     *     allowed object is
     *     {@link String }
     *
     */
    public void setId(String id) {
        this.id = id;
    }

//    @Override
//    public String toString() {
//        return "Candy{" +
//                "name='" + name + '\'' +
//                '}';
//    }


    @Override
    public String toString() {
        return "\nCandy, id(\"" + id + "\"):\n" +
                "name = '" + name + '\'' +
                ", type = " + type +
                ", filling = '" + filling + '\'' +
                ", \ningredients = " + ingredients +
                ", \nenergy = " + energy +
                ", \nvalue = " + value +
                ", \nproduction = '" + production + '\'';
    }
}
