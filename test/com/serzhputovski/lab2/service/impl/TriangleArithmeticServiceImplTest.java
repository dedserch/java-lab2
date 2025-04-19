package com.serzhputovski.lab2.service.impl;

import com.serzhputovski.lab2.entity.Triangle;
import com.serzhputovski.lab2.exception.TriangleArithmeticException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleArithmeticServiceImplTest {
    private TriangleArithmeticServiceImpl service;
    private Triangle t1;
    private Triangle t2;

    @BeforeClass
    public void setUp() {
        service = new TriangleArithmeticServiceImpl();
        t1 = new Triangle(3, 4, 5);
        t2 = new Triangle(1, 2, 3);
    }

    @Test
    public void testAdd() {
        Triangle result = service.add(t1, t2);
        assertEquals(result.getA(), 4);
        assertEquals(result.getB(), 6);
        assertEquals(result.getC(), 8);
    }

    @Test
    public void testSubtract() {
        Triangle result = service.subtract(t1, t2);
        assertEquals(result.getA(), 2);
        assertEquals(result.getB(), 2);
        assertEquals(result.getC(), 2);
    }

    @Test
    public void testMultiply() {
        Triangle result = service.multiply(t1, 2);
        assertEquals(result.getA(), 6);
        assertEquals(result.getB(), 8);
        assertEquals(result.getC(), 10);
    }

    @Test
    public void testDivide() {
        Triangle result = service.divide(t1, 2);
        assertEquals(result.getA(), 1);
        assertEquals(result.getB(), 2);
        assertEquals(result.getC(), 2);
    }

    @Test(expectedExceptions = TriangleArithmeticException.class)
    public void testDivideByZero() {
        service.divide(t1, 0);
    }
}
