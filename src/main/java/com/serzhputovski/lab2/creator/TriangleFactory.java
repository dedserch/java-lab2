package com.serzhputovski.lab2.creator;

import com.serzhputovski.lab2.entity.Triangle;

public interface TriangleFactory {
    public Triangle createTriangle(int a, int b, int c);
}
