package tuilayer;


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
        commandWords.add("Manage Inventory");
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
                break;

        }

    }

}
