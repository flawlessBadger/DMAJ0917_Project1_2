package modellayer.containers;

import modellayer.Sale;

import java.util.ArrayList;

public class SaleCont<V> extends ArrayList<V> {
    private static SaleCont<Sale> instance = new SaleCont();
//    private HashMap<String,Item> hashMap;
    private int increment = -1;

    public static SaleCont<Sale> getInstance() {
        return instance;
    }

    private SaleCont() {
        super();
    }

    public int generateID(){
     return increment++;
    }
}
