package com.second_task;

import java.util.Arrays;

public class BelroseVillaAlgorithm {
    public static void main(String[] args) {

        String word = "adult";
        String wordsArr[] = getBelroseVillaAlgorithm(word);
        otherTasks(wordsArr, word);
    }

    private static String[] getBelroseVillaAlgorithm(String word) {

        String wordsArr[] = new String[word.length()];
        int currentPosition;

        //initialising of String array by algorithm of Villa Belrose
        for (int i = 0; i < word.length(); i++) {
            currentPosition = i;
            wordsArr[i] = "";
            for (int j = 0; j < word.length(); j++) {
                if (currentPosition == word.length()) {
                    currentPosition = 0;
                }
                wordsArr[i] += word.charAt(currentPosition++);
            }
        }

        return wordsArr;
    }

    private static void otherTasks(String[] wordsArr, String word) {

        Arrays.sort(wordsArr);

        int wordPosition = 0;
        StringBuilder lastSymbols = new StringBuilder();

        //Sort array printing
        for (int i = 0; i < wordsArr.length; i++) {
            System.out.println(wordsArr[i]);

            //checking, in order to find situation index of begin word
            if (wordsArr[i].equals(word)) {
                wordPosition = i;
            }

            //creating of the word, which consists from last letters of the words in array
            lastSymbols.append(wordsArr[i].charAt(wordsArr[i].length() - 1));
        }
        System.out.println();

        System.out.println(lastSymbols + ", " + wordPosition);
    }
}
