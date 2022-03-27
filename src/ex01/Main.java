package ex01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Calculation and display of results.
 * Contains the implementation of the static main() method.
 *
 * @author Vlada
 * @version 1.0
 * @see Main#main
 */

public class Main {
    /**
     * class object {@linkplain Calc}.solves the task of an individual task
     */
    private final Calc calc = new Calc();

    /**
     * Displays the menu.
     */
    private void menu() {
        String s = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            do {
                System.out.println("Enter command...");
                System.out.print("'q'uit, 'v'iew, 'g'enerate, 's'ave, 'r'estore: ");
                try {
                    s = in.readLine();
                } catch (IOException e) {
                    System.out.println("Error: " + e);
                    System.exit(0);
                }
            } while (s.length() != 1);
            switch (s.charAt(0)) {
                case 'q' -> System.out.println("Exit.");
                case 'v' -> {
                    System.out.println("View current.");
                    calc.show();
                }
                case 'g' -> {
                    System.out.println("Random generation.");
                    calc.init(new double[]{Math.random() * 360, Math.random() * 360, Math.random() * 360, Math.random() * 360});
                    calc.show();
                }
                case 's' -> {
                    System.out.println("Save current.");
                    try {
                        calc.save();
                    } catch (IOException e) {
                        System.out.println("Serialization error: " + e);
                    }
                    calc.show();
                }
                case 'r' -> {
                    System.out.println("Restore last saved.");
                    try {
                        calc.restore();
                    } catch (Exception e) {
                        System.out.println("Serialization error: " + e);
                    }
                    calc.show();
                }
                default -> System.out.print("Wrong command. ");
            }
        } while (s.charAt(0) != 'q');
    }

    /**
     * Executed when the program starts.
     * The value of the function is calculated for the various arguments.
     * The calculation results are displayed on the screen.
     *
     * @param args - program launch options.
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }
}