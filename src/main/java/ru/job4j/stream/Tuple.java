package ru.job4j.stream;

/**
 *  содержит результаты: имя и баллы. Этот класс используется как
 *  для учеников, так и для предметов.
 */
public record Tuple(String name, double score) {
}