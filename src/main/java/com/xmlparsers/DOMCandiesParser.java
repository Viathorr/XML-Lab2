package com.xmlparsers;

import com.xmlparsers.candies.Candies;
import com.xmlparsers.candies.Candy;
import com.xmlparsers.candies.IngredientsType;
import com.xmlparsers.candies.ValueType;
import com.xmlparsers.candies.comparator.CandiesEnergyComparator;
import com.xmlparsers.candies.enums.CandyTypeEnum;
import com.xmlparsers.candies.enums.ChocolateTypeEnum;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

public class DOMCandiesParser {
    private static final Logger logger = Logger.getLogger(DOMCandiesParser.class.getName());

    public static void main(String[] args) {
        logger.info("Parsing a \"Candies.xml\" file with DOM Parser.");

        Candies parsedCandies = parse("Candies.xml");
        parsedCandies.getCandies().forEach(System.out::println);

        System.out.println("\nCandies after sorting:");
        parsedCandies.sortCandies(new CandiesEnergyComparator());
        parsedCandies.getCandies().forEach(System.out::println);
    }

    public static Candies parse(String xmlPath) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        Candies parsedCandies = new Candies();

        try (InputStream xmlFile = DOMCandiesParser.class.getClassLoader().getResourceAsStream(xmlPath)) {
            if (xmlFile != null) {
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                Document document = documentBuilder.parse(xmlFile);

                NodeList candiesList = document.getElementsByTagName("Candy");
                parsedCandies.setEmptyListOfCandies();

                for (int i = 0; i < candiesList.getLength(); i++) {
                    Candy candy = new Candy();
                    Node candyNode = candiesList.item(i);

                    if (candyNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element candyElement = (Element) candyNode;

                        candy.setId(candyElement.getAttribute("id"));
                        candy.setName(candyElement.getElementsByTagName("Name").item(0).getTextContent());
                        Element type = (Element) candyElement.getElementsByTagName("Type").item(0);
                        candy.setFilling(type.getAttribute("filling"));
                        candy.setType(CandyTypeEnum.fromValue(type.getTextContent()));

                        IngredientsType ingredients = new IngredientsType();
                        ValueType value = new ValueType();

                        Element ingredientsElement = (Element) candyElement.getElementsByTagName("Ingredients")
                                .item(0);
                        Element valueElement = (Element) candyElement.getElementsByTagName("Value").item(0);

                        ingredients.setWater(Integer.parseInt(ingredientsElement.getElementsByTagName("Water")
                                .item(0).getTextContent()));
                        ingredients.setSugar(Integer.parseInt(ingredientsElement.getElementsByTagName("Sugar")
                                .item(0).getTextContent()));
                        ingredients.setFructose(Integer.parseInt(ingredientsElement.getElementsByTagName("Fructose")
                                .item(0).getTextContent()));
                        ingredients.setVanillin(Integer.parseInt(ingredientsElement.getElementsByTagName("Vanillin")
                                .item(0).getTextContent()));

                        Element chocolateType = (Element) ingredientsElement.getElementsByTagName("ChocolateType").item(0);

                        if (chocolateType != null) {
                            ingredients.setChocolateType(ChocolateTypeEnum.fromValue(chocolateType.getTextContent()));
                        }

                        candy.setIngredients(ingredients);
                        candy.setEnergy(Integer.parseInt(candyElement.getElementsByTagName("Energy").item(0)
                                .getTextContent()));

                        value.setProtein(Integer.parseInt(valueElement.getElementsByTagName("Protein")
                                .item(0).getTextContent()));
                        value.setFat(Integer.parseInt(valueElement.getElementsByTagName("Fat")
                                .item(0).getTextContent()));
                        value.setCarbohydrate(Integer.parseInt(valueElement.getElementsByTagName("Carbohydrate")
                                .item(0).getTextContent()));
                        candy.setValue(value);

                        candy.setProduction(candyElement.getElementsByTagName("Production").item(0)
                                .getTextContent());

                        parsedCandies.addCandy(candy);
                    }
                }

                logger.info("XML document parsing finished.");
            } else {
                logger.severe("XML file was not found in resources.");
            }
        } catch(IOException | ParserConfigurationException | SAXException e) {
            logger.severe("DOM parsing error: " + e.getMessage());
        }

        return parsedCandies;
    }
}