package ru.job4j.queue;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> mail = new HashMap<>();
        mail.put("Gena@yandex.ru", "Гена неВикторович неПолктов ");
        mail.put("Gena@yandex.ru", "Гена Викторович Полкотов ");
        mail.put("Jenya@yandex.ru", "Женя Александрович Хрустов");
        mail.put("Misha@yandex.ru", "Михаил Коземяка");
        mail.put("Misha@yandex.ru", "Михаил Михайлович Михайлов");
        mail.put("Masha@yandex.ru", "Мария Семеновна Острова");
        for (Map.Entry<String, String> item : mail.entrySet()) {
            System.out.println("Почта " + item.getKey()
                    + " ФИО пользователя " + item.getValue());
        }
    }
}
