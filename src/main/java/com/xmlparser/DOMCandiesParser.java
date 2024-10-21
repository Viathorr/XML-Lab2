package com.xmlparser;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.logging.Logger;

public class DOMCandiesParser {
    private static final Logger logger = Logger.getLogger(DOMCandiesParser.class.getName());

    public static void main(String[] args) {
        logger.info("Parsing a \"Candies.xml\" file with DOM Parser.");
    }
}
