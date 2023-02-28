package ru.job4j.collection;

import java.util.Comparator;

public class JobDownPriority implements Comparator<Job> {
    @Override
    public int compare(Job fist, Job second) {
        return second.getPriority() - fist.getPriority();
    }
}
