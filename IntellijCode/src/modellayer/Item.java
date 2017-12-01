package modellayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Item implements SaleLineItem {
    private String name;
    private double salePrice;
    private TreeMap<Integer, Double> discounts; //[0]quantity,[1]discountPercentage
    private double costPrice;

    private HashMap<Location, Integer> stock;
    private HashMap<Location, Integer> min_stock;
    private String barcode;

    public Item(String barcode, String name) {
        this.barcode = barcode;
        this.name = name;
    }


    @Override
    public double getPrice() {
        return salePrice;
    }

    @Override
    public int checkStock(Location location) {
        return stock.getOrDefault(location, 0);
    }

    @Override
    public boolean removeStock(int amount, Location location) {
        int currentAmount = stock.getOrDefault(location,0);
        if(amount<=currentAmount){
            stock.put(location,currentAmount-amount);
            return true;
        }
        return false;
    }

    @Override
    public String getBarcode() {
        return barcode;
    }
}
