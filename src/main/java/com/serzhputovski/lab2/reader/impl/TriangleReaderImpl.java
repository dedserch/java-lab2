package com.serzhputovski.lab2.reader.impl;

import com.serzhputovski.lab2.entity.Triangle;
import com.serzhputovski.lab2.parser.TriangleParser;
import com.serzhputovski.lab2.reader.TriangleReader;
import com.serzhputovski.lab2.reader.TriangleReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TriangleReaderImpl implements TriangleReader {
    private static final Logger logger = LogManager.getLogger(TriangleReaderImpl.class);
    private final TriangleParser parser;

    public TriangleReaderImpl(TriangleParser parser) {
        this.parser = parser;
    }

    @Override
    public List<Triangle> readTriangles(String filePath) {
        List<Triangle> triangles = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = reader.readLine()) != null){
                if(line.trim().isEmpty() || line.trim().startsWith("#")){
                    continue;
                }
                Optional<Triangle> triangle = parser.parse(line);
                triangle.ifPresent(triangles::add);
            }
        } catch(FileNotFoundException e){
            logger.error("File not found: " + filePath, e);
        } catch(IOException e){
            logger.error("Error reading file: " + filePath, e);
        }
        return triangles;
    }
}
