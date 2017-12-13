package controllayer;

import modellayer.*;
import modellayer.containers.CustomerCont;
import modellayer.containers.LoanCont;
import modellayer.containers.SaleCont;

import java.util.ArrayList;
import java.util.List;

public class SaleController {
    //TODO:check if sum of items in items and bundles is not exceeding the amount in stock


    private SaleCont<Sale> saleCont = SaleCont.getInstance();
    private CustomerCont<Integer, Customer> customerCont = CustomerCont.getInstance();
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
        return saleLineItem != null && tempSale.addSaleLineItem(saleLineItem);

    }
    public boolean finishSale(int paymentId, double discount) {
        if (tempSale == null || !tempSale.hasSaleLineItems())
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
    public ArrayList<String> getPaymentMethods() {
        ArrayList<String> paymentMethods = new ArrayList<>();
        for (Payment payment : Payment.values()) {
            paymentMethods.add(payment.toString());
        }
        return paymentMethods;
    }
}
