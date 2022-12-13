package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {
    @Test
    public void when00and40and04Then8() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        double expected = 8;
        assertThat(rsl).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void when03and40and00Then6() {
        Point a  = new Point(0, 3);
        Point b = new Point(4, 0);
        Point c = new Point(0, 0);
        Triangle triangl = new Triangle(a, b, c);
        double rsl = triangl.area();
        assertThat(rsl, closeTo(6, 0.001));
    }

    @Test
    public void when00and016and017ThenFalse() {
        Point a  = new Point(0, 0);
        Point b = new Point(0, 16);
        Point c = new Point(0, 17);
        Triangle triangl = new Triangle(a, b, c);
        double rsl = triangl.area();
        assertThat(rsl, closeTo(-1, 0.001));
    }

}