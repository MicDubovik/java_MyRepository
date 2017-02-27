package ru.job4j.calculator;

        import org.junit.Test;
        import static org.hamcrest.core.Is.is;
        import static org.junit.Assert.assertThat;



class CalculatorTest{

    /**
     * тест метода сложения
     */

    @Test
    public void testAdd(){

        final Calculator calc = new Calculator();
        calc.add(-2,-10);
        final double result = calc.getResult();
        assertThat(result,is(-12d));

    }

    /**
     * тест метода вычитания
     */

    @Test
    public void testSub(){

        final Calculator calc = new Calculator();
        calc.sub(-2,-10);
        final double result = calc.getResult();
        assertThat(result,is(8d));

    }

    /**
     * тест метода деления
     */


    @Test
    public void testDiv(){

        final Calculator calc = new Calculator();
        calc.div(25,5);
        final double result = calc.getResult();
        assertThat(result,is(5d));

    }

    /**
     * тест метода умножения
     */

    @Test
    public void testMul(){

        final Calculator calc = new Calculator();
        calc.mul(-10,-5);
        final double result = calc.getResult();
        assertThat(result,is(50d));

    }



}