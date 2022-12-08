package ru.job4j.oop;

public class Cat {

    private String food; // Создаём поля обьекта.
    private String name;

    public void show() {
        System.out.println(this.name + " кушал " + this.food); // Метод который будет выводить содержимое поле обьекта.
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void eat(String meat) { // Записываем данные.
        this.food = meat;
    }

    public static void main(String[] args) {
        System.out.println("There are gav's food.");
        Cat gav = new Cat();
        gav.eat("Котелту");
        gav.giveNick("Гав");
        gav.show();
        System.out.println("There are black's food.");
        Cat black = new Cat();
        black.eat("Рыбу");
        black.giveNick("Черныш");
        black.show();
    }
}