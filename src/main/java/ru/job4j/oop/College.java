package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        Freshman frs = student;
        Object obj = frs;
    }
}
