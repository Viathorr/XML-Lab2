package com.xmlparser;

import com.xmlparser.candies.Candies;
import com.xmlparser.candies.comparator.CandiesEnergyComparator;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXCandiesParser {
    private static final Logger logger = Logger.getLogger(SAXCandiesParser.class.getName());

    public static void main(String[] args) {
        logger.info("Parsing a \"Candies.xml\" file with SAX Parser.");

        Candies parsedCandies = parse("Candies.xml");
        parsedCandies.getCandies().forEach(System.out::println);

        logger.info("Sorting parsed candies be Energy(cal) value in ascending order.");
        parsedCandies.sortCandies(new CandiesEnergyComparator());
        parsedCandies.getCandies().forEach(System.out::println);
    }

    public static Candies parse(String xmlPath) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try (InputStream xmlStream = XMLValidator.class.getClassLoader().getResourceAsStream(xmlPath)) {
            if (xmlStream != null) {
                SAXParser saxParser = saxParserFactory.newSAXParser();
                SAXCandiesHandler handler = new SAXCandiesHandler();

                saxParser.parse(xmlStream, handler);

                Candies parsedCandies = handler.getCandies();

                logger.info("Parsing with SAX successful for XML file: " + xmlPath);

                return parsedCandies;
            } else {
                logger.severe("XML file was not found in resources.");
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            logger.severe("Parsing error: " + e.getMessage());
        }

        return new Candies();
    }
}
