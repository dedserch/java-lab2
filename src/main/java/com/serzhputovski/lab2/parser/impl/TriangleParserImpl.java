package com.serzhputovski.lab2.parser.impl;

import com.serzhputovski.lab2.parser.TriangleParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class TriangleParserImpl implements TriangleParser {
    private static final Logger logger = LogManager.getLogger(TriangleParserImpl.class);
    private static final String DELIMITER = "\\s+";
    private static final int EXPECTED = 3;

    @Override
    public Optional<int[]> parse(String line) {
        if (line == null || line.isBlank()) {
            logger.warn("Empty or null line, skipping");
            return Optional.empty();
        }
        String[] parts = line.trim().split(DELIMITER);
        if (parts.length != EXPECTED) {
            logger.warn("Wrong number of parts ({}): '{}'", parts.length, line);
            return Optional.empty();
        }
        try {
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            int c = Integer.parseInt(parts[2]);
            logger.info("Parsed sides: {}, {}, {}", a, b, c);
            return Optional.of(new int[]{a, b, c});
        } catch (NumberFormatException ex) {
            logger.warn("Cannot parse integers from '{}'", line, ex);
            return Optional.empty();
        }
    }
}