package controllayer;

import modellayer.Employee;
import modellayer.containers.EmployeeCont;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EmployeeController {
    private EmployeeCont<String, Employee> employeeCont = EmployeeCont.getInstance();

    public String toStringAll() {
        StringBuilder s = new StringBuilder();
        for (Map.Entry<String, Employee> entry : employeeCont.entrySet()) {
            s.append("\n" + entry.getValue());

        }
        return s.toString();
    }

}
