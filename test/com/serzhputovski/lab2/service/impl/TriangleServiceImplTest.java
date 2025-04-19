package com.serzhputovski.lab2.service.impl;

import com.serzhputovski.lab2.entity.Triangle;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleServiceImplTest {
    private TriangleServiceImpl service;
    private Triangle triangle;

    @BeforeClass
    public void setUp() {
        service = new TriangleServiceImpl();
        triangle = new Triangle(3, 4, 5); // прямоугольный треугольник
    }

    @Test
    public void testCalculatePerimeter() {
        double perimeter = service.calculatePerimeter(triangle);
        assertEquals(perimeter, 12.0);
    }

    @Test
    public void testCalculateArea() {
        double area = service.calculateArea(triangle);
        assertEquals(area, 6.0);
    }
}
