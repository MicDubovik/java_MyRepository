package ru.job4j.newFood;

import java.text.ParseException;

/**
 * Interface for extends method to select products (for future).
 */

public interface SelectProduct {
    /**
     * countDays.
     * @param food
     * @return
     * @throws ParseException
     */
    int countDays(Food food) throws ParseException;
}
