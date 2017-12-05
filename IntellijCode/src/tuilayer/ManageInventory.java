package tuilayer;
import controllayer.InventoryController;

public class ManageInventory extends Menu {
    private InventoryController invCtrl = new InventoryController();

    public ManageInventory(Menu parent){
        super("Manage items", parent);

        commandWords.add("Create Item");
        commandWords.add("Create Bundle");
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
                edit();
        }
    }

    public void createItem(){
        String barcode = inputString("Barcode: ");

        if(invCtrl.isBarcodeAvailable(barcode)){

            invCtrl.createItem(barcode,inputString("Name: "),inputString("Description: "),inputDouble("Sale price: "),inputDouble("Cost price: "));

            printMenu();
            System.out.println("Item created successfully");
            menuPrompt();
        }else{
            if(invCtrl.isValidItem(barcode)){
                System.out.print("There is a item with this barcode!\n");
            }else{
                System.out.print("There is a bundle with this barcode!\n");
            }
        }
    }

    public void createBundle(){
        int anotherOne = 0;

        String barcode = inputString("Barcode: ");

        if(invCtrl.isBarcodeAvailable(barcode)){

            invCtrl.createBundle(barcode,inputString("Name: "),inputString("Description: "),inputDouble("Sale price: "));

            while(anotherOne == 0){

                invCtrl.addToBundle(barcode,inputString("Add item by barcode: "),inputInteger("Amount: "));

                anotherOne = inputInteger("\nAdd another one ?\n"+
                        "(0) No\n"+
                        "(1) Yes\n > " );
            }

            printMenu();
            System.out.println("Bundle created successfully");
            menuPrompt();
        }else{
            if(invCtrl.isValidItem(barcode)){
                System.out.print("There is a item with this barcode!\n");
            }else if(invCtrl.isValidBundle(barcode)){
                System.out.print("There is a bundle with this barcode!\n");
            }
        }
    }

    private void edit(){

    }
}
