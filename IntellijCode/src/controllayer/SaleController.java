package controllayer;

import modellayer.Lease;
import modellayer.Sale;
import modellayer.containers.LeaseCont;
import modellayer.containers.SaleCont;

public class SaleController {
    //TODO:check if sum of items in items and bundles is not exceeding the amount in stock

    private SaleCont<Sale> saleCont = SaleCont.getInstance();
    private LeaseCont<String, Lease> leaseCont = LeaseCont.getInstance();
    private static LeaseCont<String, Lease> instance = LeaseCont.getInstance();


    public boolean isValidLease(String barcode) {
        return leaseCont.containsKey(barcode);
    }

    public int returnLease(String barcode) {
        return leaseCont.get(barcode).returnLease();
    }
}
