package com.xmlparser;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class XMLValidator {
    public static void main(String[] args) {
        System.out.println("Validation of \"Candies.xml\" file against the XSD schema \"Cnadies.xsd\".");

        if (validateXMLSchema("Candie.xsd", "Candies.xml")) {
            System.out.println("Validation passed!");
        } else {
            System.out.println("Validation failed!");
        }
    }

    public static boolean validateXMLSchema(String xsdPath, String xmlPath) {
        try (InputStream xsdStream = XMLValidator.class.getClassLoader().getResourceAsStream(xsdPath);
             InputStream xmlStream = XMLValidator.class.getClassLoader().getResourceAsStream(xmlPath)) {
            if (xsdStream != null && xmlStream != null) {
                SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
                Schema schema = factory.newSchema(new StreamSource(xsdStream));

                Validator validator = schema.newValidator();
                validator.validate(new StreamSource(xmlStream));
            } else {
                System.out.printf("File/-s \"%s\" and/or \"%s\" do(-es)n't exist.\n", xsdPath, xmlPath);
                return false;
            }
        } catch (IOException | SAXException e) {
            System.out.println("Exception: " + e.getMessage());
            return false;
        }
        return true;
    }
}
