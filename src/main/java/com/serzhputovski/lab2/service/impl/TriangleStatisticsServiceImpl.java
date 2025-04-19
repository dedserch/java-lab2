package com.serzhputovski.lab2.service.impl;

import com.serzhputovski.lab2.entity.Triangle;
import com.serzhputovski.lab2.entity.TriangleType;
import com.serzhputovski.lab2.service.TriangleStatisticsService;
import com.serzhputovski.lab2.service.TriangleService;
import com.serzhputovski.lab2.service.impl.TriangleServiceImpl;
import com.serzhputovski.lab2.util.TriangleTypeUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TriangleStatisticsServiceImpl implements TriangleStatisticsService {
    private static final Logger logger = LogManager.getLogger(TriangleStatisticsServiceImpl.class);
    private final TriangleService basicService;

    public TriangleStatisticsServiceImpl(TriangleService basicService) {
        this.basicService = basicService;
    }

    public TriangleStatisticsServiceImpl() {
        this(new TriangleServiceImpl());
    }

    @Override
    public Map<TriangleType, Long> countByType(List<Triangle> triangles) {
        Map<TriangleType, Long> result = triangles.stream()
                .collect(Collectors.groupingBy(
                        TriangleTypeUtil::determine,
                        Collectors.counting()
                ));
        logger.info("countByType: {}", result);
        return result;
    }

    @Override
    public Map<TriangleType, Triangle> maxByArea(List<Triangle> triangles) {
        return extremeBy(triangles, basicService::calculateArea, Comparator.naturalOrder(), "maxByArea");
    }

    @Override
    public Map<TriangleType, Triangle> minByArea(List<Triangle> triangles) {
        return extremeBy(triangles, basicService::calculateArea, Comparator.reverseOrder(), "minByArea");
    }

    @Override
    public Map<TriangleType, Triangle> maxByPerimeter(List<Triangle> triangles) {
        return extremeBy(triangles, basicService::calculatePerimeter, Comparator.naturalOrder(), "maxByPerimeter");
    }

    @Override
    public Map<TriangleType, Triangle> minByPerimeter(List<Triangle> triangles) {
        return extremeBy(triangles, basicService::calculatePerimeter, Comparator.reverseOrder(), "minByPerimeter");
    }

    private Map<TriangleType, Triangle> extremeBy(
            List<Triangle> triangles,
            Function<Triangle, Double> metric,
            Comparator<Double> cmp,
            String action
    ) {
        Map<TriangleType, Triangle> result = triangles.stream()
                .collect(Collectors.groupingBy(
                        TriangleTypeUtil::determine,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(metric, cmp)),
                                opt -> opt.orElse(null)
                        )
                ));
        logger.info("{} result: {}", action, result);
        return result;
    }
}
