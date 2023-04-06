package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CardService {

    public List<Card> generateDeckOfCards() {
        return Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                        .map(value -> new Card(suit, value)))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(new CardService().generateDeckOfCards());
    }
}