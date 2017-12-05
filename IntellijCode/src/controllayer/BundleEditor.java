package controllayer;

import modellayer.Bundle;

public class BundleEditor {

    Bundle bundle;

    public BundleEditor(Bundle bundle) {
        this.bundle = bundle;
    }


    public void setName(String name) {
        bundle.setName(name);
    }
}
