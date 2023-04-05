package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, -4, 33, -11, 0, 6);
        List<Integer> positive = numbers.stream().filter(element -> element > 0).collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}