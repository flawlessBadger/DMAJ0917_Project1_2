package controllayer;

import modellayer.Employee;
import modellayer.containers.EmployeeCont;

public class EmployeeEditor {

    Employee employee;
    String login;

    public EmployeeEditor(String login) {
        this.login = login;
        this.employee = EmployeeCont.getInstance().get(login);
    }

    public void setName(String name) {
        employee.setName(name);
    }

    public void setAddress(String address) {
        employee.setAddress(address);
    }

    public void setPassword(String password) {
        employee.setPassword(password);
    }

    public void setAccessLevel(int accessLevel) {
        employee.setAccessLevel(accessLevel);
    }

    public String toString() {
        return "Login:        " + login + "\n" + employee.toString();
    }

}
