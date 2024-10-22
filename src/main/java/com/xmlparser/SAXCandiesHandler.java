package com.xmlparser;

import com.xmlparser.candies.Candies;
import com.xmlparser.candies.Candy;
import com.xmlparser.candies.IngredientsType;
import com.xmlparser.candies.ValueType;
import com.xmlparser.candies.enums.CandyTypeEnum;
import com.xmlparser.candies.enums.ChocolateTypeEnum;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.logging.Logger;

public class SAXCandiesHandler extends DefaultHandler {
    private static final Logger logger = Logger.getLogger(SAXCandiesParser.class.getName());

    private Candies candies;
    private Candy candy;
    private IngredientsType ingredients;
    private ValueType value;
    private StringBuilder elementValue;

    public Candies getCandies() {
        return candies;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (elementValue == null) {
            elementValue = new StringBuilder();
        } else {
            elementValue.append(ch, start, length);
        }
    }

    @Override
    public void startDocument() throws SAXException {
        logger.info("XML document parsing started.");
        candies = new Candies();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        logger.info("Start element: <" + qName + ">");
        switch (qName.toLowerCase()) {
            case "candy":
                String id = attributes.getValue("id");
                candy = new Candy();
                candy.setId(id);
                if (this.candies.getCandies() == null) {
                    this.candies.setEmptyListOfCandies();
                }
                break;
            case "type":
                candy.setFilling(attributes.getValue("filling"));
            case "ingredients":
                this.ingredients = new IngredientsType();
                break;
            case "value":
                this.value = new ValueType();
                break;
            default:
                break;
        }

        this.elementValue = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        logger.info("End element: </" + qName + ">");

        if (!elementValue.toString().trim().isEmpty()) {
            logger.info("Element value: " + elementValue.toString().trim());
        }

        switch (qName.toLowerCase()) {
            case "candy":
                this.candies.addCandy(this.candy);
                break;
            case "name":
                candy.setName(elementValue.toString());
                break;
            case "type":
                candy.setType(CandyTypeEnum.fromValue(elementValue.toString()));
                break;
            case "water":
                this.ingredients.setWater(Integer.parseInt(elementValue.toString()));
                break;
            case "sugar":
                this.ingredients.setSugar(Integer.parseInt(elementValue.toString()));
                break;
            case "fructose":
                this.ingredients.setFructose(Integer.parseInt(elementValue.toString()));
                break;
            case "vanillin":
                this.ingredients.setVanillin(Integer.parseInt(elementValue.toString()));
                break;
            case "chocolatetype":
                this.ingredients.setChocolateType(ChocolateTypeEnum.fromValue(elementValue.toString()));
                break;
            case "energy":
                this.candy.setEnergy(Integer.parseInt(elementValue.toString()));
                break;
            case "protein":
                this.value.setProtein(Integer.parseInt(elementValue.toString()));
                break;
            case "fat":
                this.value.setFat(Integer.parseInt(elementValue.toString()));
                break;
            case "carbohydrate":
                this.value.setCarbohydrate(Integer.parseInt(elementValue.toString()));
                break;
            case "production":
                this.candy.setProduction(elementValue.toString());
                break;
            case "ingredients":
                this.candy.setIngredients(this.ingredients);
                break;
            case "value":
                this.candy.setValue(this.value);
                break;
            default:
                break;
        }
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        logger.info("XML document parsing finished.");
    }
}
