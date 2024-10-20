package com.xmlparser;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.util.logging.Logger;

public class XSLTransformer {
    private static final Logger logger = Logger.getLogger(XMLValidator.class.getName());

    public static void main(String[] args) {
        logger.info("Transformation of \"Candies.xml\" file according to XSL \"Candies.xsl\".");

        transform("Candies.xml", "Candies.xsl");
    }

    public static void transform(String xmlPath, String xslPath) {
        try (InputStream xmlStream = XSLTransformer.class.getClassLoader().getResourceAsStream(xmlPath);
            InputStream xslStream = XSLTransformer.class.getClassLoader().getResourceAsStream(xslPath)) {
            if (xmlStream != null && xslStream != null) {
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer(new StreamSource(xslStream));

                String outputFilePath = String.format("src/main/resources/transformedXML/%s", xmlPath);
                StreamResult out = new StreamResult(new File(outputFilePath));
                transformer.transform(new StreamSource(xmlStream), out);

                logger.info("XSL Transformation successful for XML file: " + xmlPath);
            } else {
                logger.severe("One or both of the files was/-ere not found in resources.");
            }
        } catch (IOException | TransformerException e) {
            logger.severe("Transformation error: " + e.getMessage());
        }
    }
}
