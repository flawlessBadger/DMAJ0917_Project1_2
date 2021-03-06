package tuilayer;

import controllayer.ItemEditor;

public class EditItem extends Menu {
    private ItemEditor item;

    EditItem(Menu parent, String barcode){
        super("Edit Item",parent);
        item = new ItemEditor(barcode);

        commandWords.add("Set name");
        commandWords.add("Set description");
        commandWords.add("Set sale price");
        commandWords.add("Set cost price");
        commandWords.add("Set minimum stock");
        commandWords.add("Set stock");
        commandWords.add("Set discount");
        commandWords.add("Remove discount");
        commandWords.add("Show details");

        printMenu();
        menuPrompt();
    }

    @Override
    public void resolver(int i) {
        switch (i) {
            case 0:
                item.setName(inputString("Name: "));
                resetMenu("Name has been set!");
                break;
            case 1:
                item.setDescription(inputString("Description: "));
                resetMenu("Description has been set!");
                break;
            case 2:
                item.setSalePrice(inputDouble("Sale price: "));
                resetMenu("Sale price has been set!");
                break;
            case 3:
                item.setCostPrice(inputDouble("Cost price: "));
                resetMenu("Cost price has been set!");
                break;
            case 4:
                item.setMinStock(inputInteger("Minimum stock: "));
                resetMenu("Minimum stock has been set!");
                break;
            case 5:
                item.setStock(inputInteger("Amount: "));
                resetMenu("Stock has been set!");
                break;
            case 6:
                item.setDiscount(inputInteger("Quantity: "), inputDouble("Discount in percent: "));
                resetMenu("Discount has been set!");
                break;
            case 7:
                if (item.removeDiscount(inputInteger("Quantity: "))) {
                    resetMenu("Discount has been deleted!");
                } else {
                    resetMenu("Discount was not found!");
                }
                break;
            case 8:
                resetMenu(item.toString());
                break;

        }
    }
}
