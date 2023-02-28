package ru.job4j.collection;

import java.util.Comparator;

public class JobUpPriority implements Comparator<Job> {
    @Override
    public int compare(Job fist, Job second) {
        return fist.getPriority() - second.getPriority();
    }
}
