package controllayer;

import modellayer.Customer;
import modellayer.containers.CustomerCont;

import java.util.Map;

public class CustomerController {

    private CustomerCont<Integer, Customer> customerCont = CustomerCont.getInstance();

    public String toStringAll() {
        StringBuilder s = new StringBuilder();
        for (Map.Entry<Integer, Customer> entry : customerCont.entrySet()) {
            s.append("\n###################################");
            s.append("\nID:        " + entry.getKey());
            s.append("\n" + entry.getValue().toString());
        }
        s.append("\n###################################");
        return s.toString();
    }

    public void createEmployee(String name, String address, String phoneNumber, String email, double discount) {
        customerCont.put(customerCont.getID(), new Customer(name, address, phoneNumber, email, discount));
    }

    public boolean isIDTaken(int id) {
        return !customerCont.containsKey(id);
    }
}
