package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] rslLeft = left.split("\\.");
        String[] rslRight = right.split("\\.");
        int l = Integer.parseInt(rslLeft[0]);
        int r = Integer.parseInt(rslRight[0]);
        return Integer.compare(l, r);
    }
}