package com.serzhputovski.lab2.validator.impl;

import com.serzhputovski.lab2.entity.Triangle;
import com.serzhputovski.lab2.validator.TriangleValidator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleValidatorImpl implements TriangleValidator {
    private static final Logger logger = LogManager.getLogger(TriangleValidatorImpl.class);

    public boolean isValid(Triangle triangle) {
        boolean valid = triangle != null &&
                (triangle.getA() + triangle.getB() > triangle.getC()) &&
                (triangle.getA() + triangle.getC() > triangle.getB()) &&
                (triangle.getB() + triangle.getC() > triangle.getA());
        if(!valid) {
            logger.error("Triangle is not valid");
        }
        else {
            logger.info("Triangle is valid");
        }
        return valid;
    }
}
