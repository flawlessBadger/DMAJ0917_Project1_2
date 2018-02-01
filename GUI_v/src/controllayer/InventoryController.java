package controllayer;

import java.util.Map;
import modellayer.*;
import modellayer.containers.BundleCont;
import modellayer.containers.ItemCont;
import modellayer.containers.LoanCont;

public class InventoryController {

    private ItemCont<String, Item> itemCont = ItemCont.getInstance();
    private BundleCont<String, Bundle> bundleCont = BundleCont.getInstance();
    private LoanCont<String, Loan> loanCont = LoanCont.getInstance();

    public void createItem(String barcode, String name, String description, double salePrice, double costPrice) {
        itemCont.put(barcode, new Item(barcode, name, description, costPrice, salePrice));
    }

    public void createBundle(String barcode, String name, String description, double salePrice) {
        bundleCont.put(barcode, new Bundle(barcode, name, description, salePrice));
    }

    public void createLoan(String barcode, String name, String description, double salePrice, double discount, String location, int period) {
        loanCont.put(barcode, new Loan(barcode, name, description, salePrice, discount, Location.valueOf(location), period));
    }

    public void addToBundle(String bundleBarcode, String barcode, int amount) {
        bundleCont.get(bundleBarcode).addItem(itemCont.get(barcode), amount);
    }

    public SaleLineItem getSaleLineItem(String barcode) {
        SaleLineItem saleLineItem;

        if ((saleLineItem = itemCont.get(barcode)) != null) return saleLineItem;
        if ((saleLineItem = bundleCont.get(barcode)) != null) return saleLineItem;
        if ((saleLineItem = loanCont.get(barcode)) != null) return saleLineItem;

        return null;
    }

    public void addStock(String barcode, int amount) {
        getSaleLineItem(barcode).addStock(amount, Session.getInstance().getLocation());
    }

    public boolean removeStock(String barcode, int amount, Location location) {
        SaleLineItem saleLineItem = getSaleLineItem(barcode);

        //This salelineitem doesn't exists
        if (saleLineItem == null)
            return false;

        return saleLineItem.removeStock(amount, location);
    }

    public int getStock(String barcode, Location location) {
        SaleLineItem saleLineItem = getSaleLineItem(barcode);

        //This salelineitem doesn't exists
        /*
        if (saleLineItem == null)
            return 0;
        */

        return saleLineItem.checkStock(location);
    }
    public int getTotalStock(String barcode) {
    	SaleLineItem saleLineItem = getSaleLineItem(barcode);
    	
    	int quantity = 0;
    	for (Location location : Location.values()) {
    		quantity += saleLineItem.checkStock(location);
    	}
    	
    	return quantity;
    }

    public boolean checkStock(String barcode, Location location) {
        SaleLineItem saleLineItem = getSaleLineItem(barcode);

        //This salelineitem doesn't exists or is not on stock
        if (/*saleLineItem == null || */saleLineItem.checkStock(location) == 0)
            return false;

        return true;
    }

    public boolean remove(String barcode) {

        return (itemCont.remove(barcode) != null ||
                bundleCont.remove(barcode) != null ||
                loanCont.remove(barcode) != null);
    }

    public boolean isValidItem(String barcode) {
        return itemCont.containsKey(barcode);
    }

    public boolean isValidBundle(String barcode) {
        return bundleCont.containsKey(barcode);
    }

    public boolean isValidLoan(String barcode) {
        return loanCont.containsKey(barcode);
    }

    public boolean isBarcodeAvailable(String barcode) {
        return !(itemCont.containsKey(barcode) || bundleCont.containsKey(barcode) || loanCont.containsKey(barcode));
    }

    public String checkBarcode(String barcode){
        if(isValidItem(barcode)){
        	return "Barcode used by an item!";
        }else if(isValidBundle(barcode)){
        	return "Barcode used by an bundle!";
        }else if(isValidLoan(barcode)){
        	return "Barcode used by an loanable item!";
        }else {
        	return "Ups! Something went wrong";
        }
    }
    
    public String findItem(String barcode) {
        StringBuilder s = new StringBuilder();
        for (Map.Entry<String, Item> entry : itemCont.entrySet()) {
            if(entry.getKey().equals(barcode)) {
            	s.append(""+entry.getValue().getName());
            }
        }
        return s.toString();
    }
    
    public double getPrice(String barcode, int quantity) {
    	SaleLineItem saleLineItem = getSaleLineItem(barcode);
    	if (saleLineItem == null)
    		return 0.0;
    	
    	return saleLineItem.getPrice(quantity);
    }
    
//    public boolean isItem(barcode){
//
//    }

//    public Item getItem(String barcode) {
//        return (Item) getSaleLineItem(barcode);
//    }
//
//    public SaleLineItem getSaleLineItem(String barcode) {
//        return (SaleLineItem) itemCont.getOrDefault(barcode, null);
//    }


//    public boolean removeItem(String barcode) {
//        if (!itemCont.containsKey(barcode)) {
//            Item item = (Item) itemCont.get(barcode);
//
//            //Remove every assigned stock
//            int amount = 0;
//            for (Location location : Location.values()) {
//                if ((amount = item.checkStock(location)) > 0) {
//                    item.removeStock(amount, location);
//                }
//            }
//            //Remove every assigned discount
//            for (Integer quantity : item.getDiscounts().keySet()) {
//                item.removeDiscount(quantity);
//            }
//            //Remove from container
//            itemCont.remove(barcode);
//
//            return true;
//        }
//        return false;
//    }


//    public boolean updateItem(String barcode, String name, double costPrice, double salePrice) {
//        if (itemCont.containsKey(barcode)) {
//            Item item = (Item) itemCont.get(barcode);
//
//            item.setName(name);
//            item.setCostPrice(costPrice);
//            item.setSalePrice(salePrice);
//
//            itemCont.replace(barcode, item);
//            return true;
//        }
//        return false;
//    }


}
