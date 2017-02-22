package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;



public class MaxTest {

    /**
     * тест для определения максимального из чисел
     */

    @Test
    public void testMax() {

        final Max testMax = new Max();

        final int  result = testMax.max(15,25);

        assertThat(result, is(25));

    }
}

