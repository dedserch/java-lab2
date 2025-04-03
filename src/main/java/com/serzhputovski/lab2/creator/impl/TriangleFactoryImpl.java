package com.serzhputovski.lab2.creator.impl;

import com.serzhputovski.lab2.creator.TriangleFactory;
import com.serzhputovski.lab2.entity.Triangle;
import com.serzhputovski.lab2.exception.InvalidTriangleException;
import com.serzhputovski.lab2.validator.TriangleValidator;
import com.serzhputovski.lab2.validator.impl.TriangleValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleFactoryImpl implements TriangleFactory {
    private static final Logger logger = LogManager.getLogger(TriangleFactoryImpl.class);
    private static final TriangleValidator triangleValidator = new TriangleValidatorImpl();

    @Override
    public Triangle createTriangle(int a , int b , int c) throws InvalidTriangleException{
        logger.info("Creating Triangle");

        Triangle triangle = new Triangle(a, b, c);

        if(!triangleValidator.isValid(triangle)) {
            logger.error("Validator failed for Triangle");
            throw new InvalidTriangleException("Invalid Triangle data ");
        }

        logger.info("Triangle successfully created");
        return triangle;
    }

}
