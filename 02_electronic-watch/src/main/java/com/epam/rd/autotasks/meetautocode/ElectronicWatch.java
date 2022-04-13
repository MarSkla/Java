package com.epam.rd.autotasks.meetautocode;

import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter your value: ");
        int seconds = scanner.nextInt();

        int days = seconds / 86400;
        int hours = (seconds % 86400) / 3600; //86400 = seconds in 24 hours
        int minutes = ((seconds % 86400) % 3600) / 60; //3600 = seconds in hour
        int mySeconds = ((seconds % 86400) % 3600) % 60;

//        String result = String.format("%01d:%02d:%02d", hours, minutes, mySeconds);
        System.out.format("%01d:%02d:%02d", hours, minutes, mySeconds);
    }
}
