package tuilayer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Write a description of class tuilayer.Menu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
abstract class Menu {
    private Scanner sc;
    private String name;
    protected ArrayList<String> commandWords;
    private Menu parent;

    Menu(String name, Menu parent) {

        this.name = name;
        this.parent = parent;
        sc = new Scanner(System.in);
        commandWords = new ArrayList();
    }

    void menuPrompt() {
        System.out.println("> ");
        int input = -1;
        try {
            input = Integer.valueOf(sc.nextLine());
        } catch (Exception e) {
        }
        if (input <= 0 || input > commandWords.size() + 3) {
            printErr("Invalid input");
            menuPrompt();
        } else if (commandWords.size() + 1 == input) {
            System.out.println("\fGoodbye");
            System.exit(1);
        } else if (commandWords.size() + 2 == input) {
            printMenu();
            menuPrompt();
        } else if (commandWords.size() + 3 == input) {
            if (parent != null) {
                parent.printMenu();
                parent.menuPrompt();
            } else {
                System.out.println("There is no parent menu");
                menuPrompt();
            }
        } else {
            resolver(input - 1);
            menuPrompt();
        }

    }

    abstract void resolver(int i);

    void printMenu() {
        System.out.println("\n\n\n\n\n\n\n\n\n###################");
        System.out.println(name);
        System.out.println("###################");
        for (int i = 0; i < commandWords.size(); i++) {
            System.out.println("(" + String.valueOf(i + 1) + ") " + commandWords.get(i));
        }
        System.out.println("(" + String.valueOf(commandWords.size() + 1) + ") exit");
        System.out.println("(" + String.valueOf(commandWords.size() + 2) + ") clear");
        if (parent != null)
            System.out.println("(" + String.valueOf(commandWords.size() + 3) + ") back");
        System.out.println("###################");
    }

    void resetMenu(String message) {
        printMenu();
        System.out.println(message);
        menuPrompt();
    }

    String inputString(String title) {
        System.out.print(title);
        String input = "";
        while (input.length() <= 0) {
            input = sc.nextLine();
        }

        return input;
    }

    double inputDouble(String title) {
        while (true) {
            System.out.print(title);
            try {
                return Double.valueOf(sc.nextLine());
            } catch (Exception e) {
                printErr("Not a number");
            }
        }
    }

    int inputInteger(String title) {
        while (true) {
            System.out.print(title);
            try {
                return Integer.valueOf(sc.nextLine());
            } catch (Exception e) {
                printErr("Not an Integer");
            }
        }
    }


    void printErr(String message) {
        System.err.println(message);
        try {
            Thread.sleep(5);
        } catch (InterruptedException ignored) {
        }
    }
}
