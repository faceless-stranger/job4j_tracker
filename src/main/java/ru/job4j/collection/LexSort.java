package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] rslLeft = left.split("\\.", 2);
        String[] rslRight = right.split("\\.", 2);
        int l = Integer.parseInt(rslLeft[0]);
        int r = Integer.parseInt(rslRight[0]);

        return Integer.compare(l, r);
    }
}