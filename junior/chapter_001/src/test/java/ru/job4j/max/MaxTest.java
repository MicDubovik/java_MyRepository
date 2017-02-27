package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;



public class MaxTest {

    /**
     * тест для определения максимального из 2-х чисел
     */

    @Test
    public void testMax() {

        final Max testMax = new Max();

        final int  result = testMax.max(15,25);

        assertThat(result, is(25));

    }
    /**
     * тест для определения максимального из 3-х чисел
     */

    @Test
    public void testMaxFrom3() {

        final Max testMax = new Max();

        final int  result = testMax.max(15,25,3);

        assertThat(result, is(25));

    }


}

