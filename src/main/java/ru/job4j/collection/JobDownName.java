package ru.job4j.collection;

import java.util.Comparator;

public class JobDownName implements Comparator<Job> {
    @Override
    public int compare(Job fist, Job second) {
        return second.getName().compareTo(fist.getName());
    }
}
