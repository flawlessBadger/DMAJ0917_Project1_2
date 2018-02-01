package guilayer.customerPanels;
import controllayer.CustomerController;

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
import javax.swing.event.ChangeEvent;
import javax.swing.JComboBox;


public class createCustomer extends JPanel {
	
	private JLabel lblBarcode;
	private JTextField txtName;
	private JSeparator barcodeSeparator;
	
	private JLabel lblPercent;
	private JSlider percentSlider;
	
	private JButton btnCancelCreating;
	private JButton btnCreateCustomer;
	
	private NotificationWindow notification = new NotificationWindow();
	CustomerController customer = new CustomerController();
	
	String[] selectLocation = {"Do It Yourself", "Timber"};
	
	private final static Color background = new Color(255, 235, 205);
	private final static Color activated = Color.DARK_GRAY;
	private final static Color deactivated = Color.LIGHT_GRAY;
	private JTextField txtAddr;
	private JTextField txtTelephone;
	private JTextField txtMail;
	
	/**
	 * Create the panel.
	 */	
	
	public createCustomer() {
		setBackground(background);
		
		
		setLayout(null);
		//------Create Item tab------\\
		JPanel createCustomer = new JPanel();
		createCustomer.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
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
		
		lblBarcode = new JLabel("NAME");
		lblBarcode.setForeground(activated);
		lblBarcode.setFont(new Font("Dubai", Font.BOLD, 14));
		lblBarcode.setBounds(70, 50, 200, 14);
		createCustomer.add(lblBarcode);
		
		txtName = new JTextField("");
		txtName.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtName.setSelectedTextColor(new Color(64, 64, 64));
		txtName.setForeground(activated);
		txtName.setColumns(10);
		txtName.setCaretColor(activated);
		txtName.setBorder(null);
		txtName.setBackground(background);
		txtName.setBounds(70, 75, 200, 30);
		txtName.setEnabled(true);
		createCustomer.add(txtName);
		
		barcodeSeparator = new JSeparator();
		barcodeSeparator.setBackground(activated);
		barcodeSeparator.setBorder(null);
		barcodeSeparator.setForeground(activated);
		barcodeSeparator.setBounds(70, 105, 200, 3);
		createCustomer.add(barcodeSeparator);
		
		btnCancelCreating = new JButton("Cancel");
		btnCancelCreating.setForeground(new Color(240, 128, 128));
		btnCancelCreating.setFont(new Font("Dubai", Font.BOLD, 13));
		btnCancelCreating.setBorderPainted(false);
		btnCancelCreating.setBorder(null);
		btnCancelCreating.setBackground(activated);
		btnCancelCreating.setBounds(435, 600, 116, 23);
		createCustomer.add(btnCancelCreating);
		
		btnCreateCustomer = new JButton("Create");
		btnCreateCustomer.setBounds(70, 600, 116, 23);
		btnCreateCustomer.setBorderPainted(false);
		btnCreateCustomer.setBorder(null);
		btnCreateCustomer.setFont(new Font("Dubai", Font.BOLD, 13));
		btnCreateCustomer.setForeground(new Color(0, 128, 0));
		btnCreateCustomer.setBackground(activated);
		createCustomer.add(btnCreateCustomer);
		
		lblPercent = new JLabel("DISCOUNT 0%");
		lblPercent.setForeground(new Color(64, 64, 64));
		lblPercent.setFont(new Font("Dubai", Font.BOLD, 14));
		lblPercent.setBounds(70, 291, 200, 14);
		createCustomer.add(lblPercent);
		
		percentSlider = new JSlider();
		percentSlider.setBackground(background);
		percentSlider.setValue(0);
		percentSlider.setForeground(background);
		percentSlider.setBounds(70, 321, 200, 26);
		createCustomer.add(percentSlider);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setForeground(Color.DARK_GRAY);
		lblAddress.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAddress.setBounds(351, 50, 200, 14);
		createCustomer.add(lblAddress);
		
		txtAddr = new JTextField("");
		txtAddr.setSelectedTextColor(Color.DARK_GRAY);
		txtAddr.setForeground(Color.DARK_GRAY);
		txtAddr.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtAddr.setEnabled(true);
		txtAddr.setColumns(10);
		txtAddr.setCaretColor(Color.DARK_GRAY);
		txtAddr.setBorder(null);
		txtAddr.setBackground(new Color(255, 235, 205));
		txtAddr.setBounds(351, 75, 200, 30);
		createCustomer.add(txtAddr);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.DARK_GRAY);
		separator.setBorder(null);
		separator.setBackground(Color.DARK_GRAY);
		separator.setBounds(351, 105, 200, 3);
		createCustomer.add(separator);
		
		JLabel lblTelephone = new JLabel("TELEPHONE");
		lblTelephone.setForeground(Color.DARK_GRAY);
		lblTelephone.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTelephone.setBounds(70, 151, 200, 14);
		createCustomer.add(lblTelephone);
		
		txtTelephone = new JTextField("");
		txtTelephone.setSelectedTextColor(Color.DARK_GRAY);
		txtTelephone.setForeground(Color.DARK_GRAY);
		txtTelephone.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtTelephone.setEnabled(true);
		txtTelephone.setColumns(10);
		txtTelephone.setCaretColor(Color.DARK_GRAY);
		txtTelephone.setBorder(null);
		txtTelephone.setBackground(new Color(255, 235, 205));
		txtTelephone.setBounds(70, 176, 200, 30);
		createCustomer.add(txtTelephone);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.DARK_GRAY);
		separator_1.setBorder(null);
		separator_1.setBackground(Color.DARK_GRAY);
		separator_1.setBounds(70, 206, 200, 3);
		createCustomer.add(separator_1);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setForeground(Color.DARK_GRAY);
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEmail.setBounds(351, 148, 200, 14);
		createCustomer.add(lblEmail);
		
		txtMail = new JTextField("");
		txtMail.setSelectedTextColor(Color.DARK_GRAY);
		txtMail.setForeground(Color.DARK_GRAY);
		txtMail.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtMail.setEnabled(true);
		txtMail.setColumns(10);
		txtMail.setCaretColor(Color.DARK_GRAY);
		txtMail.setBorder(null);
		txtMail.setBackground(new Color(255, 235, 205));
		txtMail.setBounds(351, 173, 200, 30);
		createCustomer.add(txtMail);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.DARK_GRAY);
		separator_2.setBorder(null);
		separator_2.setBackground(Color.DARK_GRAY);
		separator_2.setBounds(351, 203, 200, 3);
		createCustomer.add(separator_2);
		
		percentSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lblPercent.setText("DISCOUNT "+percentSlider.getValue()+"%");
			}
		});
		
		//Cancel item btn aka reset menu
		btnCancelCreating.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Reset all values
				txtName.setText("");
				txtAddr.setText("");
				txtTelephone.setText("");
				txtMail.setText("");
				percentSlider.setValue(0);
			}
		});
		
		//Create customer button
		btnCreateCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Get users input and create the customer
				customer.createEmployee(txtName.getText(), txtAddr.getText(), txtTelephone.getText(), txtMail.getText() ,percentSlider.getValue());
		        System.out.println("Customer created!");
			}
		});
		
		
	}
}
