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
        fool.getFizzBuzzAnswer();
        fool.getFizzBuzzAnswer();
        String result = fool.getFizzBuzzAnswer();
        assertEquals("Fizz", result);
    }

    /**
     * Проверяем, что пятое число вернёт "Buzz".
     */
    @Test
    public void whenValueIs5ThenAnswerIsBuzz() {
        Fool fool = new Fool();
        fool.getFizzBuzzAnswer();
        fool.getFizzBuzzAnswer();
        fool.getFizzBuzzAnswer();
        fool.getFizzBuzzAnswer();
        String result = fool.getFizzBuzzAnswer();
        assertEquals("Buzz", result);
    }

    /**
     * Проверяем, что пятнадцатое число вернёт "FizzBuzz".
     */
    @Test
    public void whenValueIs15ThenAnswerIsFizzBuzz() {
        Fool fool = new Fool();
        for (int i = 1; i < 15; i++) {
            fool.getFizzBuzzAnswer();
        }
        String result = fool.getFizzBuzzAnswer();
        assertEquals("FizzBuzz", result);
    }
}