package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {

    @Test
    void whenItemsSortAscByName() {
        List<Item> items = new ArrayList<>();
        Item stas = new Item("Стас");
        Item vlad = new Item("Влад");
        Item petr = new Item("Петр");
        items.add(stas);
        items.add(vlad);
        items.add(petr);
        Collections.sort(items, new ItemAscByName());

        List<Item> expected = new ArrayList<>();
        expected.add(vlad);
        expected.add(petr);
        expected.add(stas);
        assertThat(expected.equals(items));
    }
}