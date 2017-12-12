package tuilayer;
import controllayer.CustomerEditor;

public class EditCustomer extends Menu {
    CustomerEditor customer;
    public EditCustomer(Menu parent, int customerID){
        super("Edit Customer",parent);
        customer = new CustomerEditor(customerID);

        commandWords.add("Set Name");
        commandWords.add("Set Address");
        commandWords.add("Set Phone Number");
        commandWords.add("Set Email");
        commandWords.add("Set Discount");
        commandWords.add("Show details");

        printMenu();
        menuPrompt();
    }

    @Override
    void resolver(int i) {
        switch (i){
            case 0:
                customer.setName(inputString("Name: "));
                resetMenu("Name has been set!");
                break;
            case 1:
                customer.setAddress(inputString("Address: "));
                resetMenu("Address has been set!");
                break;
            case 2:
                customer.setPhoneNumber(inputString("Phone Number: "));
                resetMenu("Phone Number has been set!");
                break;
            case 3:
                customer.setEmail(inputString("Email: "));
                resetMenu("Email has been set!");
                break;
            case 4:
                customer.setDiscount(inputDouble("Discount in percent: "));
                resetMenu("Discount has been set!");
                break;
            case 5:
                resetMenu(customer.toString());
                break;
        }
    }
}
