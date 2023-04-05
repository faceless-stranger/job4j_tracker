package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .filter(e -> e.getStandard() - e.getActual() <= 3 && e.getStandard() - e.getActual() >= 0)
                .map(e -> new Label(e.getName(), e.getPrice() / 2).toString())
                .collect(Collectors.toList());
    }
}