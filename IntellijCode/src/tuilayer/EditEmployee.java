package tuilayer;

import controllayer.EmployeeEditor;

public class EditEmployee extends Menu {
    private EmployeeEditor employee;

    EditEmployee(Menu parent, String userName){
        super("Edit Employee",parent);
        employee = new EmployeeEditor(userName);

        commandWords.add("Set Name");
        commandWords.add("Set Address");
        commandWords.add("Set Password");
        commandWords.add("Set Access Level");
        commandWords.add("Show details");

        printMenu();
        menuPrompt();
    }

    @Override
    void resolver(int i) {
        switch (i) {
            case 0:
                employee.setName(inputString("Name: "));
                resetMenu("Name has been set!");
                break;
            case 1:
                employee.setAddress(inputString("Address: "));
                resetMenu("Address has been set!");
                break;
            case 2:
                employee.setPassword(inputString("Password: "));
                resetMenu("Password has been set!");
                break;
            case 3:
                employee.setAccessLevel(inputInteger("Access Level: "));
                resetMenu("Access Level has been set!");
                break;
            case 4:
                resetMenu(employee.toString());
                break;
        }
    }
}
