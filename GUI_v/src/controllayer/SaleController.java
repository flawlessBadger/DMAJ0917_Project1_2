package controllayer;

import modellayer.*;
import modellayer.containers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SaleController {

    private static ItemCont<String, Item> itemCont = ItemCont.getInstance();
    private static BundleCont<String, Bundle> bundleCont = BundleCont.getInstance();
    private static LoanCont<String, Loan> loanCont = LoanCont.getInstance();
    private static SaleCont<Sale> saleCont = SaleCont.getInstance();
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
        Location location = null;

        for (Location loc : Location.values()) {
            if (inventoryCtrl.checkStock(barcode, loc)) {
                location = loc;
                break;
            }
        }
        //This salelineitem is not on Stock or doesn't exists
        if (location == null) return false;

        if (inventoryCtrl.isValidItem(barcode)) {
            ((Item)itemCont.get(barcode)).removeStock(1, location);
        } else  if (inventoryCtrl.isValidItem(barcode)) {
            ((Bundle)bundleCont.get(barcode)).removeStock(1, location);
        } else if (inventoryCtrl.isValidItem(barcode)) {
            ((Loan)loanCont.get(barcode)).removeStock(1, location);
        } else {
            return false;
        }

        tempSale.addStock(saleLineItem);
        checkForBundles();
        return true;
    }
    public boolean removeSaleLineItem(String barcode) {
        SaleLineItem saleLineItem = inventoryCtrl.getSaleLineItem(barcode);
        //This salelineitem doesn't exist
        if (saleLineItem == null) return false;

        //This salelineitem hasn't been added to this sale before
        if (!tempSale.hasSaleLineItem(saleLineItem)) return false;

        Location location = null;
        int min = Integer.MAX_VALUE;
        int amount = 0;

        for (Location loc : Location.values()) {
            if ((amount = inventoryCtrl.getStock(barcode, loc)) < min) {
                min = amount;
                location = loc;
                break;
            }
        }
        //This salelineitem is not on Stock
        if (location == null) return false;

        if (inventoryCtrl.isValidItem(barcode)) {
            ((Item)itemCont.get(barcode)).addStock(1, location);
        } else  if (inventoryCtrl.isValidItem(barcode)) {
            ((Bundle)bundleCont.get(barcode)).addStock(1, location);
        } else if (inventoryCtrl.isValidItem(barcode)) {
            ((Loan)loanCont.get(barcode)).addStock(1, location);
        } else {
            return false;
        }

        tempSale.removeStock(saleLineItem);

        return true;
    }
    private void checkForBundles() {
        boolean hasItems;
        for (Bundle bundle : bundleCont.values()) {
            hasItems = true;
            for (Item item : bundle.getItems()) {
                if (!tempSale.hasSaleLineItem(item)) {
                    hasItems = false;
                    break;
                }
            }

            //The bundle is not complete (one or more items are missing)
            if (!hasItems) continue;

            //Remove items of bundle from sale
            for (SaleLineItem saleLineItem : tempSale.getSaleLineItems()) {
                removeSaleLineItem(saleLineItem.getBarcode());
            }
            //Replace it with a bundle
            addSaleLineItem(bundle.getBarcode());
        }
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
