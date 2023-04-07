package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс управляет пользователями и их банковскими аккаунтами.
 * Выполняет перевод денеждых средств между банковскими аккаунтами мипользователей.
 *
 * @author Vlad Koschinsky
 * @version 1.0
 */

public class BankService {

    /**
     * Список пользователей и их банковских аккаунтов
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавление пользователя в пользователей сервиса банка.
     * Добавление только при его отсутствии в пользователях сервиса банка.
     *
     * @param user
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Удаление пользователеля из пользователей сервиса банка.
     * По данным паспорта происходит поиск пользователя в системе.
     *
     * @param passport
     * @return true - в случае успешного удаления. false - пользователь с таким паспортом не найден
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Добавление банковского счета для пользователя,
     * только при наличии самого пользователя в банковской системе определяемого по данным паспорта.
     *
     * @param passport - данные пользователя для которого будет добавлен банкосвкий счет
     * @param account  - добавляемый счет.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Поиск пользователя в банковской системе по данным паспорта.
     *
     * @param passport
     * @return в случае наличия пользователя по данным пасспорта
     * вернем найденного пользователя, ИНАЧЕ null.
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(e -> e.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Поиск счета у пользователя по реквизитам счета
     *
     * @param passport  - данные паспорта пользователя
     * @param requisite - номер искомого счета у найденного пользователя по указанному пасспорту
     * @return null - не найден пользователь по данным паспорта или не найден банковский аккаунт
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
                }
        return null;
    }

    /**
     * Выполнение перевода денежных средств межну счетами.
     * Выполнение проверки на наличие счетов по указанным реквизитам.
     * Выполнение проверки на наличие средств на счету отправителя.
     *
     * @param srcPassport   - реквизиты пользователя отправителя
     * @param srcRequisite  - реквизиты счета отправителя
     * @param destPassport  - реквизиты пользователя получателя
     * @param destRequisite - реквизиты счета получателя.
     * @param amount        - сумма перевода
     * @return true - успешно. false - не найден счет отправителя, получателя,
     * не достаточно средств на счете отправилетя.
     */
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

    /**
     * Получение всех банковских счетов пользователя банкосвкого сервиса
     *
     * @param user {@link User}
     * @return "List<Account>"
     */
    public List<Account> getAccounts(User user) {

        return users.get(user);
    }
}
