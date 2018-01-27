package tuilayer;
import controllayer.InventoryController;

public class ManageInventory extends Menu {
    private InventoryController invCtrl = new InventoryController();

    ManageInventory(Menu parent){
        super("Manage Inventory", parent);

        commandWords.add("Create Item");
        commandWords.add("Create Bundle");
        commandWords.add("Create Loanable Item");
        commandWords.add("Edit");
        commandWords.add("Restock");
        commandWords.add("Remove");

        printMenu();
        menuPrompt();
    }

    @Override
    public void resolver(int i) {
        switch(i){
            case 0:
                createItem();
                break;
            case 1:
                createBundle();
                break;
            case 2:
                createLoan();
                break;
            case 3:
                edit();
                break;
            case 4:
                restock();
                break;
            case 5:
                remove();
                break;
        }
    }

    private void createItem(){
        String barcode = inputString("Barcode: ");

        if(invCtrl.isBarcodeAvailable(barcode)){

            invCtrl.createItem(barcode,inputString("Name: "),inputString("Description: "),inputDouble("Sale price: "),inputDouble("Cost price: "));

            resetMenu("Item created successfully");
        }else{
            checkBarcode(barcode);
        }
    }

    private void createBundle(){
        int anotherOne = 1;

        String barcode = inputString("Barcode: ");

        if(invCtrl.isBarcodeAvailable(barcode)){

            invCtrl.createBundle(barcode,inputString("Name: "),inputString("Description: "),inputDouble("Sale price: "));

            while(anotherOne == 1){
                String itemBarcode = inputString("Add item by barcode: ");
                if(invCtrl.isValidItem(itemBarcode)) {
                    invCtrl.addToBundle(barcode, itemBarcode, inputInteger("Amount: "));
                }else{
                    System.out.print("Barcode is not valid!");
                }
                anotherOne = inputInteger("\nAdd another one ?\n"+
                        "(1) Yes\n"+
                        "(2) No\n > " );
            }

            resetMenu("Bundle created successfully");
        }else{
            checkBarcode(barcode);
        }
    }

    private void createLoan(){
        String barcode = inputString("Barcode: ");

        if(invCtrl.isBarcodeAvailable(barcode)){

            invCtrl.createLoan(barcode,inputString("Name: "),inputString("Description: "),inputDouble("Sale Price: "), inputDouble("Discount in percent"),inputString("Location: "),inputInteger("Period: "));

            resetMenu("Loanable Item created successfully");
        }else{
            checkBarcode(barcode);
        }
    }

    private void checkBarcode(String barcode){
        if(invCtrl.isValidItem(barcode)){
            resetMenu("Barcode is already used by an item!");
        }else if(invCtrl.isValidBundle(barcode)){
            resetMenu("Barcode is already used by an bundle!");
        }else{
            resetMenu("Barcode is already used by an loanable item!");
        }
    }


    private void edit(){
        String barcode = inputString("Barcode: ");

        if(invCtrl.isBarcodeAvailable(barcode)){
            resetMenu("No item/bundle was found with barcode "+barcode);
        }else{
            if (invCtrl.isValidBundle(barcode)){
                new EditBundle(this,barcode);
            }else if(invCtrl.isValidItem(barcode)){
                new EditItem(this,barcode);
            }else{
                new EditLoan(this, barcode);
            }
        }
    }

    private void restock(){
        String barcode = inputString("Barcode: ");

        if(invCtrl.isBarcodeAvailable(barcode)){
            resetMenu("Item was not found with barcode "+barcode);
        }else{
            if (invCtrl.isValidItem(barcode)){
                //invCtrl.addStock(barcode,inputInteger("Quantity: "));
                resetMenu("Quantity was added!");
            }else if(invCtrl.isValidBundle(barcode)){
                resetMenu("Barcode is already used by an bundle!");
            }else{
                resetMenu("Barcode is already used by an loanable item!");
            }
        }
    }

    private void remove(){
        String barcode = inputString("Barcode: ");

        if(invCtrl.isBarcodeAvailable(barcode)){
            resetMenu("Item/Bundle was not found with barcode "+barcode);
        }else{
            if(invCtrl.remove(barcode)){
                if(invCtrl.isValidItem(barcode)){
                    resetMenu("Item with barcode "+barcode+" was deleted!");
                }else if(invCtrl.isValidBundle(barcode)){
                    resetMenu("Bundle with barcode "+barcode+" was deleted!");
                }else{
                    resetMenu("Loanable item with barcode "+barcode+" was deleted!");
                }
            }else{
                resetMenu("Something went wrong!");
            }
        }
    }
}
