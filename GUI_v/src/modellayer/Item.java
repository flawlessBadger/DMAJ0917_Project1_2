package modellayer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Item implements SaleLineItem {
    private String name;


    private String description;
    private double salePrice;
    private TreeMap<Integer, Double> discounts; //[0]quantity,[1]discountPercentage
    private double costPrice;

    private HashMap<Location, Integer> stock;
    private HashMap<Location, Integer> minStock;
    private HashMap<Location, Integer> maxStock;
    private String barcode;

    public Item(String barcode) {
        this.barcode = barcode;
        this.discounts = new TreeMap<>();
        this.stock = new HashMap<>();
        this.minStock = new HashMap<>();
        this.maxStock = new HashMap<>();
    }

    public Item(String barcode, String name, String description, double costPrice, double salePrice) {
        this.barcode = barcode;
        this.name = name;
        this.description = description;
        this.discounts = new TreeMap<>();
        this.stock = new HashMap<>();
        this.minStock = new HashMap<>();
        this.maxStock = new HashMap<>();
        this.costPrice = costPrice;
        this.salePrice = salePrice;
    }
    
    @Override
    public void addStock(int quantity, Location location) {
        stock.put(location, quantity + stock.getOrDefault(location, 0));
    }

    @Override
    public int checkStock(Location location) {
        return stock.getOrDefault(location, 0);
    }

    @Override
    public boolean removeStock(int amount, Location location) {
        int currentAmount = stock.getOrDefault(location, 0);
        if (amount <= currentAmount) {
            stock.put(location, currentAmount - amount);
            return true;
        }
        return false;
    }


    //discounts management
    public void setDiscount(int amount, double percentage) {
        discounts.put(amount, percentage);
    }

    @Override
    public double getDiscount(int quantity) {
        if (discounts.floorKey(quantity) == null)
            return 0;
        return discounts.floorKey(quantity);
    }
    
    public String getAllKeys() {
    	String keys = "";
    	for (Map.Entry<Integer, Double> entry : discounts.entrySet()) {
    	     keys += "-"+entry.getKey();
    	}
    	return keys;
    }
    
    public String getAllValues() {
    	String values = "";
    	for (Map.Entry<Integer, Double> entry : discounts.entrySet()) {
    		values += "-"+entry.getValue().intValue()+"%";
    	}
    	return values;
    }

    
    public boolean removeDiscount(int amount) {
        if (discounts.containsKey(amount)) {
            discounts.remove(amount);
            return true;
        }
        return false;
    }


    //getters
    @Override
    public String getName() {
    	return name;
    }
    
    @Override
    public String getBarcode() {
        return barcode;
    }

    @Override
    public double getSalePrice() {
        return salePrice;
    }
    @Override
    public double getPrice(int quantity) {
//        if (discounts.floorKey(quantity) == null)
//            return salePrice;
        return salePrice - salePrice * (discounts.floorKey(quantity) / 100);
    }

    public String getDescription() {
    	return description;
    }
    
    public double getCostPrice() {
        return costPrice;
    }


    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMinStock(Location location, int amount) {
        this.minStock.put(location, amount);
    }

    public void setStock(Location location, int amount) {
        this.stock.put(location, amount);
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Name:        " + name +
                "\nDescription: " + description +
                "\nSalePrice:   " + salePrice);
        for (Map.Entry<Integer, Double> entry : discounts.entrySet()) {
            s.append((discounts.firstKey().equals(entry.getKey())) ? "\nDiscounts:   " : "\n             ");
            s.append(entry.getKey()).append("pcs ... ").append(entry.getValue()).append("%");
        }

        Iterator iterator = stock.entrySet().iterator();
        if (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            s.append("\nStock:       ").append(entry.getKey()).append(" ... ").append(entry.getValue()).append("pcs");
            while (iterator.hasNext()) {
                entry = (Map.Entry) iterator.next();
                s.append("\n             ").append(entry.getKey()).append(" ... ").append(entry.getValue()).append("pcs");
            }
        }

        iterator = minStock.entrySet().iterator();
        if (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            s.append("\nMin. stock:  ").append(entry.getKey()).append(" ... ").append(entry.getValue()).append("pcs");
            while (iterator.hasNext()) {
                entry = (Map.Entry) iterator.next();
                s.append("\n             ").append(entry.getKey()).append(" ... ").append(entry.getValue()).append("pcs");
            }
        }

        return s.toString();
    }
}
