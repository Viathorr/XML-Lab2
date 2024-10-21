package com.xmlparser;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.Characters;
import java.io.FileReader;
import java.util.logging.Logger;

public class StAXCandiesParser {
    private static final Logger logger = Logger.getLogger(StAXCandiesParser.class.getName());

    public static void main(String[] args) {
        logger.info("Parsing a \"Candies.xml\" file with StAX Parser.");

    }
}
