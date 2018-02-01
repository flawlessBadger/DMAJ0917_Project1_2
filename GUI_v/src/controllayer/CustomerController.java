package controllayer;

import modellayer.Customer;
import modellayer.containers.CustomerCont;

import java.util.Map;
import java.util.ArrayList;

public class CustomerController {

    private CustomerCont<Integer, Customer> customerCont = CustomerCont.getInstance();

    public String toStringAll() {
        StringBuilder s = new StringBuilder();
        for (Map.Entry<Integer, Customer> entry : customerCont.entrySet()) {
            s.append("\n###################################");
            s.append("\nID:        ").append(entry.getKey());
            s.append("\n").append(entry.getValue().toString());
        }
        s.append("\n###################################");
        return s.toString();
    }
    
    public ArrayList<Object> getAllCustomers() {
    	ArrayList<Object> customerList = new ArrayList<Object>();
    	for (Map.Entry<Integer, Customer> entry : customerCont.entrySet()) {
            customerList.add(new Object[]{entry.getKey(), 
            		entry.getValue().getName(), 
            		entry.getValue().getAddress(), 
            		entry.getValue().getPhoneNumber(), 
            		entry.getValue().getMail(), 
            		entry.getValue().getDiscount()});
            
        }
		return customerList;
    }

    public void createEmployee(String name, String address, String phoneNumber, String email, double discount) {
        customerCont.put(customerCont.getID(), new Customer(name, address, phoneNumber, email, discount));
    }
    public boolean hasCustomer() {
        return !customerCont.isEmpty();
    }

    public boolean isIDTaken(int id) {
        return !customerCont.containsKey(id);
    }
}
