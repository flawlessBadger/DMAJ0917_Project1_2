package modellayer.containers;

import modellayer.Sale;
import java.util.ArrayList;

public class SaleCont<V> extends ArrayList<V> {

    private static SaleCont<Sale> instance = new SaleCont();

    private SaleCont() {
        super();
    }
    public static SaleCont<Sale> getInstance() {
        return instance;
    }
}
