package com.serzhputovski.lab2.parser.impl;

import com.serzhputovski.lab2.creator.TriangleFactory;
import com.serzhputovski.lab2.entity.Triangle;
import com.serzhputovski.lab2.parser.TriangleParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class TriangleParserImpl implements TriangleParser {
    private static final Logger logger = LogManager.getLogger(TriangleParserImpl.class);
    private final TriangleFactory triangleFactory;

    public TriangleParserImpl(TriangleFactory triangleFactory) {
        this.triangleFactory = triangleFactory;
    }

    @Override
    public Optional<Triangle> parse(String line) {
        if(line == null || line.trim().isEmpty()){
            logger.error("Empty or null line encountered.");
            return Optional.empty();
        }
        String[] tokens = line.trim().split("[,\\s]+");
        if(tokens.length != 3){
            logger.error("Incorrect format: " + line);
            return Optional.empty();
        }
        try {
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);
            int c = Integer.parseInt(tokens[2]);
            Triangle triangle = triangleFactory.createTriangle(a, b, c);
            return Optional.of(triangle);
        } catch (NumberFormatException e){
            logger.error("Number conversion error: " + line, e);
        } catch (IllegalArgumentException e){
            logger.error("Error creating triangle: " + line, e);
        }
        return Optional.empty();
    }
}
