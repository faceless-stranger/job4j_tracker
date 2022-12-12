package ru.job4j.oop;

public class DummyDic {
    public String engToRus() {
        return "Неизвестное слово " + eng;
    }

    public static void main(String[] args) {
        DummyDic test = new DummyDic();
        System.out.println("Cat " + test.engToRus());
    }
}
