package tuilayer;

import controllayer.CustomerController;
import controllayer.InventoryController;
import controllayer.SaleController;

import java.util.ArrayList;

public class CreateSale extends  Menu {

    private SaleController saleCtrl;
    private InventoryController inventoryCtrl;
    private CustomerController customerCtrl;

    public CreateSale(Menu parent){
        super("Create sale",parent);
        this.saleCtrl = new SaleController();
        this.inventoryCtrl = new InventoryController();
        this.customerCtrl = new CustomerController();

        commandWords.add("Scan product");
        commandWords.add("Finish sale");

        createSale();
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
    	if (!saleCtrl.createSale()) {
            parent.resetMenu("The sale couldn't be created!");
        }
    	
        resetMenu("The sale was created succesfully!");
    }
    private void addItem() {
        do {
            String barcode = inputString("Add item by barcode: ");
            if (!inventoryCtrl.isBarcodeAvailable(barcode) && saleCtrl.addSaleLineItem(barcode)) {
                resetMenu("Item was successfully added!");
            } else {
                resetMenu("Barcode is not valid!");
            }
        } while(inputInteger("\nAdd another one ?\n" + "(1) Yes\n" + "(2) No\n > " ) == 1);

        resetMenu("Item(s) were successfully added!");
    }
    private void finishSale() {
        int customer = -1;
        if (customerCtrl.hasCustomer() && inputInteger("\nIs it a regular customer?\n"+"(1) Yes\n"+"(2) No\n > " ) == 1) {
            customer = inputInteger("Choose customer by id: ");
            while (customerCtrl.isIDTaken(customer)) {
                System.out.println("There is no customer with the selected id(" + Integer.toString(customer) + ")!");
                customer = inputInteger("Choose customer by id: ");
            }
            saleCtrl.setCustomerId(customer);
        }
    	
        String str = "Choose payment method:\n";
        ArrayList<String> paymentMethods = saleCtrl.getPaymentMethods();
        for (int i = 0; i < paymentMethods.size(); i++) {
            str += "(" + Integer.toString(i+1) + ") " + paymentMethods.get(i) + "\n";
        }
        int payment = inputInteger(str);
        while (payment < 1 || payment > paymentMethods.size()) {
            System.out.println("Your selection("+Integer.toString(payment)+") is not valid!");
            payment = inputInteger(str);
        }
        saleCtrl.setPaymentMethod(payment);
        
        double discount = inputDouble("Add discount: ");
        saleCtrl.setDiscount(discount);

        if (!saleCtrl.finishSale()) {
            resetMenu("The sale couldn't be finished!");
        } else {
            parent.resetMenu("The sale is registered to the system!");
        }
    }
}
