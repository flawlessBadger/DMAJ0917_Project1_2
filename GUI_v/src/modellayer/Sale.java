package modellayer;

import java.util.*;

public class Sale {

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
    public boolean hasSaleLineItems() {
        return !saleLineItems.isEmpty();
    }
    public boolean hasSaleLineItem(SaleLineItem saleLineItem) {
        return saleLineItems.containsKey(saleLineItem);
    }

    public void addStock(SaleLineItem saleLineItem) {
        saleLineItems.put(saleLineItem, 1 + (saleLineItems.getOrDefault(saleLineItem, 0)));
    }
    public void removeStock(SaleLineItem saleLineItem) {
        saleLineItems.put(saleLineItem, -1 + saleLineItems.get(saleLineItem));
        if (saleLineItems.get(saleLineItem) < 1)
            saleLineItems.remove(saleLineItem);
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
