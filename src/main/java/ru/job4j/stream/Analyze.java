package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    /**
     * Метод averageScore() - вычисляет общий средний балл.
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.subjects().stream())
                .mapToInt(Subject::score)
                .average()
                .orElse(0);
    }

    /**
     * Метод averageScoreByPupil() - вычисляет средний балл по каждому ученику.
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(pupil.name(), pupil.subjects().stream()
                        .mapToInt(Subject::score)
                        .average()
                        .orElse(0)))
                .toList();
    }

    /**
     * Метод averageScoreBySubject() - вычисляет средний балл по каждому предмету.
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.subjects().stream())
                .collect(Collectors.groupingBy(Subject::name, LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::score))).entrySet().stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .toList();

    }

    /**
     * Метод bestStudent() - возвращает лучшего ученика.
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(pupil.name(),
                        pupil.subjects().stream()
                                .mapToInt(Subject::score)
                                .sum()))
                .max(Comparator.comparingDouble(Tuple::score))
                .orElse(null);

    }

    /**
     * Метод bestSubject() - возвращает предмет с наибольшим баллом для всех студентов.
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.subjects().stream())
                .collect(Collectors.groupingBy(Subject::name,
                        LinkedHashMap::new,
                        Collectors.summingDouble(Subject::score)))
                .entrySet().stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .max(Comparator.comparingDouble(Tuple::score))
                .orElse(null);
    }
}