package com.xmlparsers;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class XSLTransformerTest {

    @Test
    void testXSLTransformation() throws IOException {
        XSLTransformer transformer = new XSLTransformer();
        String outputFilePath = "src/test/resources/transformedXML/candies.xml";
        String expectedOutputFilePath = "src/test/resources/transformedXML/valid_candies.xml";

        transformer.transform("valid_candies.xml", "candies.xsl",
                outputFilePath);

        File outputFile = new File(outputFilePath);
        assertTrue(outputFile.exists());

        String outputContent = new String(Files.readAllBytes(Paths.get(outputFilePath)));
        String expectedOutput = new String(Files.readAllBytes(Paths.get(expectedOutputFilePath)));

        String normalizedOutput = outputContent.replaceAll("\\s+", "");
        String normalizedExpected = expectedOutput.replaceAll("\\s+", "");

        assertEquals(normalizedExpected, normalizedOutput);
    }
}