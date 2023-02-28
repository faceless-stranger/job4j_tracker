package ru.job4j.collection;

import java.util.Comparator;

public class JobUpName implements Comparator<Job> {
    @Override
    public int compare(Job fist, Job second) {
        return fist.getName().compareTo(second.getName());
    }
}
