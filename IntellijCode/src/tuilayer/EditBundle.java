package tuilayer;
import controllayer.BundleEditor;

public class EditBundle extends Menu {
    private BundleEditor bundle;

    EditBundle(Menu parent, String barcode){
        super("Edit Bundle",parent);
        bundle = new BundleEditor(barcode);

        commandWords.add("Set name");
        commandWords.add("Set description");
        commandWords.add("Set sale price");
        commandWords.add("Set discount");
        commandWords.add("Remove discount");

        printMenu();
        menuPrompt();
    }

    @Override
    public void resolver(int i) {
        switch(i){
            case 0:
                bundle.setName(inputString("Name: "));
                resetMenu("Name has been edited!");
                break;
            case 1:
                bundle.setDescription(inputString("Description: "));
                resetMenu("Description has been edited!");
                break;
            case 2:
                bundle.setSalePrice(inputDouble("Sale price: "));
                resetMenu("Sale price has been edited!");
                break;
            case 3:
                bundle.setDiscount(inputInteger("Quantity: "),inputDouble("Discount in percent: "));
                resetMenu("Discount has been edited!");
                break;
            case 4:
                if (bundle.removeDiscount(inputInteger("Quantity: "))){
                    resetMenu("Discount has been deleted!");
                }else{
                    resetMenu("Discount was not found!");
                }
                break;
        }
    }
}
