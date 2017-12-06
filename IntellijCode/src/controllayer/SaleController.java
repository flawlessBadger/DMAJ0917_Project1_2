package controllayer;

import modellayer.Loan;
import modellayer.Sale;
import modellayer.containers.LoanCont;
import modellayer.containers.SaleCont;

public class SaleController {
    //TODO:check if sum of items in items and bundles is not exceeding the amount in stock

    private SaleCont<Sale> saleCont = SaleCont.getInstance();
    private LoanCont<String, Loan> loanCont = LoanCont.getInstance();


    public boolean isValidLoan(String barcode) {
        return loanCont.containsKey(barcode);
    }

    public int returnLoan(String barcode) {
        return loanCont.get(barcode).returnLoan();
    }
}
