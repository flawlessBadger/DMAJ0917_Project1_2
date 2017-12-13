package tuilayer;
import controllayer.CustomerController;

public class ManageCustomer extends  Menu {
    CustomerController customer = new CustomerController();

    public ManageCustomer(Menu parent){
        super("Manage Customer",parent);

        commandWords.add("Create Customer");
        commandWords.add("Edit Customer");
        commandWords.add("List All Customers");

        printMenu();
        menuPrompt();
    }

    @Override
    void resolver(int i) {
        switch (i){
            case 0:
                createCustomer();
                break;
            case 1:
                edit();
                break;
            case 2:
                listAll();
                break;
        }
    }

    private void createCustomer(){
        customer.createEmployee(inputString("Name: "), inputString("Address: "),inputString("Telephone: "),inputString("Email: "),inputDouble("Discount in percent: "));
        resetMenu("Customer created!");
    }

    private void edit(){
        int searchId = inputInteger("ID: ");

        if(!customer.isIDTaken(searchId)){
            new EditCustomer(this,searchId);
        }else{
            resetMenu("Not a valid ID");
        }
    }

    private void listAll(){
        resetMenu(customer.toStringAll());
    }
}
