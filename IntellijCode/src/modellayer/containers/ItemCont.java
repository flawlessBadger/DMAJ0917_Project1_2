package modellayer.containers;

import modellayer.Item;

import java.util.HashMap;

public class ItemCont<K, V> extends HashMap<K, V> {
    private static ItemCont<String, Item> instance = new ItemCont();
//    private HashMap<String,Item> hashMap;

    public static ItemCont<String, Item> getInstance() {
        return instance;
    }

    private ItemCont() {
        super();
    }

//    public Boolean put(Item item){
//
//        hashMap.put(item.getBarcode(),item);
//    }
}
