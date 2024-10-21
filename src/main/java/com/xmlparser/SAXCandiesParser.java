package com.xmlparser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.logging.Logger;

public class SAXCandiesParser {
    private static final Logger logger = Logger.getLogger(SAXCandiesParser.class.getName());

    public static void main(String[] args) {
        logger.info("Parsing a \"Candies.xml\" file with SAX Parser.");

    }
}
