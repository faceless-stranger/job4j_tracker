package ru.job4j.tracker;

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
        tracker.delete(id);
        return true;
    }
}