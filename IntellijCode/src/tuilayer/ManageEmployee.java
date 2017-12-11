package tuilayer;
import controllayer.EmployeeController;

public class ManageEmployee extends Menu{
    private EmployeeController empCtrl = new EmployeeController();

    public ManageEmployee(Menu parent){

        super("Manage Employee", parent);

        commandWords.add("Create Employee");
        commandWords.add("Edit Employee");
        commandWords.add("List All Employees");

        printMenu();
        menuPrompt();
    }

    @Override
    void resolver(int i) {
        switch (i) {
            case 0:
                createEmployee();
                break;
            case 1:
                editEmployee();
                break;
            case 2:
                resetMenu(empCtrl.toStringAll());
                break;
        }
    }

    private void createEmployee(){
        String userName = inputString("Username: ");

        if(empCtrl.isLoginTaken(userName)){
            empCtrl.createEmployee(userName,inputString("Name: "),inputString("Address: "),inputInteger("Access Level: "),inputString("Password: "));
            resetMenu("Employee created!");
        }else{
            resetMenu("Username already taken!");
        }
    }

    private void editEmployee(){
        String userName = inputString("Username: ");

        if(!empCtrl.isLoginTaken(userName)) {
            new EditEmployee(this,userName);
        }else{
            resetMenu("Wrong Username!");
        }
    }
}
