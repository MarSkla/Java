package com.epam.rd.autotasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Use Scanner methods to read input

        String input = scanner.nextLine();
        String[] splitted = input.split(" ");

        int sum = 0;

        for (String s : splitted
             ) {
            int value = Integer.parseInt(s);
            sum += value;
        }
        System.out.println(sum/(splitted.length - 1));
    }

}