package com.epam.rd.autotasks;

import java.util.Scanner;

import static java.lang.Math.sqrt;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double delta = Math.pow(b,2) - 4 * (a * c);

        if (delta < 0) {
            System.out.println("no roots");
        } else if (delta == 0) {
            double root = -(b/(2*a));
            System.out.println(root);
        } else {
            double rootX1 = (-b - Math.sqrt(delta))/(2 * a);
            double rootX2 = (-b + Math.sqrt(delta))/(2 * a);
            System.out.println(rootX1 + " " + rootX2);
        }

    }

}