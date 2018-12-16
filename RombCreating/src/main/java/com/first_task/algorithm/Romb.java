package com.first_task.algorithm;

public class Romb {

    public void createRomb(String word) {
        int middle = word.length() % 2 == 0 ? word.length()/2:(word.length()/2) + 1;

        for (int i = middle; i >= 0; i--) {
            print(i, word);
        }
        for (int i = 1; i < middle; i++) {
            print(i, word);
        }
    }

    private void print(int i, String word) {
        int space = i;
        while (space != 0) {
            System.out.print(" ");
            space--;
        }
        for (int j = i; j < word.length() - i; j++) {
            System.out.print(word.charAt(j));
        }
        System.out.println();
    }
}
