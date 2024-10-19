package com.xmlparser.candies;

public class Candy {

    protected String name;
    protected CandyType type;
    protected IngredientsType ingredients;
    protected int energy;
    protected ValueType value;
    protected String production;
    protected String id;

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
     *     {@link CandyType }
     *
     */
    public CandyType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value
     *     allowed object is
     *     {@link CandyType }
     *
     */
    public void setType(CandyType value) {
        this.type = value;
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
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setId(String value) {
        this.id = value;
    }

}
