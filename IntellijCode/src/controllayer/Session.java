package controllayer;

import modellayer.Employee;
import modellayer.Location;
import modellayer.containers.EmployeeCont;

public class Session {
    private static Session ourInstance = new Session();
    private Location location;
    private Employee employee;

    public static Session getInstance() {
        return ourInstance;
    }

    private Session() {

    }

    public boolean login(String login, String password, String location) throws Exception {
        Employee lookup = EmployeeCont.getInstance().get(login);
        if (lookup.checkPassword(password)) {
            this.location = Location.valueOf(location.toUpperCase());
            employee = lookup;
            return true;
        }
        return false;

    }

    public Employee getEmployee() {
        return employee;
    }

    public boolean isAllowed(int necessaryAccessLevel) {
        return employee.getAccessLevel() >= necessaryAccessLevel;
    }

}
