package com.xmlparsers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class XMLValidatorTest {
    XMLValidator validator = new XMLValidator();

    @Test
    void testValidXML() {
        String xsdPath = "candies.xsd";
        String xmlPath = "valid_candies.xml";

        assertTrue(validator.validateXMLSchema(xsdPath, xmlPath));
    }

    @Test
    void testInvalidXML() {
        String xsdPath = "candies.xsd";
        String xmlPath = "invalid_candies.xml";

        assertFalse(validator.validateXMLSchema(xsdPath, xmlPath));
    }
}