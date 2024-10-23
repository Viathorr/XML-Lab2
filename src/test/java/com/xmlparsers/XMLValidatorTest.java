package com.xmlparsers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class XMLValidatorTest {

    @Test
    void testValidXML() {
        String xsdPath = "candies.xsd";
        String xmlPath = "valid_candies.xml";

        assertTrue(XMLValidator.validateXMLSchema(xsdPath, xmlPath));
    }

    @Test
    void testInvalidXML() {
        String xsdPath = "candies.xsd";
        String xmlPath = "invalid_candies.xml";

        assertFalse(XMLValidator.validateXMLSchema(xsdPath, xmlPath));
    }
}