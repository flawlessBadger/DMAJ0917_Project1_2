package tuilayer;

public class ManageItem extends Menu{

    public ManageItem(Menu parent){
        super("Manage items",parent);

        commandWords.add("Create item");
        commandWords.add("Search item");
        commandWords.add("Edit item");
        commandWords.add("Delete item");

        printMenu();
        menuPrompt();
    }

    @Override
    public void resolver(int i){
        System.out.println("Hello World " + i);
    }
}
