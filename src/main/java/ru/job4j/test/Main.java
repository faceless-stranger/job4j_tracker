package ru.job4j.test;

public class Main {

        public static void main(String[] args) {
            Animal cat = new Cat();
            cat.instanceInvoke();
            cat.staticInvoke();
            Animal animal = new Animal();
            animal.instanceInvoke();
            Animal.staticInvoke();

        }
}
