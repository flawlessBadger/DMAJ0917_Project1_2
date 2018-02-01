import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controllayer.InventoryController;
import controllayer.ItemEditor;
import guilayer.MainWindow;
import modellayer.Customer;
import modellayer.Employee;
import modellayer.Location;
import modellayer.SaleLineItem;
import modellayer.containers.CustomerCont;
import tuilayer.MainMenu;
import modellayer.containers.*;

public class Main {
	
	//main color: #d2b476 / (210, 180, 118)
	//light color: (255, 235, 205)
	// background .DARK_GRAY
    public static void main(String[] args) {

        Employee em = new Employee("Viktor Grzonkowski", "Nibevej 12", 5, "password");
        Employee em2 = new Employee("Luis Cheung", "Tempeltown", 0, "password");
        Employee em3 = new Employee("Luis Cheung", "Tempeltown", 0, "a");

        EmployeeCont.getInstance().put("Vithoh", em);
        EmployeeCont.getInstance().put("Peng", em2);
        EmployeeCont.getInstance().put("a", em3);

//        System.out.println(
//                new EmployeeController().toStringAll());

        Customer customer = new Customer("Asd", "Asd", "Asd", "Asd", 20);
        CustomerCont.getInstance().put(CustomerCont.getInstance().getID(), customer);

        InventoryController inventoryController = new InventoryController();
        inventoryController.createItem("1", "Table", "+", 123.4, 99.9);
        inventoryController.createItem("2", "Chair", "+", 123.4, 99.9);
        inventoryController.createItem("3", "Plate", "+", 123.4, 99.9);
        inventoryController.createItem("4", "Shelf", "+", 123.4, 99.9);
        inventoryController.createItem("5", "Test Item", "+", 123.4, 99.9);

        
        ItemEditor editItem = new ItemEditor ("1");
        editItem.setDiscount(5, 15);
        editItem.setDiscount(66, 10);
        
        SaleLineItem saleLineItem = inventoryController.getSaleLineItem("1");
        saleLineItem.addStock(1, Location.DIY);


        //new MainMenu();
        new MainWindow().start();
    }
}
