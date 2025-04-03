package com.serzhputovski.lab2.service.impl;

import com.serzhputovski.lab2.creator.TriangleFactory;
import com.serzhputovski.lab2.entity.Triangle;
import com.serzhputovski.lab2.exception.TriangleArithmeticException;
import com.serzhputovski.lab2.service.TriangleArithmeticService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleArithmeticServiceImpl implements TriangleArithmeticService {
    private static final Logger logger = LogManager.getLogger(TriangleArithmeticServiceImpl.class);

    @Override
    public Triangle add(Triangle t1, Triangle t2) {
        int a = t1.getA() + t2.getA();
        int b = t1.getB() + t2.getB();
        int c = t1.getC() + t2.getC();
        logger.info("Adding triangles: " + t1 + " + " + t2);
        return new Triangle(a, b, c);
    }

    @Override
    public Triangle subtract(Triangle t1, Triangle t2) {
        int a = Math.abs(t1.getA() - t2.getA());
        int b = Math.abs(t1.getB() - t2.getB());
        int c = Math.abs(t1.getC() - t2.getC());
        logger.info("Subtracting triangles: " + t1 + " - " + t2);
        return new Triangle(a, b, c);
    }

    @Override
    public Triangle multiply(Triangle t, int factor) {
        int a = t.getA() * factor;
        int b = t.getB() * factor;
        int c = t.getC() * factor;
        logger.info("Multiplying triangle: " + t + " * " + factor);
        return new Triangle(a, b, c);
    }

    @Override
    public Triangle divide(Triangle t, int divisor) {
        if(divisor == 0) {
            logger.error("Division by zero attempted on triangle: " + t);
            throw new TriangleArithmeticException("Divisor cannot be zero");
        }
        int a = t.getA() / divisor;
        int b = t.getB() / divisor;
        int c = t.getC() / divisor;
        logger.info("Dividing triangle: " + t + " / " + divisor);
        return new Triangle(a, b, c);
    }
}
