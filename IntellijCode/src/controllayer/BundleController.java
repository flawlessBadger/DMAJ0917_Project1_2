package controllayer;

import modellayer.Bundle;
import modellayer.Item;
import modellayer.Location;
import modellayer.SaleLineItem;
import modellayer.containers.BundleCont;

public class BundleController {

    private static BundleCont bundleCont = BundleCont.getInstance();

    public boolean addBundle(String barcode, String name, double costPrice, double salePrice) {
        if (!bundleCont.containsKey(barcode)) {
            Item item = new Item(barcode, name, costPrice, salePrice);
            bundleCont.put(barcode, item);
            return true;
        }
        return false;
    }
    public boolean removeBundle(String barcode) {
        if (!bundleCont.containsKey(barcode)) {
            Bundle bundle = (Bundle)bundleCont.get(barcode);

            //Remove every assigned stock
            int amount = 0;
            for (Location location : Location.values()) {
                if ((amount = bundle.checkStock(location)) > 0) {
                    bundle.removeStock(amount, location);
                }
            }
            //Remove every assigned discount
            for (Integer quantity : bundle.getDiscounts().keySet()) {
                bundle.removeDiscount(quantity);
            }
            //Remove from container
            bundleCont.remove(barcode);

            return true;
        }
        return false;
    }
    public boolean updateBundle(String name, String barcode, double salePrice) {
        if (bundleCont.containsKey(barcode)) {
            Bundle bundle = (Bundle)bundleCont.get(barcode);

            bundle.setName(name);
            bundle.setSalePrice(salePrice);

            bundleCont.replace(barcode, bundle);
            return true;
        }
        return false;
    }
    public Bundle getBundle(String barcode) {
        return (Bundle)getSaleLineItem(barcode);
    }
    public SaleLineItem getSaleLineItem(String barcode) {
        return (SaleLineItem) bundleCont.getOrDefault(barcode, null);
    }
}
