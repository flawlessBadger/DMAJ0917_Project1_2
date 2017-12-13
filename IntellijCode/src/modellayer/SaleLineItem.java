package modellayer;

public interface SaleLineItem {

    String getBarcode();
    double getSalePrice();
    double getPrice(int quantity);
    double getDiscount(int quantity);

    void addStock(int amount, Location location);
    int checkStock(Location location);
    boolean removeStock(int amount, Location location);
}
