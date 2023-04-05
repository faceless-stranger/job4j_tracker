package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        List<Product> product = Arrays.asList(
                new Product("bread", 20, 5, 4),
                new Product("butter", 80, 30, 27),
                new Product("orange", 120, 20, 3),
                new Product("coffee", 75, 120, 30),
                new Product("potato", 45, 90, 15),
                new Product("cherry", 150, 10, 8),
                new Product("watermelon", 70, 7, 7) );

        return product.stream()
                .filter(e -> e.getStandard() - e.getActual() <= 3 && e.getStandard() - e.getActual() >= 0)
                .map(e -> new Label(e.getName(),e.getPrice() / 2).toString())
                .collect(Collectors.toList());
    }
}