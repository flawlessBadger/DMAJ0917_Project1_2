package modellayer;

import java.util.ArrayList;
import java.util.Date;

public class Sale {
    int id;
    double discount;
    private ArrayList<SaleLineItem> saleLineItems;
    private Payment paymentOption;
    private Date timestamp;

    public Sale(int id) {
        timestamp = new Date();
        this.id = id;
    }

}
