package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        double scoreSum = 0D;
        double score = 0D;
        for (Pupil value : pupils) {
            for (Subject subject : value.subjects()) {
                scoreSum += subject.score();
            }
            score = scoreSum / value.subjects().size() / pupils.size();
        }
        return score;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil student : pupils) {
            double scoreSum = 0;
            for (Subject score : student.subjects()) {
                scoreSum += score.score();
            }
            result.add(new Label(student.name(), scoreSum / student.subjects().size()));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        LinkedHashMap<String, Integer> cloud = new LinkedHashMap<>();
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject score : pupil.subjects()) {
                int valueResult = cloud.getOrDefault(score.name(), 0);
                cloud.put(score.name(), valueResult + score.score());
            }
        }
        for (Map.Entry<String, Integer> map : cloud.entrySet()) {
            list.add(new Label(map.getKey(), map.getValue() / pupils.size()));
        }
        return list;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double scoreSum = 0;
            for (Subject score : pupil.subjects()) {
                scoreSum += score.score();
            }
            result.add(new Label(pupil.name(), scoreSum));
        }
        Collections.sort(result);
        return result.get(result.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        HashMap<String, Integer> cloud = new LinkedHashMap<>();
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject score : pupil.subjects()) {
                int valueResult = cloud.getOrDefault(score.name(), 0);
                cloud.put(score.name(), valueResult + score.score());
            }
        }
        for (Map.Entry<String, Integer> map : cloud.entrySet()) {
            list.add(new Label(map.getKey(), map.getValue()));
        }
        Collections.sort(list);
        return list.get(list.size() - 1);
    }
}