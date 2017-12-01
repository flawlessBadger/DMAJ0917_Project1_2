package modellayer;

public interface SaleLineItem {

    double getPrice();

    int checkStock(Location location);

    boolean removeStock(int amount, Location location);

    String getBarcode();
}
