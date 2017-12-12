package tuilayer;

import controllayer.Session;
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

    public MainMenu() {
        super("Main Menu", null);
        //login();

        commandWords.add("Manage Inventory");
        commandWords.add("Manage Employee");
        commandWords.add("Manage Customer");
        commandWords.add("Create Sale");

        printMenu();
        menuPrompt();
    }

    @Override
    public void resolver(int i) {
        switch (i) {
            case 0:
                new ManageInventory(this);
                break;
            case 1:
                new ManageEmployee(this);
                break;
            case 2:
                new ManageCustomer(this);
                break;
        }

    }

    private void login() {
        while (true) {
            try {
                if (Session.getInstance().login(inputString("Login: "), inputString("Password: "), inputString("Location: ")))
                    setSession(Session.getInstance());
                    break;
            } catch (Exception ignored) {
            }
            printErr("Login failed");
        }

    }

}
