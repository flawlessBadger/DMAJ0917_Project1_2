package modellayer.containers;

import modellayer.Customer;

import java.util.HashMap;

public class CustomerCont<K, V> extends HashMap<K, V> {
    private static CustomerCont<Integer, Customer> instance = new CustomerCont();
    private int autoIncrement = 0;

    public static CustomerCont<Integer, Customer> getInstance() {
        return instance;
    }

    private CustomerCont() {
        super();
    }


    public int getID() {
        return autoIncrement++;
    }
//    public Boolean put(Item item){
//
//        hashMap.put(item.getBarcode(),item);
//    }
}
