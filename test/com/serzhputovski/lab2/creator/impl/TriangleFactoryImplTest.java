package com.serzhputovski.lab2.creator.impl;

import com.serzhputovski.lab2.entity.Triangle;
import com.serzhputovski.lab2.exception.InvalidTriangleException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleFactoryImplTest {

    private TriangleFactoryImpl factory;

    @BeforeClass
    public void setUp() {
        factory = new TriangleFactoryImpl();
    }

    @Test(expectedExceptions = InvalidTriangleException.class)
    public void testCreateTriangleWithNegativeSide() throws InvalidTriangleException {
        factory.createTriangle(-3, 4, 5);
    }

    @Test(expectedExceptions = InvalidTriangleException.class)
    public void testCreateInvalidTriangleByInequality() throws InvalidTriangleException {
        factory.createTriangle(1, 2, 10);
    }
}
