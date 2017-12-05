package modellayer;

import java.util.*;

public class Bundle implements SaleLineItem {
    private String name;
    private double salePrice;
    private String barcode;
    private TreeMap<Integer, Double> discounts;

    private HashMap<Item, Integer> items;

    public Bundle(String name, String barcode, double salePrice) {
        this.name = name;
        this.barcode = barcode;
        this.salePrice = salePrice;
    }

    public Bundle(String barcode) {
        this.name = name;
        this.barcode = barcode;
    }
    public String getName() {
        return this.name;
    }
    public double getSalePrice() {
        return this.salePrice;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    @Override
    public double getPrice(int quantity) {
        return salePrice * quantity;
    }

    @Override
    public int checkStock(Location location) {
        Iterator it = items.entrySet().iterator();
        int stock = 0;
        Map.Entry pair;
        if (it.hasNext()) {
            pair = (Map.Entry) it.next();
            stock = ((Item) pair.getKey()).checkStock(location) / ((int) pair.getValue());
        }
        while (it.hasNext()) {
            pair = (Map.Entry) it.next();
            if (((Item) pair.getKey()).checkStock(location) / ((int) pair.getValue()) < stock)
                stock = ((Item) pair.getKey()).checkStock(location) / ((int) pair.getValue());
//
//                it.remove();
        }
        return stock;
    }

    @Override
    public boolean removeStock(int amount, Location location) {
        Iterator it = items.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if (((Item) pair.getKey()).checkStock(location) < ((int) pair.getValue()) * amount)
                return false;
            it.remove();
        }

        it = items.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            ((Item) pair.getKey()).removeStock(amount, location);
            it.remove();
        }
        return true;
    }

    @Override
    public String getBarcode() {
        return barcode;
    }


    //discounts
    @Override
    public double getDiscount(int quantity) {
        return 0;
    }

    public void addDiscount(int quantity, double percantage) {
        discounts.put(quantity, percantage);
    }

    public void removeDiscount(int quantity) {
        discounts.remove(quantity);
    }
    public TreeMap<Integer, Double> getDiscounts() {
        return discounts;
    }

}
