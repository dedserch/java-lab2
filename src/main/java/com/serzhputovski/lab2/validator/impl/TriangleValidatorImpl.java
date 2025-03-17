package com.serzhputovski.lab2.validator.impl;

import com.serzhputovski.lab2.entity.Triangle;
import com.serzhputovski.lab2.validator.TriangleValidator;

public class TriangleValidatorImpl implements TriangleValidator {

    @Override
    public int calculateArea(Triangle triangle) {
        double semiPerimeter = calculatePerimeter(triangle) / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - triangle.getA()) * (semiPerimeter - triangle.getB()) * (semiPerimeter - triangle.getC()));
    }

    @Override
    public int calculatePerimeter(Triangle triangle) {
        return triangle.getA() + triangle.getB() + triangle.getC();
    }

}
