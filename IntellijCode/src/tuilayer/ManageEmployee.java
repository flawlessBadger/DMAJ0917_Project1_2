package tuilayer;

public class ManageEmployee extends Menu{

    public ManageEmployee(Menu parent){
        super("Manage employees",parent);

        commandWords.add("Create employee");
        commandWords.add("Search employee");
        commandWords.add("Edit employee");
        commandWords.add("Delete employee");

        printMenu();
        menuPrompt();
    }

    @Override
    public void resolver(int i){
        System.out.println("Hello World " + i);
    }
}
