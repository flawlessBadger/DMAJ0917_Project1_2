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
        commandWords.add("Manage Inventory");
        commandWords.add("Create Sale");

        login();

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
                break;
        }

    }

    private void login() {
        while (true) {
            try {
                if (Session.getInstance().login(inputString("Login: "), inputString("Password: "), inputString("Location: ")))
                    break;
            } catch (Exception ignored) {
            }
            printErr("Login failed");
        }

    }

}
