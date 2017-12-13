package modellayer;

import controllayer.InventoryController;
import modellayer.containers.BundleCont;
import modellayer.containers.ItemCont;
import modellayer.containers.LoanCont;

import java.util.*;

public class Sale {

    private InventoryController inventoryController = new InventoryController();
    private static ItemCont<String, Item> itemCont = ItemCont.getInstance();
    private static BundleCont<String, Bundle> bundleCont = BundleCont.getInstance();
    private static LoanCont<String, Loan> loanCont = LoanCont.getInstance();
    private static final double MAX_DISCOUNT = 0.2;
    private static int nextId = 0;
    private int id;
    //private SaleAssistant saleAssistant;
    //private Delivery deliveryOption;
    private Customer customer;
    private double discount;
    private Payment paymentMethod;
    private Date timestamp;
    private HashMap<SaleLineItem, Integer> saleLineItems;

    public Sale(/*SaleAssistant saleAssistant, Delivery deliveryOption,*/ Customer customer) {
        this.id = ++nextId;
        //this.saleAssistant = saleAssistant;
        //this.deliveryOption = deliveryOption;
        this.customer = customer;
        this.saleLineItems = new HashMap<>();
    }
    public Sale(/*SaleAssistant saleAssistant*/) {
        this(/*saleAssistant, Delivery.PICKUP, */ null);
    }

    /*
    public SaleAssistant getSaleAssistant() {
        return saleAssistant;
    }
    public Delivery getDeliveryOption() {
        return deliveryOption;
    }
    */
    public int getId() {
        return id;
    }
    public Customer getCustomer() {
        return customer;
    }
    public double getDiscount() {
        return discount;
    }
    public Payment getPaymentMethod() {
        return paymentMethod;
    }
    public Date getTimestamp() {
        return timestamp;
    }
    public HashSet<SaleLineItem> getSaleLineItems() {
        return new HashSet<SaleLineItem>(saleLineItems.keySet());
    }

    public boolean addSaleLineItem(SaleLineItem saleLineItem) {
        String barcode = saleLineItem.getBarcode();
        Location location = null;

        for (Location loc : Location.values()) {
            if (inventoryController.checkStock(barcode, loc)) {
                location = loc;
                break;
            }
        }
        //This salelineitem is not on Stock or doesn't exists
        if (location == null) return false;

        if (inventoryController.isValidItem(barcode)) {
            ((Item)itemCont.get(barcode)).removeStock(1, location);
        } else  if (inventoryController.isValidItem(barcode)) {
            ((Bundle)bundleCont.get(barcode)).removeStock(1, location);
        } else if (inventoryController.isValidItem(barcode)) {
            ((Loan)loanCont.get(barcode)).removeStock(1, location);
        } else {
            return false;
        }

        saleLineItems.put(saleLineItem, 1 + (saleLineItems.getOrDefault(saleLineItem, 0)));
        checkForBundles();
        return true;
    }
    public boolean removeSaleLineItem(String barcode) {
        SaleLineItem saleLineItem = inventoryController.getSaleLineItem(barcode);
        //This salelineitem doesn't exist
        if (saleLineItem == null) return false;

        //This salelineitem hasn't been added to this sale before
        if (!saleLineItems.containsKey(saleLineItem)) return false;

        Location location = null;
        int min = Integer.MAX_VALUE;
        int amount = 0;

        for (Location loc : Location.values()) {
            if ((amount = inventoryController.getStock(barcode, loc)) < min) {
                min = amount;
                location = loc;
                break;
            }
        }
        //This salelineitem is not on Stock
        if (location == null) return false;

        if (inventoryController.isValidItem(barcode)) {
            ((Item)itemCont.get(barcode)).addStock(1, location);
        } else  if (inventoryController.isValidItem(barcode)) {
            ((Bundle)bundleCont.get(barcode)).addStock(1, location);
        } else if (inventoryController.isValidItem(barcode)) {
            ((Loan)loanCont.get(barcode)).addStock(1, location);
        } else {
            return false;
        }

        saleLineItems.put(saleLineItem, -1 + saleLineItems.get(saleLineItem));
        if (saleLineItems.get(saleLineItem) < 1)
            saleLineItems.remove(saleLineItem);

        return true;
    }
    private void checkForBundles() {
        boolean hasItems;
        for (Bundle bundle : (HashSet<Bundle>)bundleCont.values()) {
            hasItems = true;
            for (Item item : bundle.getItems()) {
                if (!saleLineItems.containsKey((SaleLineItem)item)) {
                    hasItems = false;
                    break;
                }
            }

            //The bundle is not complete (one or more items are missing)
            if (!hasItems) continue;

            //Remove items of bundle from sale
            for (SaleLineItem saleLineItem : saleLineItems.keySet()) {
                removeSaleLineItem(saleLineItem.getBarcode());
            }
            //Replace it with a bundle
            addSaleLineItem(bundle);
        }
    }
    public boolean finishSale(Payment paymentMethod, double discount) {
        if (isFinished()) return true;
        this.paymentMethod = paymentMethod;
        this.timestamp = new Date();
        this.discount = calculateDiscount();
        //Discount can only be obtained if it's under the MAX_DISCOUNT
        //and greater than the calculated discount
        if (discount <= MAX_DISCOUNT && discount > this.discount)
            this.discount = discount;

        return true;
    }
    public boolean isFinished() {
        return timestamp == null;
    }
    private double calculateDiscount() {
        double totalSalePrice = 0, totalDiscountPrice = 0;
        for (SaleLineItem saleLineItem : saleLineItems.keySet()) {
            totalDiscountPrice += saleLineItem.getSalePrice() - saleLineItem.getPrice(saleLineItems.get(saleLineItem));
            totalSalePrice += saleLineItem.getSalePrice();
        }

        //Item discounts
        double discount = totalDiscountPrice / totalSalePrice;
        if (discount > MAX_DISCOUNT)
            return discount;
        //Customer discount
        discount *= (1 - customer.getDiscount());
        if (discount > MAX_DISCOUNT)
            return MAX_DISCOUNT;
        //Sale discount
        discount *= (1 - this.discount);
        if (discount > MAX_DISCOUNT)
            return MAX_DISCOUNT;

        return discount;
    }
}
