package ru.job4j;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Katy on 22.02.2017.
 */
public class TriangleTest {



    @Test
    public void Testarea() {
        final Triangle testPoint1 = new Triangle(new Point(0,0),new Point(0,3),new Point(4,0)  );



        final double  result = testPoint1.area() ;

        assertThat(result, closeTo(8.48, 0.02));

    }





}