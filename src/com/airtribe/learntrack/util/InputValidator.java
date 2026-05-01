package com.airtribe.learntrack.util;

import java.util.Scanner;

public class InputValidator {

    public static int readInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }


    public static String readNonEmptyString(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();

            if (input != null && !input.trim().isEmpty()) {
                return input;
            }

            System.out.println("Input cannot be empty!");
        }
    }


    public static String readEmail(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String email = sc.nextLine();

            if (email.contains("@")) {
                return email;
            }

            System.out.println("Invalid email format!");
        }
    }
}