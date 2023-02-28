package ru.job4j.tracker;

import java.util.Comparator;

public class ItemDescByName implements Comparator<Item> {
    @Override
    public int compare(Item fist, Item second) {
        return second.getName().compareTo((fist.getName()));
    }
}
