package modellayer.containers;

import modellayer.Lease;

import java.util.HashMap;

public class LeaseCont<K, V> extends HashMap<K, V> {
    private static LeaseCont<String, Lease> instance = new LeaseCont();

    public static LeaseCont<String, Lease> getInstance() {
        return instance;
    }

    private LeaseCont() {
        super();
    }


}