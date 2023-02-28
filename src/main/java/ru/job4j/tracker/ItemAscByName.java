package ru.job4j.tracker;

import java.util.Comparator;

public class ItemAscByName implements Comparator<Item> {
    @Override
    public int compare(Item fist, Item second) {
        return fist.getName().compareTo(second.getName());
    }
}
