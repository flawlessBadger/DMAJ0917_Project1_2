package controllayer;

import modellayer.Employee;
import modellayer.containers.EmployeeCont;

import java.util.Map;

public class EmployeeController {
    private EmployeeCont<String, Employee> employeeCont = EmployeeCont.getInstance();

    public String toStringAll() {
        StringBuilder s = new StringBuilder();
        for (Map.Entry<String, Employee> entry : employeeCont.entrySet()) {
            s.append("\n###################################");
            s.append("\nLogin:        " + entry.getKey());
            s.append("\n" + entry.getValue());

        }
        s.append("\n###################################");
        return s.toString();
    }

    public void createEmployee(String login, String name, String address, int accessLevel, String password) {
        employeeCont.put(login, new Employee(name, address, accessLevel, password));
    }

    public boolean isLoginTaken(String login) {
        return !employeeCont.containsKey(login);
    }
}
