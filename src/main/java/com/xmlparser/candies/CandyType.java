package com.xmlparser.candies;

public class CandyType {

    protected CandyTypeEnum value;
    protected String filling;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link CandyTypeEnum }
     *     
     */
    public CandyTypeEnum getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link CandyTypeEnum }
     *     
     */
    public void setValue(CandyTypeEnum value) {
        this.value = value;
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

}
