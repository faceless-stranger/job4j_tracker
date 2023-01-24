package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length - 1; i++) {
            if (value[i] == key) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Ключ не найден");
        }
        return rsl;
    }

    public static void main(String[] args) throws ElementNotFoundException {
        String[] array = {"A", "B", "C", "D"};
        try {
            indexOf(array, "K");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
