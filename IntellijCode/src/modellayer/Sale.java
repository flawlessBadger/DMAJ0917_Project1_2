package modellayer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Sale {
    double discount;
    private ArrayList<SaleLineItem> saleLineItems;
    private Payment paymentOption;
    private Date timestamp;

    public Sale() {
        timestamp = new Date();
    }

}
