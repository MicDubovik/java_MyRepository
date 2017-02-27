package ru.job4j.point;

/**
 * Задача на опр-е расстояния между точками
 * И определения площади треугольника
 */

public class Point {
    public double x;
    public double y;

    /**
     * Конструктор класса Point
     * Инициализация полей
      * @param x
     * @param y
     */

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Метод определения расстояния между точками
     * Входной аргумент
     * @param point
     * Возвращаемое значение
     * @return
     */
    public double distanceTo(Point point) {

        return Math.sqrt(Math.pow(point.x-this.x,2)+Math.pow(point.y-this.y,2));

    }
}




