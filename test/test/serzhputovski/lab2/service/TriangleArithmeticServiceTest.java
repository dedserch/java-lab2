package test.serzhputovski.lab2.service;

import com.serzhputovski.lab2.creator.TriangleFactory;
import com.serzhputovski.lab2.creator.impl.TriangleFactoryImpl;
import com.serzhputovski.lab2.entity.Triangle;
import com.serzhputovski.lab2.exception.TriangleArithmeticException;
import com.serzhputovski.lab2.service.TriangleArithmeticService;
import com.serzhputovski.lab2.service.impl.TriangleArithmeticServiceImpl;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TriangleArithmeticServiceTest {
    private static TriangleArithmeticService arithmeticService;
    private static TriangleFactory triangleFactory;

    @BeforeMethod
    public void setUp() {
        triangleFactory = new TriangleFactoryImpl();
        arithmeticService = new TriangleArithmeticServiceImpl();
    }

    @Test
    public void testAdd() {
        Triangle t1 = triangleFactory.createTriangle(3, 4, 5);
        Triangle t2 = triangleFactory.createTriangle(2, 3, 4);
        Triangle result = arithmeticService.add(t1, t2);

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(result.getA()).as("Side A").isEqualTo(5);
        softly.assertThat(result.getB()).as("Side B").isEqualTo(7);
        softly.assertThat(result.getC()).as("Side C").isEqualTo(9);
        softly.assertAll();
    }

    @Test
    public void testSubtract() {
        Triangle t1 = triangleFactory.createTriangle(10, 12, 15);
        Triangle t2 = triangleFactory.createTriangle(3, 4, 5);
        Triangle result = arithmeticService.subtract(t1, t2);

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(result.getA()).as("Side A").isEqualTo(7);
        softly.assertThat(result.getB()).as("Side B").isEqualTo(8);
        softly.assertThat(result.getC()).as("Side C").isEqualTo(10);
        softly.assertAll();
    }

    @Test
    public void testMultiply() {
        Triangle t = triangleFactory.createTriangle(3, 4, 5);
        Triangle result = arithmeticService.multiply(t, 2);

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(result.getA()).as("Side A").isEqualTo(6);
        softly.assertThat(result.getB()).as("Side B").isEqualTo(8);
        softly.assertThat(result.getC()).as("Side C").isEqualTo(10);
        softly.assertAll();
    }

    @Test
    public void testDivide() {
        Triangle t = triangleFactory.createTriangle(6, 8, 10);
        Triangle result = arithmeticService.divide(t, 2);

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(result.getA()).as("Side A").isEqualTo(3);
        softly.assertThat(result.getB()).as("Side B").isEqualTo(4);
        softly.assertThat(result.getC()).as("Side C").isEqualTo(5);
        softly.assertAll();
    }

    @Test(expectedExceptions = TriangleArithmeticException.class)
    public void testDivideByZero() {
        Triangle t = triangleFactory.createTriangle(6, 8, 10);
        arithmeticService.divide(t, 0);
    }
}
