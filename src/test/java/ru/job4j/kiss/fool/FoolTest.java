package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FoolTest {

    /**
     * Проверяем, что первое число вернёт строку "1".
     */
    @Test
    public void whenValueIs1ThenAnswerIs1() {
        Fool fool = new Fool();
        String result = fool.getFizzBuzzAnswer();
        assertEquals("1", result);
    }

    /**
     * Проверяем, что третье число вернёт "Fizz".
     */
    @Test
    public void whenValueIs3ThenAnswerIsFizz() {
        Fool fool = new Fool();
        // value=1 => "1"
        fool.getFizzBuzzAnswer();
        // value=2 => "2"
        fool.getFizzBuzzAnswer();
        // value=3 => "Fizz"
        String result = fool.getFizzBuzzAnswer();
        assertEquals("Fizz", result);
    }

    /**
     * Проверяем, что пятое число вернёт "Buzz".
     */
    @Test
    public void whenValueIs5ThenAnswerIsBuzz() {
        Fool fool = new Fool();
        // 1, 2, 3, 4 – не кратны 5
        fool.getFizzBuzzAnswer(); // "1"
        fool.getFizzBuzzAnswer(); // "2"
        fool.getFizzBuzzAnswer(); // "Fizz"
        fool.getFizzBuzzAnswer(); // "4"
        // value=5 => "Buzz"
        String result = fool.getFizzBuzzAnswer();
        assertEquals("Buzz", result);
    }

    /**
     * Проверяем, что пятнадцатое число вернёт "FizzBuzz".
     */
    @Test
    public void whenValueIs15ThenAnswerIsFizzBuzz() {
        Fool fool = new Fool();
        // Нужно вызвать метод 14 раз, чтобы выйти на число 15
        for (int i = 1; i < 15; i++) {
            fool.getFizzBuzzAnswer();
        }
        // value=15 => "FizzBuzz"
        String result = fool.getFizzBuzzAnswer();
        assertEquals("FizzBuzz", result);
    }
}