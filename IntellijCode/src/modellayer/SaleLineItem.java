package modellayer;

public interface SaleLineItem {

    double getPrice(int quantity);

    int checkStock(Location location);

    boolean removeStock(int amount, Location location);

    String getBarcode();

    double getDiscount(int quantity);
}
