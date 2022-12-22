package ru.job4j.inheritance;

public class Cat extends Animal {
    @Override
    public void instanceInvoke() {
        super.instanceInvoke();
    }

    public static void staticInvoke() {
        System.out.println("Вызов статического метода Cat");
    }
}