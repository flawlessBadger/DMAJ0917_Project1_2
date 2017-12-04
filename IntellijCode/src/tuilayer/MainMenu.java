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
        commandWords.add("Manage employees");
        commandWords.add("Manage items");
        commandWords.add("Manage bundle");
        commandWords.add("Manage Sale");

        /*
        HashMap<String,String> hm = new HashMap<>();
        hm.put("bleh","blah");
        hm.put("bleh","blah");
        */

        printMenu();
        menuPrompt();
    }

    @Override
    public void resolver(int i) {
        switch(i){
            case 0:
                new ManageEmployee(this);
                break;
            case 1:
                new ManageItem(this);
                break;
            case 2:
                new ManageBundle(this);
                break;
            case 3:
                new ManageSale(this);
                break;
        }
    }

}
