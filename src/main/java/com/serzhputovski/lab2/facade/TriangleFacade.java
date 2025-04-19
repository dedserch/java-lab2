package com.serzhputovski.lab2.facade;

import com.serzhputovski.lab2.reader.TriangleFileReader;
import com.serzhputovski.lab2.parser.TriangleParser;
import com.serzhputovski.lab2.creator.TriangleFactory;
import com.serzhputovski.lab2.service.TriangleStatisticsService;
import com.serzhputovski.lab2.entity.Triangle;
import com.serzhputovski.lab2.exception.TriangleFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class TriangleFacade {
    private static final Logger logger = LogManager.getLogger(TriangleFacade.class);

    private final TriangleFileReader reader;
    private final TriangleParser parser;
    private final TriangleFactory factory;
    private final TriangleStatisticsService statsService;

    public TriangleFacade(
            TriangleFileReader reader,
            TriangleParser parser,
            TriangleFactory factory,
            TriangleStatisticsService statsService
    ) {
        this.reader = reader;
        this.parser = parser;
        this.factory = factory;
        this.statsService = statsService;
    }

    public void execute(String path) throws TriangleFileException {
        List<String> lines = reader.readLines(path);
        List<Triangle> triangles = new ArrayList<>();

        for (String line : lines) {
            parser.parse(line).ifPresent(parts -> {
                try {
                    triangles.add(factory.createTriangle(parts[0], parts[1], parts[2]));
                } catch (Exception ex) {
                    logger.warn("Skipping invalid triangle: {}", ex.getMessage());
                }
            });
        }

        logger.info("Всего треугольников: {}", triangles.size());
        logger.info("По типам: {}", statsService.countByType(triangles));
        logger.info("Макс/мин по площади: {}/{}",
                statsService.maxByArea(triangles),
                statsService.minByArea(triangles));
        logger.info("Макс/мин по периметру: {}/{}",
                statsService.maxByPerimeter(triangles),
                statsService.minByPerimeter(triangles));
    }
}
