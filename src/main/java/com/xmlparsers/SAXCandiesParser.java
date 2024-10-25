package com.xmlparsers;

import generated.Candies;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXCandiesParser {
    private static final Logger logger = Logger.getLogger(SAXCandiesParser.class.getName());

    public Candies parse(String xmlPath) {
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
            logger.severe("SAX parsing error: " + e.getMessage());
        }

        return new Candies();
    }
}
