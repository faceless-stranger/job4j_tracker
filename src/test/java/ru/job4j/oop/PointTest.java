package oop;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void distance3d() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(2, 3, 6);
        double rsl = a.distance3d(b);
        double expected = 7;
        Assert.assertEquals(expected, rsl, 0.001);
    }
}