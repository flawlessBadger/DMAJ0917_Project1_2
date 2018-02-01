package controllayer;

import modellayer.Customer;
import modellayer.containers.CustomerCont;

public class CustomerEditor {
    private Customer customer;
    private int id;

    public CustomerEditor(int id) {
        this.id = id;
        this.customer = CustomerCont.getInstance().get(id);
    }

    public void setName(String name) {
        customer.setName(name);
    }

    public void setAddress(String address) {
        customer.setAddress(address);
    }


    public void setPhoneNumber(String phoneNumber) {
        customer.setPhoneNumber(phoneNumber);
    }

    public void setEmail(String email) {
        customer.setEmail(email);
    }

    public void setDiscount(double discount) {
        customer.setDiscount( discount);
    }
    
    public String getName() {
    	return customer.getName();
    }
    
    public String getAddress() {
    	return customer.getAddress();
    }
    
    public String getMail() {
    	return customer.getMail();
    }
    
    public String getPhoneNumber() {
    	return customer.getPhoneNumber();
    }
    
    public double getDiscount() {
    	return customer.getDiscount();
    }

    public String toString() {
        return "ID:           " + id + "\n" + customer.toString();
    }


}
