package modellayer;

import java.util.Date;

public class Loan implements SaleLineItem {
    private String name;
    private String description;
    private String barcode;
    private double salePrice;
    private double discount = 0;
    private boolean isAvailable;
    private Location location;
    private Date lastLoaned;
    private int period;


    public Loan(String barcode, String name, String description, double salePrice, double discount, Location location, int period) {
        this.barcode = barcode;
        this.name = name;
        this.description = description;
        this.salePrice = salePrice;
        this.discount = discount;
        this.isAvailable = true;
        this.location = location;
        this.period = period;
        lastLoaned = new Date();
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public double getSalePrice() {
        return salePrice;
    }

    @Override
    public double getPrice(int quantity) {
        return salePrice - salePrice * discount;
    }

    @Override
    public void addStock(int amount, Location location) {
        isAvailable = amount > 0;
    }

    @Override
    public int checkStock(Location location) {
        return (isAvailable) ? 1 : 0;
    }

    @Override
    public boolean removeStock(int amount, Location location) {
        if (isAvailable) {
            isAvailable = true;
            lastLoaned = new Date();
            return true;
        }
        return false;
    }

    @Override
    public String getBarcode() {
        return barcode;
    }

    @Override
    public double getDiscount(int quantity) {
        return discount;
    }

    public int returnLoan() {
        isAvailable = true;
        if (lastLoaned.getTime() + period * 86400000 >= System.currentTimeMillis())
            return (int) ((lastLoaned.getTime() - System.currentTimeMillis()) / 86400000);
        return 0;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPeriod(int period) {
        this.period = period;
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Name:        " + name +
                "\nBarcode:     " + barcode +
                "\nDescription: " + description +
                "\nSalePrice:   " + salePrice +
                "\nDiscount:    " + discount +
                "\nisAvailable: " + isAvailable +
                "\nLocation:    " + location +
                "\nPeriod:      " + period);
        return s.toString();
    }
}
