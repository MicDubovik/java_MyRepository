package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;



public class MaxTest {

    /**
     * тест метода сложения
     */

    @Test
    public void testAdd() {

        final Max testMax = new Max();

        final String  result = testMax.max(15,25);
        assertThat(result, is("first < second"));

    }
}

