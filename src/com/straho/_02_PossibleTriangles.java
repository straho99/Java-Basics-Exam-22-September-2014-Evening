package com.straho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _02_PossibleTriangles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        ArrayList<double[]> triangleSides = new ArrayList<double[]>();
        while (!line.equals("End")) {
            String[] tokens = line.split(" ");
            double[] sides = new double[3];
            sides[0] = Double.parseDouble(tokens[0]);
            sides[1] = Double.parseDouble(tokens[1]);
            sides[2] = Double.parseDouble(tokens[2]);
            Arrays.sort(sides);
            triangleSides.add(sides);
            line = scanner.nextLine();
        }
        int count = 0;
        for (double[] sides : triangleSides) {
            if (sides[0] + sides[1] > sides[2]) {
                count++;
                System.out.printf("%1$.2f+%2$.2f>%3$.2f\n", sides[0], sides[1], sides[2]);
            }
        }
        if (count==0) {
            System.out.println("No");
        }
    }
}
