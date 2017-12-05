package modellayer.containers;

import modellayer.Bundle;
import modellayer.Item;
import modellayer.Sale;

import java.util.ArrayList;
import java.util.HashMap;

public class SaleCont< V> extends ArrayList<V> {
    private static SaleCont<Sale> instance = new SaleCont();
//    private HashMap<String,Item> hashMap;

    public static SaleCont<Sale> getInstance() {
        return instance;
    }

    private SaleCont() {
        super();
    }
}
