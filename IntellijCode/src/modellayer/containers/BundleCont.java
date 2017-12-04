package modellayer.containers;

import modellayer.Bundle;
import modellayer.Item;

import java.util.HashMap;

public class BundleCont<K, V> extends HashMap<K, V> {
    private static BundleCont<String, Bundle> instance = new BundleCont();
//    private HashMap<String,Item> hashMap;

    public static BundleCont<String, Bundle> getInstance() {
        return instance;
    }

    private BundleCont() {
        super();
    }

//    public Boolean put(Item item){
//
//        hashMap.put(item.getBarcode(),item);
//    }
}
