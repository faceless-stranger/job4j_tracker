package ru.job4j.poly;

public class FileStore extends DbStore {
    @Override
    public void save(String value) {
        super.save(value);
    }

    @Override
    public String[] load() {
        return super.load();
    }
}