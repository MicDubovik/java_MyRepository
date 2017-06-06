package ru.job4j.paint;

import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для отрисовки треугольника
 */
public class PaintTest {
    @Test
    public void piramid() throws Exception {

        Paint paint = new Paint();

        String result = paint.piramid(2);

        assertThat(result, is(" ^\n^^^\n"));


    }
}

