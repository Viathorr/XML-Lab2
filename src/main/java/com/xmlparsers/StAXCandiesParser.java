package com.xmlparsers;

import com.xmlparsers.candies.Candies;
import com.xmlparsers.candies.Candy;
import com.xmlparsers.candies.IngredientsType;
import com.xmlparsers.candies.ValueType;
import com.xmlparsers.candies.enums.CandyTypeEnum;
import com.xmlparsers.candies.enums.ChocolateTypeEnum;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

public class StAXCandiesParser {
    private static final Logger logger = Logger.getLogger(StAXCandiesParser.class.getName());

    public Candies parse(String xmlPath) {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

        Candies parsedCandies = new Candies();

        try (InputStream xmlStream = XMLValidator.class.getClassLoader().getResourceAsStream(xmlPath)) {
            if (xmlStream != null) {
                XMLEventReader reader = xmlInputFactory.createXMLEventReader(xmlStream);

                Candy candy = new Candy();
                IngredientsType ingredients = new IngredientsType();
                ValueType value = new ValueType();

                while (reader.hasNext()) {
                    XMLEvent nextEvent = reader.nextEvent();

                    if (nextEvent.isStartElement()) {
                        StartElement startElement = nextEvent.asStartElement();
                        String qName = startElement.getName().getLocalPart();
                        logger.info("Start element: <" + qName + ">");

                        switch (qName.toLowerCase()) {
                            case "candy":
                                String id = startElement.getAttributeByName(new QName("id")).getValue();
                                candy.setId(id);
                                if (parsedCandies.getCandies() == null) {
                                    parsedCandies.setEmptyListOfCandies();
                                }
                                // we don't proceed here to the nextEvent as in the cases below, because if we do so,
                                // we will miss the next element from file, because we are reading the next element twice
                                // as our next `if` statement doesn't hold for complex typed elements, compared to simple ones
                                break;
                            case "name":
                                nextEvent = reader.nextEvent();
                                candy.setName(nextEvent.asCharacters().getData());
                                break;
                            case "type":
                                String filling = startElement.getAttributeByName(new QName("filling")).getValue();
                                candy.setFilling(filling);
                                nextEvent = reader.nextEvent();
                                candy.setType(CandyTypeEnum.fromValue(nextEvent.asCharacters().getData()));
                                break;
                            case "water":
                                nextEvent = reader.nextEvent();
                                ingredients.setWater(Integer.parseInt(nextEvent.asCharacters().getData()));
                                break;
                            case "sugar":
                                nextEvent = reader.nextEvent();
                                ingredients.setSugar(Integer.parseInt(nextEvent.asCharacters().getData()));
                                break;
                            case "fructose":
                                nextEvent = reader.nextEvent();
                                ingredients.setFructose(Integer.parseInt(nextEvent.asCharacters().getData()));
                                break;
                            case "vanillin":
                                nextEvent = reader.nextEvent();
                                ingredients.setVanillin(Integer.parseInt(nextEvent.asCharacters().getData()));
                                break;
                            case "chocolatetype":
                                nextEvent = reader.nextEvent();
                                ingredients.setChocolateType(ChocolateTypeEnum.fromValue(nextEvent.asCharacters().getData()));
                                break;
                            case "energy":
                                nextEvent = reader.nextEvent();
                                candy.setEnergy(Integer.parseInt(nextEvent.asCharacters().getData()));
                                break;
                            case "protein":
                                nextEvent = reader.nextEvent();
                                value.setProtein(Integer.parseInt(nextEvent.asCharacters().getData()));
                                break;
                            case "fat":
                                nextEvent = reader.nextEvent();
                                value.setFat(Integer.parseInt(nextEvent.asCharacters().getData()));
                                break;
                            case "carbohydrate":
                                nextEvent = reader.nextEvent();
                                value.setCarbohydrate(Integer.parseInt(nextEvent.asCharacters().getData()));
                                break;
                            case "production":
                                nextEvent = reader.nextEvent();
                                candy.setProduction(nextEvent.asCharacters().getData());
                                break;
                            default:
                                break;
                        }
                    }

                    if (nextEvent.isEndElement()) {
                        EndElement endElement = nextEvent.asEndElement();
                        String qName = endElement.getName().getLocalPart();

                        logger.info("End element: </" + qName + ">");

                        switch (qName.toLowerCase()) {
                            case "candy":
                                parsedCandies.addCandy(candy);
                                candy = new Candy();
                                break;
                            case "ingredients":
                                candy.setIngredients(ingredients);
                                ingredients = new IngredientsType();
                                break;
                            case "value":
                                candy.setValue(value);
                                value = new ValueType();
                                break;
                            default:
                                break;
                        }
                    }

                    if (nextEvent.isEndDocument()) {
                        logger.info("XML document parsing finished.");
                        break;
                    }
                }
            } else {
                logger.severe("XML file was not found in resources.");
            }
        } catch (IOException | XMLStreamException e) {
            logger.severe("StAX parsing error: " + e.getMessage());
        }

        return parsedCandies;
    }
}
