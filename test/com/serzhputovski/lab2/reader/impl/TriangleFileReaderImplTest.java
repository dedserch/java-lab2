package com.serzhputovski.lab2.reader.impl;

import com.serzhputovski.lab2.exception.TriangleFileException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class TriangleFileReaderImplTest {
    private TriangleFileReaderImpl reader;

    @BeforeClass
    public void setUp() {
        reader = new TriangleFileReaderImpl();
    }

    @Test
    public void testValidFile() throws TriangleFileException {
        List<String> lines = reader.readLines("src/test/resources/valid.txt");
        assertFalse(lines.isEmpty());
    }

    @Test(expectedExceptions = TriangleFileException.class)
    public void testNonexistentFile() throws TriangleFileException {
        reader.readLines("nonexistent.txt");
    }

    @Test
    public void testEmptyFile() throws TriangleFileException {
        List<String> lines = reader.readLines("src/test/resources/empty.txt");
        assertTrue(lines.isEmpty());
    }
}