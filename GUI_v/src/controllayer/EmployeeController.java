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

	public String[][] getData() {
		String[][] s = new String[employeeCont.size()][5];
		int i = 0;
		for (Map.Entry<String, Employee> entry : employeeCont.entrySet()) {
			s[i][0] = entry.getKey();
			s[i][1] = entry.getValue().getName();
			s[i][2] = entry.getValue().getAddress();
			s[i][3] = String.valueOf(entry.getValue().getAccessLevel());
			s[i][4] = "";
			i++;
		}
		return s;
	}

	public void createEmployee(String login, String name, String address, int accessLevel, String password) {
		employeeCont.put(login, new Employee(name, address, accessLevel, password));
	}

	public boolean isLoginTaken(String login) {
		return employeeCont.containsKey(login);
	}
	
	public void removeEmployee(String login) {
		employeeCont.remove(login);
	}
}
