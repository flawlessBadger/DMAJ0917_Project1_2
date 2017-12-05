package tuilayer;

import java.util.*;

/**
 * Write a description of class MainMenuUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MainMenu extends Menu {
    /**
     * Constructor for objects of class MainMenuUI
     */

    public static void main(String[] args) {
        new MainMenu();
    }

    public MainMenu() {
        super("Main Menu", null);
        commandWords.add("test");
        commandWords.add("friends");
        commandWords.add("managedvd");
        commandWords.add("loanCopy");

        printMenu();
        menuPrompt();
    }

    @Override
    public void resolver(int i) {
        System.out.println("Hello World " + i);


    }

}
