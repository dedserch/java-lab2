package com.serzhputovski.lab2.parser;

import com.serzhputovski.lab2.entity.Triangle;

import java.util.Optional;

public interface TriangleParser {
    Optional<Triangle> parse(String input);
}
