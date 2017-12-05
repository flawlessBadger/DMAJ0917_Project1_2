package controllayer;

import modellayer.Bundle;
import modellayer.Item;
import modellayer.Location;
import modellayer.SaleLineItem;
import modellayer.containers.BundleCont;
import modellayer.containers.ItemCont;

public class InventoryController {

    private static ItemCont<String, Item> itemCont = ItemCont.getInstance();
    private static BundleCont<String, Bundle> bundleCont = BundleCont.getInstance();

    public void createItem(String barcode, String name, String description, double salePrice, double costPrice) {
        itemCont.put(barcode, new Item(barcode, name, description, costPrice, salePrice));
    }

    public void createBundle(String barcode, String name, String description, double salePrice) {
        bundleCont.put(barcode, new Bundle(barcode, name, description, salePrice));
    }

    public void addToBundle(String bundleBarcode, String barcode, int amount) {
        bundleCont.get(bundleBarcode).addItem(itemCont.get(barcode), amount);
    }

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


    public ItemEditor getItemEditor(String barcode) {
        return new ItemEditor(itemCont.get(barcode));
    }

    public BundleEditor getBundleEditor(String barcode) {
        return new BundleEditor(bundleCont.get(barcode));
    }

    public void addStock(String barcode, int amount) {
        itemCont.get(barcode).addStock(amount, Location.DIY);
    }

    public boolean remove(String barcode) {
        return (itemCont.remove(barcode) != null || bundleCont.remove(barcode) != null);
    }

    public boolean isValidItem(String barcode) {
        return itemCont.containsKey(barcode);
    }
    public boolean isValidBundle(String barcode) {
        return bundleCont.containsKey(barcode);
    }


    public boolean isBarcodeAvailable(String barcode) {
        return !(itemCont.containsKey(barcode) || bundleCont.containsKey(barcode));
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


}
