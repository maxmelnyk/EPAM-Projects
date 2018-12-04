package com.second_task;

import com.second_task.algorithms.BelroseVillaAlgorithm;

public class Main {
    public static void main(String[] args) {
        BelroseVillaAlgorithm algorithm = new BelroseVillaAlgorithm();

        String word = "adult";
        String wordsArr[] = algorithm.getBelroseVillaAlgorithm(word);
        algorithm.otherTasks(wordsArr, word);
    }
}
