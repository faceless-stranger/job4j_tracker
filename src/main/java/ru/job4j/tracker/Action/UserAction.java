package ru.job4j.tracker.Action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Store;

public interface UserAction {
    String name();

    boolean execute(Input input, Store tracker);
}
