package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Experiment {

    public static void main(String[] args) {
        Map<User, List<Account>> users = new HashMap<>();
        User first = new User("3434", "Petr Arsentev");
        users.put(first, new ArrayList<Account>());
    }


}
