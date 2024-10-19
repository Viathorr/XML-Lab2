package com.xmlparser;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class XMLValidator {
    private static final Logger logger = Logger.getLogger(XMLValidator.class.getName());

    public static void main(String[] args) {
        logger.info("Validation of \"Candies.xml\" file against the XSD schema \"Candies.xsd\".");

        validateXMLSchema("Candies.xsd", "Candies.xml");
    }

    public static boolean validateXMLSchema(String xsdPath, String xmlPath) {
        try (InputStream xsdStream = XMLValidator.class.getClassLoader().getResourceAsStream(xsdPath);
             InputStream xmlStream = XMLValidator.class.getClassLoader().getResourceAsStream(xmlPath)) {
            if (xsdStream != null && xmlStream != null) {
                SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
                Schema schema = factory.newSchema(new StreamSource(xsdStream));

                Validator validator = schema.newValidator();
                validator.validate(new StreamSource(xmlStream));

                logger.info("Validation successful for XML file: " + xmlPath);
            } else {
                logger.severe(String.format("File/-s \"%s\" and/or \"%s\" do(-es) not exist.", xsdPath, xmlPath));
                return false;
            }
        } catch (IOException | SAXException e) {
            logger.log(Level.SEVERE, "Validation error: " + e.getMessage(), e);
            return false;
        }
        return true;
    }
}
