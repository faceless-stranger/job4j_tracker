package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Store;

public class DeletedAction implements UserAction {

    private final Output out;

    public DeletedAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Delete item ===");
        int id = input.askInt("Enter id:");
        boolean rsl = tracker.findById(id) != null;
        if (tracker.findById(id) != null)  {
            tracker.delete(id);
            out.println("Заявка удалена успешно.");
        } else {
            out.println("Ошибка удаления заявки.");
        }
        return rsl;
    }
}