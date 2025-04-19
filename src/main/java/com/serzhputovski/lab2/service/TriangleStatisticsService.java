package com.serzhputovski.lab2.service;

import com.serzhputovski.lab2.entity.Triangle;
import com.serzhputovski.lab2.entity.TriangleType;

import java.util.List;
import java.util.Map;

public interface TriangleStatisticsService {
    Map<TriangleType, Long> countByType(List<Triangle> triangles);
    Map<TriangleType, Triangle> maxByArea(List<Triangle> triangles);
    Map<TriangleType, Triangle> minByArea(List<Triangle> triangles);
    Map<TriangleType, Triangle> maxByPerimeter(List<Triangle> triangles);
    Map<TriangleType, Triangle> minByPerimeter(List<Triangle> triangles);
}