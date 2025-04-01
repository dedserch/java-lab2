package test.serzhputovski.lab2.service;

import com.serzhputovski.lab2.entity.Triangle;
import com.serzhputovski.lab2.service.TriangleService;
import com.serzhputovski.lab2.service.impl.TriangleServiceImpl;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.within;

public class TriangleServiceTest {
    private TriangleService triangleService;

    @BeforeMethod
    public void setUp() {
        triangleService = new TriangleServiceImpl();
    }

    @Test
    public void testCalculatePerimeter() {
        Triangle triangle = new Triangle(3, 4, 5);
        double expected = 12.0;
        double actual = triangleService.calculatePerimeter(triangle);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(actual).as("Perimeter").isEqualTo(expected);
        softly.assertAll();
    }

    @Test
    public void testCalculateArea() {
        Triangle triangle = new Triangle(3, 4, 5);
        double expected = 6.0;
        double actual = triangleService.calculateArea(triangle);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(actual).as("Area").isCloseTo(expected, within(0.0001));
        softly.assertAll();
    }

    @Test
    public void testCalculateAreaWithDifferentTriangle() {
        Triangle triangle = new Triangle(6, 8, 10);
        double expected = 24.0;
        double actual = triangleService.calculateArea(triangle);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(actual).as("Area of different triangle").isCloseTo(expected, within(0.0001));
        softly.assertAll();
    }
}
