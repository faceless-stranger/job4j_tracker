package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] value1 = o1.split("/");
        String[] value2 = o2.split("/");
        int result = value2[0].compareTo(value1[0]);
        return result == 0 ? o1.compareTo(o2) : result;
    }
}