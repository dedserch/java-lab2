package com.serzhputovski.lab2.service;

import com.serzhputovski.lab2.entity.Triangle;

public interface TriangleArithmeticService {
    Triangle add(Triangle t1, Triangle t2);
    Triangle subtract(Triangle t1, Triangle t2);
    Triangle multiply(Triangle t, int factor);
    Triangle divide(Triangle t, int divisor);
}
