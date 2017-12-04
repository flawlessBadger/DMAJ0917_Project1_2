package controllayer;

import modellayer.Bundle;
import modellayer.Item;
import modellayer.SaleLineItem;
import modellayer.containers.BundleCont;
import modellayer.containers.ItemCont;

public class ItemController {


    public boolean addItem(Item item) {
        if (!ItemCont.getInstance().containsKey(item.getBarcode())) {
            ItemCont.getInstance().put(item.getBarcode(), item);
            return true;
        }
        return false;
    }

    public SaleLineItem getLineItem(String barcode) {
        if (ItemCont.getInstance().containsKey(barcode))
            return ItemCont.getInstance().get(barcode);
        return BundleCont.getInstance().get(barcode);
    }
}
