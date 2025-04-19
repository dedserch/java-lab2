package com.serzhputovski.lab2.reader.impl;

import com.serzhputovski.lab2.exception.TriangleFileException;
import com.serzhputovski.lab2.reader.TriangleFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TriangleFileReaderImpl implements TriangleFileReader {
    private static final Logger logger = LogManager.getLogger(TriangleFileReaderImpl.class);

    @Override
    public List<String> readLines(String path) throws TriangleFileException {
        try {
            logger.info("Reading file: {}", path);
            return Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            logger.error("Cannot read file: {}", path, e);
            throw new TriangleFileException("Error reading file " + path, e);
        }
    }
}