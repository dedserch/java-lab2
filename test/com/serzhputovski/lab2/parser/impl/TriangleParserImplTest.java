package com.serzhputovski.lab2.parser.impl;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.*;

public class TriangleParserImplTest {
    private TriangleParserImpl parser;

    @BeforeClass
    public void setUp() {
        parser = new TriangleParserImpl();
    }

    @Test
    public void testParseValidInput() {
        Optional<int[]> result = parser.parse("3 4 5");
        assertTrue(result.isPresent());
        assertEquals(result.get()[0], 3);
        assertEquals(result.get()[1], 4);
        assertEquals(result.get()[2], 5);
    }

    @Test
    public void testParseInputWithExtraSpaces() {
        Optional<int[]> result = parser.parse("   7    8   9  ");
        assertTrue(result.isPresent());
        assertEquals(result.get()[0], 7);
        assertEquals(result.get()[1], 8);
        assertEquals(result.get()[2], 9);
    }

    @Test
    public void testParseInvalidInputFormat() {
        Optional<int[]> result = parser.parse("1 2");
        assertFalse(result.isPresent());
    }

    @Test
    public void testParseEmptyInput() {
        Optional<int[]> result = parser.parse("");
        assertFalse(result.isPresent());
    }

    @Test
    public void testParseNullInput() {
        Optional<int[]> result = parser.parse(null);
        assertFalse(result.isPresent());
    }

    @Test
    public void testParseNonInteger() {
        Optional<int[]> result = parser.parse("1 two 3");
        assertFalse(result.isPresent());
    }

    @Test
    public void testParseNegativeNumbers() {
        Optional<int[]> result = parser.parse("-1 -2 -3");
        assertTrue(result.isPresent());
        assertEquals(result.get()[0], -1);
        assertEquals(result.get()[1], -2);
        assertEquals(result.get()[2], -3);
    }
}