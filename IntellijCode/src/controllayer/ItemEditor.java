package controllayer;

import modellayer.Item;
import modellayer.Location;

public class ItemEditor {

    Item item;

    public ItemEditor(Item item) {
        this.item = item;
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
