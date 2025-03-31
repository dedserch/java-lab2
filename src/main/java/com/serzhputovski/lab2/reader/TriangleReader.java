package com.serzhputovski.lab2.reader;

import com.serzhputovski.lab2.entity.Triangle;

import java.util.List;

public interface TriangleReader {
    List<Triangle> readTriangles(String filePath);
}
