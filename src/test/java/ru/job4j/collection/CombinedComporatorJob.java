package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CombinedComporatorJob {

    @Test
    public void whenJobUpName() {
        Job jobs1 = new Job("Владимир", 1);
        Job jobs2 = new Job("Анна", 4);
        Job jobs3 = new Job("Генадий", 7);
        List<Job> list = new ArrayList<>();
        list.add(jobs1);
        list.add(jobs2);
        list.add(jobs3);
        Collections.sort(list, new JobUpName());
        List<Job> expected = new ArrayList<>();
        expected.add(jobs2);
        expected.add(jobs1);
        expected.add(jobs3);
        assertThat(list).containsSequence(expected);
    }

    @Test
    public void whenJobDownName() {
        Job jobs1 = new Job("Владимир", 1);
        Job jobs2 = new Job("Анна", 4);
        Job jobs3 = new Job("Генадий", 7);
        List<Job> list = new ArrayList<>();
        list.add(jobs1);
        list.add(jobs2);
        list.add(jobs3);
        Collections.sort(list, new JobDownName());
        List<Job> expected = new ArrayList<>();
        expected.add(jobs3);
        expected.add(jobs1);
        expected.add(jobs2);
        assertThat(list).containsSequence(expected);
    }

    @Test
    public void whenJobDownPriority() {
        Job jobs1 = new Job("Владимир", 1);
        Job jobs2 = new Job("Анна", 4);
        Job jobs3 = new Job("Генадий", 7);
        List<Job> list = new ArrayList<>();
        list.add(jobs1);
        list.add(jobs2);
        list.add(jobs3);
        Collections.sort(list, new JobDownPriority());
        List<Job> expected = new ArrayList<>();
        expected.add(jobs3);
        expected.add(jobs2);
        expected.add(jobs1);
        assertThat(list).containsSequence(expected);
    }

    @Test
    public void whenJobUpPriority() {
        Job jobs1 = new Job("Владимир", 9);
        Job jobs2 = new Job("Анна", 4);
        Job jobs3 = new Job("Генадий", 7);
        List<Job> list = new ArrayList<>();
        list.add(jobs1);
        list.add(jobs2);
        list.add(jobs3);
        Collections.sort(list, new JobUpPriority());
        List<Job> expected = new ArrayList<>();
        expected.add(jobs2);
        expected.add(jobs3);
        expected.add(jobs1);
        assertThat(list).containsSequence(expected);
    }

    @Test
    public void whenUpNameOrUpPriority() {
        Comparator<Job> comb = new JobUpName().thenComparing(new JobUpPriority());
        int rsl = comb.compare(
                new Job("Alla", 0),
                new Job("Alla", 0)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenDownNameOrDownPriority() {
        Comparator<Job> comb = new JobDownName().thenComparing(new JobDownPriority());
        int rsl = comb.compare(
                new Job("Alla", 6),
                new Job("Alla", 9)
        );
        assertThat(rsl).isGreaterThan(-1);
    }

}
