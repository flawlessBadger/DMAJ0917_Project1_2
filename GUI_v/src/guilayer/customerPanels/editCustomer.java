package guilayer.customerPanels;
import controllayer.CustomerController;
import controllayer.CustomerEditor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class editCustomer extends JPanel {
	
	private JLabel lblBarcode;
	private JTextField txtName;
	private JSeparator barcodeSeparator;
	
	private JLabel lblPercent;
	private JSlider percentSlider;
	
	private JButton btnCancel;
	private JButton btnSave;
	private JButton btnContinue;
	
	private NotificationWindow notification = new NotificationWindow();
	CustomerController customer = new CustomerController();

	
	private final static Color background = new Color(255, 235, 205);
	private final static Color activated = Color.DARK_GRAY;
	private final static Color deactivated = Color.LIGHT_GRAY;
	private JTextField txtAddr;
	private JTextField txtPhoneNumber;
	private JTextField txtMail;
	private JTextField txtCustomerId;
	
	private CustomerEditor oCustomer;


	
	/**
	 * Create the panel.
	 */	
	
	public editCustomer() {
		setBackground(background);
		
		
		setLayout(null);
		//------Create Item tab------\\
		JPanel createLoan = new JPanel();
		createLoan.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {

			}
		});
		
		createLoan.setBounds(0, 0, 800, 680);
		add(createLoan);
		createLoan.setBorder(null);
		createLoan.setBackground(background);
		createLoan.setFont(new Font("Dubai", Font.BOLD, 11));
		createLoan.setLayout(null);
		
		lblBarcode = new JLabel("NAME");
		lblBarcode.setEnabled(false);
		lblBarcode.setForeground(activated);
		lblBarcode.setFont(new Font("Dubai", Font.BOLD, 14));
		lblBarcode.setBounds(70, 166, 200, 14);
		createLoan.add(lblBarcode);
		
		txtName = new JTextField("");
		txtName.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtName.setSelectedTextColor(new Color(64, 64, 64));
		txtName.setForeground(activated);
		txtName.setColumns(10);
		txtName.setCaretColor(activated);
		txtName.setBorder(null);
		txtName.setBackground(background);
		txtName.setBounds(70, 191, 200, 30);
		txtName.setEnabled(false);
		createLoan.add(txtName);
		
		barcodeSeparator = new JSeparator();
		barcodeSeparator.setBackground(activated);
		barcodeSeparator.setBorder(null);
		barcodeSeparator.setForeground(activated);
		barcodeSeparator.setBounds(70, 221, 200, 3);
		createLoan.add(barcodeSeparator);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setEnabled(false);
		btnCancel.setForeground(new Color(240, 128, 128));
		btnCancel.setFont(new Font("Dubai", Font.BOLD, 13));
		btnCancel.setBorderPainted(false);
		btnCancel.setBorder(null);
		btnCancel.setBackground(activated);
		btnCancel.setBounds(435, 600, 116, 23);
		createLoan.add(btnCancel);
		
		btnSave = new JButton("Save");
		btnSave.setEnabled(false);
		btnSave.setBounds(70, 600, 116, 23);
		btnSave.setBorderPainted(false);
		btnSave.setBorder(null);
		btnSave.setFont(new Font("Dubai", Font.BOLD, 13));
		btnSave.setForeground(new Color(0, 128, 0));
		btnSave.setBackground(activated);
		createLoan.add(btnSave);
		
		btnContinue = new JButton("Continue");
		btnContinue.setForeground(new Color(0, 128, 0));
		btnContinue.setFont(new Font("Dialog", Font.BOLD, 13));
		btnContinue.setBorderPainted(false);
		btnContinue.setBorder(null);
		btnContinue.setBackground(Color.DARK_GRAY);
		btnContinue.setBounds(70, 96, 116, 23);
		createLoan.add(btnContinue);
		
		lblPercent = new JLabel("DISCOUNT 0%");
		lblPercent.setEnabled(false);
		lblPercent.setForeground(new Color(64, 64, 64));
		lblPercent.setFont(new Font("Dubai", Font.BOLD, 14));
		lblPercent.setBounds(70, 407, 200, 14);
		createLoan.add(lblPercent);
		
		percentSlider = new JSlider();
		percentSlider.setEnabled(false);
		percentSlider.setBackground(background);
		percentSlider.setValue(0);
		percentSlider.setForeground(background);
		percentSlider.setBounds(70, 437, 200, 26);
		createLoan.add(percentSlider);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setEnabled(false);
		lblAddress.setForeground(Color.DARK_GRAY);
		lblAddress.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAddress.setBounds(351, 166, 200, 14);
		createLoan.add(lblAddress);
		
		txtAddr = new JTextField("");
		txtAddr.setSelectedTextColor(Color.DARK_GRAY);
		txtAddr.setForeground(Color.DARK_GRAY);
		txtAddr.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtAddr.setEnabled(false);
		txtAddr.setColumns(10);
		txtAddr.setCaretColor(Color.DARK_GRAY);
		txtAddr.setBorder(null);
		txtAddr.setBackground(new Color(255, 235, 205));
		txtAddr.setBounds(351, 191, 200, 30);
		createLoan.add(txtAddr);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.DARK_GRAY);
		separator.setBorder(null);
		separator.setBackground(Color.DARK_GRAY);
		separator.setBounds(351, 221, 200, 3);
		createLoan.add(separator);
		
		JLabel lblTelephone = new JLabel("TELEPHONE");
		lblTelephone.setEnabled(false);
		lblTelephone.setForeground(Color.DARK_GRAY);
		lblTelephone.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTelephone.setBounds(70, 267, 200, 14);
		createLoan.add(lblTelephone);
		
		txtPhoneNumber = new JTextField("");
		txtPhoneNumber.setSelectedTextColor(Color.DARK_GRAY);
		txtPhoneNumber.setForeground(Color.DARK_GRAY);
		txtPhoneNumber.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtPhoneNumber.setEnabled(false);
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setCaretColor(Color.DARK_GRAY);
		txtPhoneNumber.setBorder(null);
		txtPhoneNumber.setBackground(new Color(255, 235, 205));
		txtPhoneNumber.setBounds(70, 292, 200, 30);
		createLoan.add(txtPhoneNumber);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.DARK_GRAY);
		separator_1.setBorder(null);
		separator_1.setBackground(Color.DARK_GRAY);
		separator_1.setBounds(70, 322, 200, 3);
		createLoan.add(separator_1);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setEnabled(false);
		lblEmail.setForeground(Color.DARK_GRAY);
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEmail.setBounds(351, 264, 200, 14);
		createLoan.add(lblEmail);
		
		txtMail = new JTextField("");
		txtMail.setSelectedTextColor(Color.DARK_GRAY);
		txtMail.setForeground(Color.DARK_GRAY);
		txtMail.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtMail.setEnabled(false);
		txtMail.setColumns(10);
		txtMail.setCaretColor(Color.DARK_GRAY);
		txtMail.setBorder(null);
		txtMail.setBackground(new Color(255, 235, 205));
		txtMail.setBounds(351, 289, 200, 30);
		createLoan.add(txtMail);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.DARK_GRAY);
		separator_2.setBorder(null);
		separator_2.setBackground(Color.DARK_GRAY);
		separator_2.setBounds(351, 319, 200, 3);
		createLoan.add(separator_2);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(Color.DARK_GRAY);
		lblId.setFont(new Font("Dialog", Font.BOLD, 14));
		lblId.setBounds(70, 11, 200, 14);
		createLoan.add(lblId);
		
		txtCustomerId = new JTextField("");
		txtCustomerId.setSelectedTextColor(Color.DARK_GRAY);
		txtCustomerId.setForeground(Color.DARK_GRAY);
		txtCustomerId.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtCustomerId.setEnabled(true);
		txtCustomerId.setColumns(10);
		txtCustomerId.setCaretColor(Color.DARK_GRAY);
		txtCustomerId.setBorder(null);
		txtCustomerId.setBackground(new Color(255, 235, 205));
		txtCustomerId.setBounds(70, 36, 200, 30);
		createLoan.add(txtCustomerId);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.DARK_GRAY);
		separator_3.setBorder(null);
		separator_3.setBackground(Color.DARK_GRAY);
		separator_3.setBounds(70, 66, 200, 3);
		createLoan.add(separator_3);
		
		percentSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lblPercent.setText("PRODUCT DISCOUNT "+percentSlider.getValue()+"%");
			}
		});
		
		//Cancel customer editing
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetForm();
			}
		});
		
		//Continue button
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int customerID;
				//Prevent user to enter illegal chars
				try {
					customerID = Integer.parseInt(txtCustomerId.getText());
				}
				catch(RuntimeException e1) {
					customerID = 0;
					txtCustomerId.setText(Integer.toString(customerID));
				}


				// Check if customer exists, if yes unlock the form and allow editing
				if(!customer.isIDTaken( customerID )){
					oCustomer = new CustomerEditor(customerID);
					
					//Fill the form
					txtName.setText(oCustomer.getName());
					txtAddr.setText(oCustomer.getAddress());
					txtMail.setText(oCustomer.getMail());
					txtPhoneNumber.setText(oCustomer.getPhoneNumber());
					percentSlider.setValue((int)oCustomer.getDiscount()); 
					
					//Enable form elements
					txtName.setEnabled(true);
					txtAddr.setEnabled(true);
					txtMail.setEnabled(true);
					txtPhoneNumber.setEnabled(true);
					percentSlider.setEnabled(true);
					btnSave.setEnabled(true);
					btnCancel.setEnabled(true);
					
					
					//lock id field
					txtCustomerId.setEnabled(false);
					btnContinue.setEnabled(false);
		        }else{
		        	//TODO pop up window
		        	System.out.println("Customer not found");
		        }
			}
		});
		
		//Save current edited data
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				oCustomer.setName(txtName.getText());
				oCustomer.setAddress(txtAddr.getText());
				oCustomer.setDiscount(percentSlider.getValue());
				oCustomer.setEmail(txtMail.getText());
				oCustomer.setPhoneNumber(txtPhoneNumber.getText());
				
				System.out.println("Customer saved!");
				resetForm();
			}
		});
	}

	private void resetForm() {
		//Clear the form
		txtCustomerId.setText("");
		txtName.setText("");
		txtAddr.setText("");
		txtMail.setText("");
		txtPhoneNumber.setText("");
		percentSlider.setValue(0);
		
		//Change back to default state
		txtCustomerId.setEnabled(true);
		txtName.setEnabled(false);
		txtAddr.setEnabled(false);
		txtMail.setEnabled(false);
		txtPhoneNumber.setEnabled(false);
		percentSlider.setEnabled(false);
		btnSave.setEnabled(false);
		btnCancel.setEnabled(false);
		btnContinue.setEnabled(true);
		
		//Clear customer object
		oCustomer = null;
	}
}
