package ru.job4j.collection;

import java.util.HashSet;

public class UsageHashSet {
    public static void main(String[] args) {
        HashSet<String> autos = new HashSet<>();
        autos.add("BMW");
        autos.add("Toyota");
        autos.add("Volva");
        autos.add("Skoda");
        autos.add("Lada");
        for (String brand : autos) {
            System.out.println(brand);
        }
    }
}