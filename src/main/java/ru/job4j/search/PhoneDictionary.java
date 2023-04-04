package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список пользователей, которые прошли проверку.
     */

    public ArrayList<Person> find(String key) {
        Predicate<Person> getSurname = x -> x.getSurname().contains(key);
        Predicate<Person> getName = x -> x.getName().contains(key);
        Predicate<Person> getPhone = x -> x.getPhone().contains(key);
        Predicate<Person> getAddress = x -> x.getAddress().contains(key);
        Predicate<Person> combine = getSurname.or(getName).or(getPhone).or(getAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}