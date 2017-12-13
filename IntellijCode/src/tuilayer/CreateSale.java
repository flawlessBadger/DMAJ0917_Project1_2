package tuilayer;

import controllayer.CustomerController;
import controllayer.InventoryController;
import controllayer.SaleController;
import modellayer.Payment;

public class CreateSale extends  Menu {

    private SaleController saleCtrl;
    private InventoryController inventoryCtrl;
    private CustomerController customerCtrl;

    public CreateSale(Menu parent){
        super("Create sale",parent);
        this.saleCtrl = new SaleController();
        this.inventoryCtrl = new InventoryController();
        this.customerCtrl = new CustomerController();
        createSale();

        commandWords.add("Scan product");
        commandWords.add("Finish sale");

        printMenu();
        menuPrompt();
    }

    @Override
    void resolver(int i) {
        switch (i){
            case 0:
                addItem();
                break;
            case 1:
                finishSale();
                break;
        }
    }
    private void createSale() {
        int customer = inputInteger("Choose customer by id: ");
        while (customerCtrl.isIDTaken(customer)) {
            System.out.println("There is no customer with the selected id("+Integer.toString(customer)+")!");
            customer = inputInteger("Choose customer by id: ");
        }

        if (!saleCtrl.createSale(customer)) {
            resetMenu("The sale couldn't be created!");
        } else {
            parent.printMenu();
            parent.menuPrompt();
        }
    }
    private void addItem() {
        do {
            String barcode = inputString("Add item by barcode: ");
            if(inventoryCtrl.isValidItem(barcode) && saleCtrl.addSaleLineItem(barcode)) {
                resetMenu("Item was successfully added!");
            }else{
                resetMenu("Barcode is not valid!");
            }
        } while(inputInteger("\nAdd another one ?\n" + "(1) Yes\n" + "(2) No\n > " ) == 1);

        resetMenu("Item(s) were successfully added!");
    }
    private void finishSale() {
        String str = "Choose payment method:\n";
        for (int i = 0; i < Payment.values().length; i++) {
            str += "(" + Integer.toString(i+1) + ") " + Payment.values()[i] + "\n";
        }

        int payment = inputInteger(str);
        while (payment > 0 && payment < Payment.values().length+1) {
            System.out.println("Your selection("+Integer.toString(payment)+") is not valid!");
            payment = inputInteger(str);
        }
        double discount = inputDouble("Add discount: ");

        if (!saleCtrl.finishSale(payment, discount)) {
            resetMenu("The sale couldn't be finished!");
        } else {
            parent.printMenu();
            parent.menuPrompt();
        }
    }
}
