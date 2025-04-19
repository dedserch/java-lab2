package com.serzhputovski.lab2.service.impl;

import com.serzhputovski.lab2.entity.Triangle;
import com.serzhputovski.lab2.entity.TriangleType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.*;

public class TriangleStatisticsServiceImplTest {
    private TriangleStatisticsServiceImpl statsService;
    private List<Triangle> triangles;

    @BeforeClass
    public void setUp() {
        statsService = new TriangleStatisticsServiceImpl();
        triangles = List.of(
                new Triangle(3, 4, 5),   // разносторонний
                new Triangle(5, 5, 5),   // равносторонний
                new Triangle(6, 6, 8),   // равнобедренный
                new Triangle(2, 2, 3)    // равнобедренный
        );
    }

    @Test
    public void testCountByType() {
        Map<TriangleType, Long> countMap = statsService.countByType(triangles);
        assertEquals(countMap.get(TriangleType.EQUILATERAL), Long.valueOf(1));
        assertEquals(countMap.get(TriangleType.ISOSCELES), Long.valueOf(2));
        assertEquals(countMap.get(TriangleType.SCALENE), Long.valueOf(1));
    }

    @Test
    public void testMaxByArea() {
        Map<TriangleType, Triangle> result = statsService.maxByArea(triangles);
        assertEquals(result.get(TriangleType.EQUILATERAL), new Triangle(5, 5, 5));
    }

    @Test
    public void testMinByArea() {
        Map<TriangleType, Triangle> result = statsService.minByArea(triangles);
        assertEquals(result.get(TriangleType.SCALENE), new Triangle(3, 4, 5));
    }

    @Test
    public void testMaxByPerimeter() {
        Map<TriangleType, Triangle> result = statsService.maxByPerimeter(triangles);
        assertEquals(result.get(TriangleType.ISOSCELES), new Triangle(6, 6, 8));
    }

    @Test
    public void testMinByPerimeter() {
        Map<TriangleType, Triangle> result = statsService.minByPerimeter(triangles);
        assertEquals(result.get(TriangleType.ISOSCELES), new Triangle(2, 2, 3));
    }
}
