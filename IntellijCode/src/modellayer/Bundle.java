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

    public Bundle(String name, String barcode) {
        this.name = name;
        this.barcode = barcode;
    }

    @Override
    public double getPrice() {
        return salePrice;
    }

    @Override
    public int checkStock(Location location) {


        return 0;
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
