package tuilayer;

public class ManageBundle extends Menu {
    public ManageBundle (Menu parent){
        super("Manage bundles", parent);

        commandWords.add("Create bundle");
        commandWords.add("Search bundle");
        commandWords.add("Edit bundle");
        commandWords.add("Delete bundle");

        printMenu();
        menuPrompt();
    }

    @Override
    public void resolver(int i){
        System.out.print("cunt"+i);
    }
}
