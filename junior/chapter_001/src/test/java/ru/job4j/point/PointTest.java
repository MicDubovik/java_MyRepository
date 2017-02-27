package ru.job4j.point;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Katy on 22.02.2017.
 */
public class PointTest {
    @Test
    public void distanceTo()   {
        final Point testPoint = new Point(0,0);
        final Point testPoint2 = new Point(0,2);

        final double  result = testPoint.distanceTo(testPoint2);

        assertThat(result, is((double)2));

    }

}