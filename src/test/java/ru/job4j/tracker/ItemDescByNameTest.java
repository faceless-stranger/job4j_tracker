package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemDescByNameTest {

    @Test
    void whenItemDescByName() {
        List<Item> items = new ArrayList<>();
        Item stas = new Item("Стас");
        Item vlad = new Item("Влад");
        Item petr = new Item("Петр");
        items.add(stas);
        items.add(vlad);
        items.add(petr);
        Collections.sort(items, new ItemDescByName());

        List<Item> expected = new ArrayList<>();
        expected.add(stas);
        expected.add(petr);
        expected.add(vlad);
        assertThat(expected.equals(items));
    }
}