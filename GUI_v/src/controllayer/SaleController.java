package controllayer;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import modellayer.*;
import modellayer.containers.ItemCont;
import modellayer.containers.BundleCont;
import modellayer.containers.LoanCont;
import modellayer.containers.SaleCont;
import modellayer.containers.CustomerCont;

public class SaleController {
	
	private class Stock {
		
		private String barcode;
		private Location location;
		
		public Stock(String barcode, Location location) {
			this.barcode = barcode;
			this.location = location;
		}
		
		public String getBarcode() {
			return barcode;
		}
		public Location getLocation() {
			return location;
		}
		@Override
		public boolean equals(Object obj) {
			if (obj == null)
				return false;
			
			if (!Stock.class.isAssignableFrom(obj.getClass()))
		        return false;
			
			Stock other = (Stock)obj;
			if (!other.barcode.equals(this.barcode))
				return false;
			if (other.location != this.location)
				return false;
			
			return true;
		}
		@Override
		public int hashCode() {
			return 0;
		}
	}
	
    private static ItemCont<String, Item> itemCont = ItemCont.getInstance();
    private static BundleCont<String, Bundle> bundleCont = BundleCont.getInstance();
    private static LoanCont<String, Loan> loanCont = LoanCont.getInstance();
    private static SaleCont<Sale> saleCont = SaleCont.getInstance();
    private static CustomerCont<Integer, Customer> customerCont = CustomerCont.getInstance();
    private InventoryController inventoryCtrl;
    private Sale tempSale;
    private LinkedHashMap<Stock, Integer> stockMap;

    public SaleController() {
        this.inventoryCtrl = new InventoryController();
    }
	public void setCustomerId(int customerId) {
	    tempSale.setCustomerId(customerId);
	}
	public void setDiscount(double discount) {
		tempSale.setDiscount(discount);
	}
	public void setPaymentMethod(int paymentMethodId) {
		Payment paymentMethod;
        switch (paymentMethodId) {
        	case 1:
        		paymentMethod = Payment.CASH;
        		break;
            case 2:
                paymentMethod = Payment.CARD;
                break;
            //case 3:
            default:
                paymentMethod = Payment.VOUCHER;
                break;
        }
		tempSale.setPaymentMethod(paymentMethod);
	}
    public boolean createSale() {
        if (tempSale != null)
            return false;

        tempSale = new Sale();
        stockMap = new LinkedHashMap<Stock, Integer>();
        return true;
    }
    public boolean cancelSale() {
    	
    	for (String barcode : tempSale.getSaleLineItems()) {
    		for (int i = tempSale.getStock(barcode); i > 0; i--)
    			if (!removeSaleLineItem(barcode))
    				return false;
    	}
    	
    	tempSale = null;
    	stockMap = null;
    	return true;
    }
    public boolean addSaleLineItem(String barcode) {
        Location location = null;

        for (Location loc : Location.values()) {
            if (inventoryCtrl.checkStock(barcode, loc)) {
                location = loc;
                break;
            }
        }
        //This salelineitem is not on Stock or doesn't exists
        if (location == null) return false;

        if (inventoryCtrl.isValidItem(barcode)) {
            ((Item)itemCont.get(barcode)).removeStock(1, location);
        } else  if (inventoryCtrl.isValidBundle(barcode)) {
            ((Bundle)bundleCont.get(barcode)).removeStock(1, location);
        } else if (inventoryCtrl.isValidLoan(barcode)) {
            ((Loan)loanCont.get(barcode)).removeStock(1, location);
        } else {
            return false;
        }

        tempSale.addStock(barcode);
        Stock stock = new Stock(barcode, location);
        stockMap.put(stock, stockMap.getOrDefault(stock, 0) + 1);
        checkForBundles();
        return true;
    }
    public boolean removeSaleLineItem(String barcode) {

        //This salelineitem hasn't been added to this sale before
        if (!tempSale.hasSaleLineItem(barcode)) return false;

        Location location = null;
        for (Stock stock : stockMap.keySet()) {
        	if (stock.getBarcode().equals(barcode))
        		location = stock.getLocation();
        }

        if (inventoryCtrl.isValidItem(barcode)) {
            ((Item)itemCont.get(barcode)).addStock(1, location);
        } else  if (inventoryCtrl.isValidItem(barcode)) {
            ((Bundle)bundleCont.get(barcode)).addStock(1, location);
        } else if (inventoryCtrl.isValidItem(barcode)) {
            ((Loan)loanCont.get(barcode)).addStock(1, location);
        } else {
            return false;
        }

        tempSale.removeStock(barcode);
        Stock stock = new Stock(barcode, location);
        int quantity = stockMap.get(stock) - 1;
        if (quantity > 0)
        	stockMap.put(stock, quantity);
        else
        	stockMap.remove(stock);
        
        return true;
    }
    private void checkForBundles() {
        boolean hasItems;
        for (Bundle bundle : bundleCont.values()) {
            hasItems = true;
            for (Item item : bundle.getItems()) {
                if (!tempSale.hasSaleLineItem(item.getBarcode()) ||
                		tempSale.getStock(item.getBarcode()) < bundle.getItemQuantity(item)) {
                    hasItems = false;
                    break;
                }
            }

            //The bundle is not complete (one or more items are missing)
            if (!hasItems) continue;

            //Remove items of bundle from sale
            for (Item item : bundle.getItems()) {
            	for (int i = bundle.getItemQuantity(item); i > 0; i--)
            		removeSaleLineItem(item.getBarcode());
            }
            //Replace it with a bundle
            addSaleLineItem(bundle.getBarcode());
        }
    }
    private double calculateDiscount() {
    	
        int customerId = tempSale.getCustomerId();
        double totalSalePrice = 0, totalDiscountPrice = 0;
        for (String barcode : tempSale.getSaleLineItems()) {
        	SaleLineItem saleLineItem = inventoryCtrl.getSaleLineItem(barcode);
        	int quantity = tempSale.getStock(barcode);
            totalDiscountPrice += saleLineItem.getPrice(quantity) * quantity;
            totalSalePrice += saleLineItem.getSalePrice() * quantity;
        }

        //Item discounts
        double discount = (2 - (totalDiscountPrice / totalSalePrice)) * 100;
        if (discount > Sale.MAX_DISCOUNT + 100)
            return discount - 100;
        //Customer discount
        if (customerId > 0) {
        	discount *= (1 + customerCont.get(customerId).getDiscount() / 100);
	        if (discount > Sale.MAX_DISCOUNT + 100)
	            return Sale.MAX_DISCOUNT;
        }
        //Sale discount
        discount *= (1 + tempSale.getDiscount() / 100);
        if (discount > Sale.MAX_DISCOUNT + 100)
            return Sale.MAX_DISCOUNT;
        
        //Discount can only be obtained if it's under the MAX_DISCOUNT
        //and greater than the calculated discount
        if (discount <= Sale.MAX_DISCOUNT + 100 && discount >= tempSale.getDiscount() + 100)
        	return discount - 100;

        return Sale.MAX_DISCOUNT;
    }
    public boolean finishSale() {
        if (tempSale == null || !tempSale.hasSaleLineItems())
            return false;
        if (tempSale.getPaymentMethod() == null)
        	return false;

        if (!tempSale.finishSale())
            return false;
        
        saleCont.add(tempSale);
        tempSale = null;
        stockMap = null;
        return true;
    }
    public ArrayList<String> getPaymentMethods() {
        ArrayList<String> paymentMethods = new ArrayList<>();
        for (Payment payment : Payment.values()) {
            paymentMethods.add(payment.toString());
        }
        return paymentMethods;
    }
    public int getTotalTempStock(String barcode) {
    	
    	int quantity = 0;
    	for (Location location : Location.values()) {
    		quantity += stockMap.getOrDefault(new Stock(barcode, location), 0);
    	}
    	
    	return quantity;
    }
    public double getTempDiscount() {
    	return calculateDiscount();
    }
    public double getSumTempPrice() {
    	
    	double count = 0;
    	
    	for (String barcode : tempSale.getSaleLineItems()) {
    		int quanity = tempSale.getStock(barcode);
    		SaleLineItem saleLineItem = inventoryCtrl.getSaleLineItem(barcode);
    		count += saleLineItem.getSalePrice() * quanity;
    	}
    	
    	return count;
    }
    public double getDiscountTempPrice() {
    	
    	double count = getSumTempPrice();
    	
    	count *= calculateDiscount() / 100;
    	
    	return count;
    }
    public double getTotalTempPrice() {
    	
    	double count = getSumTempPrice();
    	
    	count *= 1 - calculateDiscount() / 100;
    	
    	return count;
    }
}
