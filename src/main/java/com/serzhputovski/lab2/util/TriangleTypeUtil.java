package com.serzhputovski.lab2.util;

import com.serzhputovski.lab2.entity.Triangle;
import com.serzhputovski.lab2.entity.TriangleType;
import java.util.Arrays;

public class TriangleTypeUtil {
    public static TriangleType determine(Triangle t) {
        int a = t.getA();
        int b = t.getB();
        int c = t.getC();
        if (a == b && b == c) {
            return TriangleType.EQUILATERAL;
        }
        int[] sides = {a, b, c};
        Arrays.sort(sides);
        if (sides[0] * sides[0] + sides[1] * sides[1] == sides[2] * sides[2]) {
            return TriangleType.RIGHT;
        }
        if (a == b || b == c || a == c) {
            return TriangleType.ISOSCELES;
        }
        return TriangleType.SCALENE;
    }
}
