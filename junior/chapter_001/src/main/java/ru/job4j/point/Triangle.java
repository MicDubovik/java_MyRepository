package ru.job4j.point;

/**
 * Класс Треугольник
 */

public class Triangle {
    public Point a;
    public Point b;
    public Point c;

    /**
     * Конструктор
     * Параметры
     *
     * @param a
     * @param b
     * @param c
     */

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод определения площади треугольника
     *
     * @return возвращаемое значение
     * @pGerone полупериметр треугольника
     */

    public double area() {
        double pGerone = (a.distanceTo(b) + b.distanceTo(c) + a.distanceTo(c)) / 2;

        if ((a.distanceTo(b) + b.distanceTo(c) > a.distanceTo(c) && b.distanceTo(c) + a.distanceTo(c) > a.distanceTo(b) &&
                a.distanceTo(c) + a.distanceTo(b) > b.distanceTo(c))) {
            return Math.sqrt(pGerone * (pGerone - a.distanceTo(b)) * (pGerone - b.distanceTo(c)) * (a.distanceTo(c)));
        } else {
            try {
                throw new RuntimeException();
            } catch (RuntimeException e) {
                System.out.println("Ошибка ... нельзя построить треугольник через эти точки");
            }

        }
        return  0 ;

    }
}