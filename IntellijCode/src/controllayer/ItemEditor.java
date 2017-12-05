package controllayer;

import modellayer.Item;
import modellayer.Location;
import modellayer.containers.ItemCont;

public class ItemEditor {

    Item item;

    public ItemEditor(String barcode) {
        this.item = ItemCont.getInstance().get(barcode);
    }

    public void setName(String name) {
        item.setName(name);
    }

    public void setDescription(String description) {
        item.setDescription(description);
    }

    public void setSalePrice(double salePrice) {
        item.setSalePrice(salePrice);
    }

    public void setCostPrice(double costPrice) {
        item.setCostPrice(costPrice);
    }

    //TODO: location setting
    public void setMinStock(int amount) {
        item.setMinStock(Location.DIY, amount);
    }

    //TODO: location setting
    public void setStock(int amount) {
        item.setStock(Location.DIY, amount);
    }

    public void setDiscount(int amount, double discount) {
        item.setDiscount(amount, discount);
    }

    public boolean removeDiscount(int amount) {
        return item.removeDiscount(amount);
    }

}
