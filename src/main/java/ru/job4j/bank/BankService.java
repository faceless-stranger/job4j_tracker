package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>(); //содержит всех пользователей системы с привязанными к ним счетами

    public void addUser(User user) { //метод должен добавить пользователя в систему
        if (user != null && !users.containsKey(user)) {
            users.put(user, new ArrayList<Account>());
        }
    }

    public boolean deleteUser(String passport) { //удалить пользователя из системы.
        boolean rsl = false;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> result = users.remove(user);
            rsl = true;
        }
        return rsl;
    }

    public void addAccount(String passport, Account account) { //должен добавить новый счет к пользователю
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    public User findByPassport(String passport) { //метод ищет пользователя по номеру паспорта
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) { //ищет счет пользователя по реквизитам
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            for (Account account : list) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account requisiteOne = findByRequisite(srcPassport, srcRequisite);
        Account requisiteSecond = findByRequisite(destPassport, destRequisite);
        if (requisiteOne != null && requisiteSecond != null && requisiteOne.getBalance() >= amount) {
            requisiteOne.setBalance(requisiteOne.getBalance() - amount);
            requisiteSecond.setBalance(requisiteSecond.getBalance() + amount);
            return true;
        }
        return false;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
