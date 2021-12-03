package Presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private final Scanner scanner;
    private final String[] failPhrases= {"Gah! It was so close, too!","Aargh! Almost had it!","Aww! It appeared to be caught!" };

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
        System.out.print(message);
    }

    public String askForString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
    public boolean askForAnswer(int random){
        String answer;
        this.showMessage(failPhrases[random]);
        do{
            answer=this.askForString(" Want to try again? [y/n] ");
            if (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")){
                this.showMessage("Please enter a correct answer!");
            }
        }while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n"));
        return answer.equalsIgnoreCase("y");
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
