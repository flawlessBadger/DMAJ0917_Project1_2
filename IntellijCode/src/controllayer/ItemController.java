package controllayer;

import modellayer.Item;
import modellayer.containers.ItemCont;

public class ItemController {


    public boolean addItem(Item item) {
        if (!ItemCont.getInstance().containsKey(item.getBarcode())) {
            ItemCont.getInstance().put(item.getBarcode(), item);
            return true;
        }
        return false;
    }
}
