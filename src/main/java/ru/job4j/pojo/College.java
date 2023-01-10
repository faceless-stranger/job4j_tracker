package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Vlad");
        student.setGroup("build");
        student.setDate("11.11.11");
        System.out.println("Имя " + student.getName() + System.lineSeparator() + "Группа  " + student.getGroup()
                + System.lineSeparator() + "Дата поступления  " + student.getDate());
    }
}
