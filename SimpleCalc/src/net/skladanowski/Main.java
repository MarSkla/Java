package net.skladanowski;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("====== Simple Calc Console App ======");
        System.out.print("Intended operation (+, -, *, /): ");
        String action = scanner.nextLine();

        System.out.print("Enter 1st value: ");
        double valueFirst = scanner.nextDouble();

        System.out.print("Enter 2nd value: ");
        double valueDouble = scanner.nextDouble();

        double result;

        if (action.equals("+")){
            result = valueFirst + valueDouble;
        }
        else if (action.equals("-")){
            result = valueFirst - valueDouble;
        }
        else if (action.equals("*")){
            result = valueFirst * valueDouble;
        }
        else {
            result = valueFirst / valueDouble;
        }

        System.out.printf("%f + %f = %f", valueFirst, valueDouble, result);

    }
}
