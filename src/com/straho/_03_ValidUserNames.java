package com.straho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _03_ValidUserNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] allWords = input.split("[ ()/\\\\]");
        //System.out.println(Arrays.toString(allWords));
        String pattern = "[a-zA-Z][a-z-A-Z0-9_]+";
        ArrayList<String> userNames = new ArrayList<String>();
        for (String word : allWords) {
            if (word.matches(pattern)) {
                if (word.length() >= 3 && word.length() <= 25) {
                    userNames.add(word);
                }
            }
        }
        int maxSum = 0;
        int maxSumStartIndex = 0;
        for (int i = 0; i < userNames.size() - 1; i++) {
            int currentSum = userNames.get(i).length() + userNames.get(i + 1).length();
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxSumStartIndex = i;
            }
        }
        System.out.println(userNames.get(maxSumStartIndex));
        System.out.println(userNames.get(maxSumStartIndex + 1));
    }
}
