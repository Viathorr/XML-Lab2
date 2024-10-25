package com.xmlparsers;

import com.xmlparsers.candies.Candies;
import com.xmlparsers.candies.Candy;
import com.xmlparsers.candies.IngredientsType;
import com.xmlparsers.candies.ValueType;
import com.xmlparsers.candies.enums.ChocolateTypeEnum;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SAXCandiesParserTest {
    SAXCandiesParser parser = new SAXCandiesParser();

    @Test
    void testCorrectParsing() {
        Candies parsedCandies = parser.parse("valid_candies.xml");

        List<Candy> candies = parsedCandies.getCandies();
        IngredientsType expectedIngredients = new IngredientsType(0, 15, 2, 1, ChocolateTypeEnum.MILK);
        ValueType expectedValue = new ValueType(0, 4, 12);

        assertEquals(candies.size(), 1);
        assertEquals(candies.getFirst().getName(), "Lindor Chocolate with Hazelnut");
        assertEquals(candies.getFirst().getId(), "candy01");
        assertEquals(candies.getFirst().getEnergy(), 47);
        assertEquals(candies.getFirst().getIngredients(), expectedIngredients);
        assertEquals(candies.getFirst().getValue(), expectedValue);
        assertEquals(candies.getFirst().getProduction(), "Lindt");
    }

    @Test
    void testFileNonExistence() {
        Candies parsedCandies = parser.parse("invalid_file.xml");

        assertNull(parsedCandies.getCandies());
    }
}