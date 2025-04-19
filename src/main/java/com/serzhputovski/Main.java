package com.serzhputovski;

import com.serzhputovski.lab2.creator.impl.TriangleFactoryImpl;
import com.serzhputovski.lab2.exception.TriangleFileException;
import com.serzhputovski.lab2.facade.TriangleFacade;
import com.serzhputovski.lab2.parser.impl.TriangleParserImpl;
import com.serzhputovski.lab2.reader.impl.TriangleFileReaderImpl;
import com.serzhputovski.lab2.service.impl.TriangleStatisticsServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        String triangleFilePath = "src/main/resources/data.txt";

        TriangleFacade facade = new TriangleFacade(
                new TriangleFileReaderImpl(),
                new TriangleParserImpl(),
                new TriangleFactoryImpl(),
                new TriangleStatisticsServiceImpl()
        );

        try {
            facade.execute(triangleFilePath);
        } catch (TriangleFileException e) {
            logger.error("Ошибка при выполнении фасада: {}", e.getMessage(), e);
        }
    }
}