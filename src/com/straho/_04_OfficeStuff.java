package com.straho;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_OfficeStuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, HashMap<String, Integer>> companiesOrders = new TreeMap<String, HashMap<String, Integer>>();
        TreeMap<String, ArrayList<String>> companiesProducts = new TreeMap<String, ArrayList<String>>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            line = line.substring(1, line.length()-1);
            String[] tokens = line.split(" - ");
            String company = tokens[0];
            String product = tokens[2];
            int quantity = Integer.parseInt(tokens[1]);
            if (!companiesOrders.containsKey(company)) {
                HashMap<String, Integer> newCompany = new HashMap<String, Integer>();
                newCompany.put(product, quantity);
                companiesOrders.put(company, newCompany);
                companiesProducts.put(company, new ArrayList<String>());
                companiesProducts.get(company).add(product);
            } else {
                if (!companiesOrders.get(company).containsKey(product)) {
                    companiesOrders.get(company).put(product, quantity);
                    companiesProducts.get(company).add(product);
                } else {
                    int oldQuantity = companiesOrders.get(company).get(product);
                    companiesOrders.get(company).put(product, oldQuantity + quantity);
                }
            }
        }

        for (String company : companiesOrders.keySet()) {
            String output = company + ": ";
            for (int i = 0; i < companiesProducts.get(company).size(); i++) {
                output += companiesProducts.get(company).get(i) + "-"
                        + companiesOrders.get(company).get(companiesProducts.get(company).get(i)) + ", ";
            }
            output = output.substring(0, output.length()-2);
            System.out.println(output);
        }
    }
}
