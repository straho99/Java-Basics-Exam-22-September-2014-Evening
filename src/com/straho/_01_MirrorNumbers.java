package com.straho;

import java.util.Arrays;
import java.util.Scanner;

public class _01_MirrorNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String inputNumbers = scanner.nextLine();
        String[] numbers = inputNumbers.split(" ");
        //System.out.println(Arrays.toString(numbers));
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (numbers[i].equals(new StringBuilder(numbers[j]).reverse().toString())) {
                    count++;
                    System.out.println(numbers[i] + "<!>" + numbers[j]);
                }
            }
        }
        if (count==0) {
            System.out.println("No");
        }
    }
}
