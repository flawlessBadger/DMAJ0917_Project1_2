package controllayer;

import modellayer.Loan;
import modellayer.Location;
import modellayer.containers.LoanCont;

public class LoanEditor {

    Loan loan;

    public LoanEditor(String barcode) {
        this.loan = LoanCont.getInstance().get(barcode);
    }

    public void setName(String name) {
        loan.setName(name);
    }

    public void setDescription(String description) {
        loan.setDescription(description);
    }

    public void setSalePrice(double salePrice) {
        loan.setSalePrice(salePrice);
    }

    public void setDiscount(double discount) {
        loan.setDiscount(discount);
    }

//TODO: add location setter

    public void setPeriod(int period) {
        loan.setPeriod(period);
    }

}
