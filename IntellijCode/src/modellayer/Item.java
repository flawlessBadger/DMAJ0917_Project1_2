package modellayer;

import java.util.HashMap;
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

    public String getName() {
        return this.name;
    }

    public double getCostPrice() {
        return this.costPrice;
    }

    public double getSalePrice() {
        return this.salePrice;
    }


    public void addStock(int quantity, Location location) {
        stock.put(location, stock.get(location) + quantity);
    }

    @Override
    public double getPrice(int quantity) {
        if (discounts.lowerKey(quantity) == null)
            return salePrice;
        return salePrice - salePrice * (discounts.lowerKey(quantity) / 100);
    }

    @Override
    public double getDiscount(int quantity) {
        if (discounts.lowerKey(quantity) == null)
            return 0;
        return discounts.lowerKey(quantity);
    }


    //discounts
    public TreeMap<Integer, Double> getDiscounts() {
        return discounts;
    }

    public void setDiscount(int amount, double percentage) {
        discounts.put(amount, percentage);
    }

    public boolean removeDiscount(int amount) {
        if (discounts.containsKey(amount)) {
            discounts.remove(amount);
            return true;
        }
        return false;
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

    @Override
    public String getBarcode() {
        return barcode;
    }

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
}
