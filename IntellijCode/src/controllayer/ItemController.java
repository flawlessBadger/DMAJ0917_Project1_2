package controllayer;

import modellayer.Bundle;
import modellayer.Item;
import modellayer.Location;
import modellayer.SaleLineItem;
import modellayer.containers.BundleCont;
import modellayer.containers.ItemCont;

import java.util.List;

public class ItemController {

    private static ItemCont itemCont = ItemCont.getInstance();

    public boolean addItem(String barcode, String name, double costPrice, double salePrice) {
        if (!itemCont.containsKey(barcode)) {
            Item item = new Item(barcode, name, costPrice, salePrice);
            itemCont.put(barcode, item);
            return true;
        }
        return false;
    }
    public boolean removeItem(String barcode) {
        if (!itemCont.containsKey(barcode)) {
            Item item = (Item)itemCont.get(barcode);

            //Remove every assigned stock
            int amount = 0;
            for (Location location : Location.values()) {
                if ((amount = item.checkStock(location)) > 0) {
                    item.removeStock(amount, location);
                }
            }
            //Remove every assigned discount
            for (Integer quantity : item.getDiscounts().keySet()) {
                item.removeDiscount(quantity);
            }
            //Remove from container
            itemCont.remove(barcode);

            return true;
        }
        return false;
    }

    public SaleLineItem getLineItem(String barcode) {
        if (itemCont.containsKey(barcode))
            return (Item)itemCont.get(barcode);
        return BundleCont.getInstance().get(barcode);
    }
}
