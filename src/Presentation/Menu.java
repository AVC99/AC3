package Presentation;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        spacing();
        System.out.println("--- PokéNostalgia ---");
        spacing();
        System.out.println("1. Show (Java)");
        System.out.println("2. Show (HTML)");
        System.out.println("3. Catch");
        System.out.println("4. Exit");
        spacing();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public String askForString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public int askForInteger(String message) {
        while (true) {
            try {
                System.out.print(message);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("That's not a valid integer, try again!");
            } finally {
                scanner.nextLine();
            }
        }
    }

    public double askForDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("That's not a valid double, try again!");
            } finally {
                scanner.nextLine();
            }
        }
    }
    public void showTabulatedList(String[] messages) {
        for (String message : messages) {
            showTabulatedMessage(message);
        }
    }

    public void showTabulatedMessage(String message) {
        System.out.println("\t" + message);
    }

    public void spacing() {
        System.out.println();
    }

}
