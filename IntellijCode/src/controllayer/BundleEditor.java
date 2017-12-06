package controllayer;

import modellayer.Bundle;
import modellayer.Location;
import modellayer.containers.BundleCont;

public class BundleEditor {

    Bundle bundle;

    public BundleEditor(String barcode) {
        this.bundle = BundleCont.getInstance().get(barcode);
    }

    public void setName(String name) {
        bundle.setName(name);
    }

    public void setDescription(String description) {
        bundle.setDescription(description);
    }

    public void setSalePrice(double salePrice) {
        bundle.setSalePrice(salePrice);
    }

    public void setDiscount(int amount, double discount) {
        bundle.setDiscount(amount, discount);
    }

    public boolean removeDiscount(int amount) {
        return bundle.removeDiscount(amount);
    }
}
