package com.serzhputovski.lab2.creator;

import com.serzhputovski.lab2.entity.Triangle;
import com.serzhputovski.lab2.exception.InvalidTriangleException;

public interface TriangleFactory {
    Triangle createTriangle(int a, int b, int c) throws InvalidTriangleException;
}
