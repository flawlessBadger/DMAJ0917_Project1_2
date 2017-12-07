import controllayer.EmployeeController;
import modellayer.Employee;
import modellayer.containers.EmployeeCont;
import tuilayer.MainMenu;

public class Main {
    public static void main(String[] args) {

        Employee em = new Employee("Cunty McCuntFace", "on the top of the world", 0, "cisco");
        Employee em2 = new Employee("Cunty McCuntFace", "on the top of the world", 5, "cisco");

        EmployeeCont.getInstance().put("cunt", em);
        EmployeeCont.getInstance().put("cunty", em2);

        System.out.println(
                new EmployeeController().toStringAll());

        new MainMenu();
    }
}
