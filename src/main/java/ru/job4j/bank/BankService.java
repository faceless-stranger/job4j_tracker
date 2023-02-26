package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>(); //содержит всех пользователей системы с привязанными к ним счетами

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
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
