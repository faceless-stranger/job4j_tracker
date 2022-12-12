package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int a) {
        return a / x;
    }

    public int sumAllOperation(int a) {
        return sum(a) + minus(a) + multiply(a) + divide(a);
    }

    public static void main(String[] args) {
        System.out.println(sum(6));
        System.out.println(minus(6));
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println(rsl);
        rsl = calculator.divide(5);
        System.out.println(rsl);
        rsl = calculator.sumAllOperation(5);
        System.out.println(rsl);

    }
}