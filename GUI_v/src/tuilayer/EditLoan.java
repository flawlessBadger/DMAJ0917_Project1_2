package tuilayer;
import controllayer.LoanEditor;

public class EditLoan extends Menu{
    private LoanEditor loan;

    EditLoan(Menu parent, String barcode){
        super("Edit Loanable Item",parent);
        loan = new LoanEditor(barcode);

        commandWords.add("Set Name");
        commandWords.add("Set Description");
        commandWords.add("Set Sale Price");
        commandWords.add("Set Discount");
        commandWords.add("Set Period");
        commandWords.add("Show Details");

        printMenu();
        menuPrompt();
    }

    @Override
    void resolver(int i) {
        switch (i){
            case 0:
                loan.setName(inputString("Name: "));
                resetMenu("Name hast been set!");
                break;
            case 1:
                loan.setDescription(inputString("Description: "));
                resetMenu("Description has been set!");
                break;
            case 2:
                loan.setSalePrice(inputDouble("Sale Price: "));
                resetMenu("Sale Price has been set!");
                break;
            case 3:
                loan.setDiscount(inputDouble("Discount in percent: "));
                resetMenu("Discount has been set!");
                break;
            case 4:
                loan.setPeriod(inputInteger("Period: "));
                resetMenu("Period has been set!");
                break;
            case 5:
                resetMenu(loan.toString());
                break;
        }
    }
}
