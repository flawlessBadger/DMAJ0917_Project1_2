package modellayer;

import java.util.Date;
import java.util.HashMap;

public class Lease implements SaleLineItem {
    private String name;
    private String description;
    private String barcode;
    private double salePrice;
    private double discount;
    private boolean isAvailable;
    private Location location;
    private Date lastLeas;
    private int period;


    public Lease(String barcode, String name, String description, double salePrice, double discount, Location location, int period) {
        this.barcode = barcode;
        this.name = name;
        this.description = description;
        this.salePrice = salePrice;
        this.discount = discount;
        this.isAvailable = true;
        this.location = location;
        this.period = period;
        lastLeas = new Date();
    }

    @Override
    public double getPrice(int quantity) {
        return salePrice - salePrice * discount;
    }

    @Override
    public int checkStock(Location location) {

        return (isAvailable) ? 1 : 0;
    }

    @Override
    public boolean removeStock(int amount, Location location) {
        if (isAvailable) {
            isAvailable = true;
            lastLeas = new Date();
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
        return 0;
    }

    public Date getLastLeas() {
        return lastLeas;
    }

    public int returnLease() {
        isAvailable = true;
        if (lastLeas.getTime() + period * 86400000 >= System.currentTimeMillis())
            return (int) ((lastLeas.getTime() - System.currentTimeMillis()) / 86400000);
        return 0;

    }
}
