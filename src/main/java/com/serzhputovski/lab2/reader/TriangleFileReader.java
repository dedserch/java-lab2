package com.serzhputovski.lab2.reader;

import com.serzhputovski.lab2.exception.TriangleFileException;

import java.util.List;

public interface TriangleFileReader {
    List<String> readLines(String path) throws TriangleFileException;
}
