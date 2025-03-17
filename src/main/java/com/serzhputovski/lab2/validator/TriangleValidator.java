package com.serzhputovski.lab2.validator;

import com.serzhputovski.lab2.entity.Triangle;

public interface TriangleValidator {
    public int calculateArea(Triangle triangle);

    public int calculatePerimeter(Triangle triangle);
}
