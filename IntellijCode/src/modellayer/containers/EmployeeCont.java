package modellayer.containers;

import modellayer.Employee;
import modellayer.Item;

import java.util.HashMap;

public class EmployeeCont<K, V> extends HashMap<K, V> {
    private static EmployeeCont<String, Employee> instance = new EmployeeCont();
//    private HashMap<String,Item> hashMap;

    public static EmployeeCont<String, Employee> getInstance() {
        return instance;
    }

    private EmployeeCont() {
        super();
    }

//    public Boolean put(Item item){
//
//        hashMap.put(item.getBarcode(),item);
//    }
}
