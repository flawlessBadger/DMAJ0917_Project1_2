package modellayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Bundle implements SaleLineItem {
    private String name;
    private double salePrice;
    private String barcode;

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
}
