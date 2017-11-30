package tuilayer;

import java.util.*;

/**
 * Write a description of class tuilayer.Menu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Menu {
    protected Scanner sc;
    private String name;
    protected ArrayList<String> commandWords;
    private Menu parent;

    public Menu(String name, Menu parent) {

        this.name = name;
        this.parent = parent;
        sc = new Scanner(System.in);
        commandWords = new ArrayList<String>();
    }

    public void menuPrompt() {
        System.out.print("> ");
        int input = -1;
        try {
            input = sc.nextInt() + 1;
        } catch (Exception e) {
        }
        if (input <= 0 || input > commandWords.size() + 3)
            System.err.println("Invalid input");
        else if (commandWords.size() + 1 == input) {
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
            resolver(input);
            menuPrompt();
        }

    }

    public abstract void resolver(int i);

    public void printMenu() {
        System.out.println("\n\n\n\n\n\n\n\n\n###################");
        System.out.println(name);
        System.out.println("###################");
        for (int i = 0; i < commandWords.size(); i++) {
            System.out.println("(" + String.valueOf(i + 1) + ") " + commandWords.get(i));
        }
        System.out.println("(" + String.valueOf(commandWords.size() + 1) + ") exit");
        System.out.println("(" + String.valueOf(commandWords.size() + 2) + ") clear");
        if (parent != null)
            System.out.println("(" + String.valueOf(commandWords.size() + 1) + ") back");
        System.out.println("###################");
    }

}