package modellayer;

import java.util.ArrayList;
import java.util.Date;

public class Sale {

    private static int nextId = 0;
    private int id;
    private double discount;
    private ArrayList<SaleLineItem> saleLineItems;
    private Payment paymentOption;
    private Date timestamp;

    public Sale() {
        this.id = ++nextId;
        this.discount = 1;
        this.timestamp = new Date();
    }
}
