package guilayer.customerPanels;
import controllayer.CustomerController;
import controllayer.CustomerEditor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import controllayer.InventoryController;
import guilayer.NotificationWindow;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ChangeEvent;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.DropMode;
import java.awt.ScrollPane;

import java.util.ArrayList;
import java.util.Vector;
public class listCustomer extends JPanel {
	
	private NotificationWindow notification = new NotificationWindow();
	CustomerController customer = new CustomerController();
	
	String[] selectLocation = {"Do It Yourself", "Timber"};
	
	private final static Color background = new Color(255, 235, 205);
	private final static Color activated = Color.DARK_GRAY;
	private final static Color deactivated = Color.LIGHT_GRAY;
	private DefaultTableModel model;
	private JTable table;
	
	/**
	 * Create the panel.
	 */	
	
	public listCustomer() {
		setBackground(background);
		
		
		setLayout(null);
		//------Create Item tab------\\
		JPanel createCustomer = new JPanel();
		createCustomer.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				refreshAll();
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		
		createCustomer.setBounds(0, 0, 800, 680);
		add(createCustomer);
		createCustomer.setBorder(null);
		createCustomer.setBackground(background);
		createCustomer.setFont(new Font("Dubai", Font.BOLD, 11));
		createCustomer.setLayout(null);
			
		
			
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshAll();
			}
		});
		
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setSize(780, 624);
		scrollPane.setLocation(10, 45);
		createCustomer.add(scrollPane);
		
		
		String[] columnNames = {"CustomerID", "Name", "Address", "Telephone", "Email", "Discount in %"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
		
		btnRefresh.setForeground(new Color(0, 128, 0));
		btnRefresh.setFont(new Font("Dialog", Font.BOLD, 13));
		btnRefresh.setBorderPainted(false);
		btnRefresh.setBorder(null);
		btnRefresh.setBackground(Color.DARK_GRAY);
		btnRefresh.setBounds(674, 11, 116, 23);
		createCustomer.add(btnRefresh);
		
		refreshAll();
	}
	
	private void refreshAll() {
		//Clear table
		model.setRowCount(0);
		
		//Fill table with all customers
		CustomerController customer = new CustomerController();
		ArrayList<Object> customerList = customer.getAllCustomers();
		for(int i = 0; i < customerList.size(); i++) {
			model.addRow((Object[])customerList.get(i));
		}
	}
}
