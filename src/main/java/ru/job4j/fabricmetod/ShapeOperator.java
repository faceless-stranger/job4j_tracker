package ru.job4j.fabricmetod;

public abstract class ShapeOperator {
    public void showInfo() {
        Shape shape = createShape();
        System.out.println(shape.draw());
        System.out.println("Площадь фигуры равна: " + shape.square());
    }

    public abstract Shape createShape();

    public void name(String name) {
        System.out.println("hello" + name);
    }
}