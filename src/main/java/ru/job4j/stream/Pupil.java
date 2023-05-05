package ru.job4j.stream;
import java.util.List;

/**
 * описывает ученика
 */
public record Pupil(String name, List<Subject> subjects) {
}
