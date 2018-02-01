package modellayer;

import java.util.*;
import modellayer.containers.CustomerCont;

public class Sale {
	
    public static final double MAX_DISCOUNT = 20;
    private static int nextId = 0;
    private int id;
    //private int saleAssistantId;
    //private Delivery deliveryOption;
    private int customerId;
    private double discount;
    private Payment paymentMethod;
    private Date timestamp;
    private HashMap<String, Integer> saleLineItems;

    public Sale() {
        this.id = ++nextId;
        this.customerId = -1;
        this.discount = 0.0;
        this.saleLineItems = new HashMap<>();
    }

    /*
    public int getSaleAssistantId() {
        return saleAssistantId;
    }
    public Delivery getDeliveryOption() {
        return deliveryOption;
    }
    */
    public int getId() {
        return id;
    }
    public int getCustomerId() {
        return customerId;
    }
    public double getDiscount() {
        return discount;
    }
    public Payment getPaymentMethod() {
        return paymentMethod;
    }
    public Date getTimestamp() {
        return timestamp;
    }
    /*
    public void setSaleAssistantId(int saleAssistantId) {
	    this.saleAssistantId = saleAssistantId;
	}
	public void setDeliveryOption(Delivery deliveryOption) {
	    this.deliveryOption = deliveryOption;
	}
	*/
	public void setCustomerId(int customerId) {
	    this.customerId = customerId;
	}
	public void setDiscount(double discount) {
	    this.discount = discount;
	}
	public void setPaymentMethod(Payment paymentMethod) {
	    this.paymentMethod = paymentMethod;
	}
    
    public HashSet<String> getSaleLineItems() {
        return new HashSet<String>(saleLineItems.keySet());
    }
    public boolean hasSaleLineItems() {
        return !saleLineItems.isEmpty();
    }
    public boolean hasSaleLineItem(String barcode) {
        return saleLineItems.containsKey(barcode);
    }
    public int getStock(String barcode) {
    	return saleLineItems.getOrDefault(barcode, 0);
    }
    public void addStock(String barcode) {
        saleLineItems.put(barcode, 1 + (saleLineItems.getOrDefault(barcode, 0)));
    }
    public void removeStock(String barcode) {
        saleLineItems.put(barcode, -1 + saleLineItems.get(barcode));
        if (saleLineItems.get(barcode) < 1)
            saleLineItems.remove(barcode);
    }
    public boolean finishSale() {
        if (isFinished()) return true;
        
        /*
        if (saleAssistantId < 0) return false;
        if (deliveryOption == null) return false;
        */
        if (paymentMethod == null) return false;

        this.timestamp = new Date();
        return true;
    }
    public boolean isFinished() {
        return timestamp == null;
    }
}
