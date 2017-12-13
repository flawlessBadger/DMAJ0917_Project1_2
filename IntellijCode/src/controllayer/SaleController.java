package controllayer;

import modellayer.*;
import modellayer.containers.CustomerCont;
import modellayer.containers.LoanCont;
import modellayer.containers.SaleCont;

public class SaleController {
    //TODO:check if sum of items in items and bundles is not exceeding the amount in stock


    private static SaleCont<Sale> saleCont = SaleCont.getInstance();
    private static LoanCont<String, Loan> loanCont = LoanCont.getInstance();
    private static CustomerCont<Integer, Customer> customerCont = CustomerCont.getInstance();
    private InventoryController inventoryCtrl;
    private Sale tempSale;

    public SaleController() {
        this.inventoryCtrl = new InventoryController();
        this.tempSale = null;
    }

    public boolean createSale(int customerId) {
        if (tempSale != null)
            return false;

        tempSale = new Sale(customerCont.getOrDefault(customerId, null));
        return true;
    }
    public boolean createSale() {
        return createSale(-1);
    }
    public boolean addSaleLineItem(String barcode) {
        SaleLineItem saleLineItem = inventoryCtrl.getSaleLineItem(barcode);
        if (saleLineItem == null)
            return false;

        return tempSale.addSaleLineItem(saleLineItem);
    }
    public boolean finishSale(int paymentId, double discount) {
        if (tempSale == null)
            return false;

        Payment paymentMethod;
        switch (paymentId) {
            case 2:
                paymentMethod = Payment.CARD;
                break;
            case 3:
                paymentMethod = Payment.VOUCHER;
                break;
            //case 1:
            default:
                paymentMethod = Payment.CASH;
                break;
        }
        if (!tempSale.finishSale(paymentMethod, discount))
            return false;

        saleCont.add(tempSale);
        tempSale = null;
        return true;
    }

    public boolean isValidLoan(String barcode) {
        return loanCont.containsKey(barcode);
    }
    public int returnLoan(String barcode) {
        return loanCont.get(barcode).returnLoan();
    }
}
