package com.serzhputovski.lab2.service.impl;

import com.serzhputovski.lab2.entity.Triangle;
import com.serzhputovski.lab2.service.TriangleService;

public class TriangleServiceImpl implements TriangleService {
    @Override
    public double calculateArea(Triangle triangle) {
        double semiPerimeter = calculatePerimeter(triangle) / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - triangle.getA()) * (semiPerimeter - triangle.getB()) * (semiPerimeter - triangle.getC()));
    }

    @Override
    public double calculatePerimeter(Triangle triangle) {
        return triangle.getA() + triangle.getB() + triangle.getC();
    }
}
