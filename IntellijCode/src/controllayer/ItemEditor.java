package controllayer;

import modellayer.Item;

public class ItemEditor {

    Item item;

    public ItemEditor(Item item) {
        this.item = item;
    }

    public void setName(String name){
        item.setName(name);
    }


}
