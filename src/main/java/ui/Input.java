package ui;

import java.util.Scanner;

public class Input {

    public static String getString(String question) {

        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }

    public static int getInt(String question) {

        while (true) {
            try {
                return Integer.parseInt(getString(question));
            } catch (Exception e) {
                System.out.println("det skal være tal og ikke ord");
            }
        }

    }

}
