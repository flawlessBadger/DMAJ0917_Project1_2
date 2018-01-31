package guilayer.inventoryPanels;

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

public class createLoanPanel extends JPanel {
	private JLabel lblBarErr;
	
	private JLabel lblBarcode;
	private JTextField txtBarcode;
	private JSeparator barcodeSeparator;
	private JButton btnCheckBarcode;
	
	private JLabel lblName;
	private JTextField txtName;
	private JSeparator nameSeparator;
	
	private JLabel lblDescription;
	private JScrollPane descScroll;
	private JTextPane txtDesc;
	private JSeparator DescriptionSeparator;
	
	private JLabel lblSalePrice;
	private JTextField txtSalePrice;
	private JSeparator salePriceSeparator;
	
	private JLabel lblPercent;
	private JSlider percentSlider;
	
	private JLabel lblProductLocation;
	private JComboBox locationBox;
	
	private JLabel lblPeriod;
	private JTextField txtPeriod;
	private JSeparator periodSeparator;
	
	private JButton btnCancelCreating;
	private JButton btnCreateItem;
	
	private NotificationWindow notification = new NotificationWindow();
	private InventoryController invCtrl = new InventoryController();
	
	String[] selectLocation = {"Do It Yourself", "Timber"};
	
	private final static Color background = new Color(255, 235, 205);
	private final static Color activated = Color.DARK_GRAY;
	private final static Color deactivated = Color.LIGHT_GRAY;
	
	/**
	 * Create the panel.
	 */	
	
	public createLoanPanel() {
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
				resetPanel();
			}
		});
		
		createLoan.setBounds(0, 0, 800, 680);
		add(createLoan);
		createLoan.setBorder(null);
		createLoan.setBackground(background);
		createLoan.setFont(new Font("Dubai", Font.BOLD, 11));
		createLoan.setLayout(null);
		
		lblBarcode = new JLabel("LOANABLE PRODUCT BARCODE");
		lblBarcode.setForeground(activated);
		lblBarcode.setFont(new Font("Dubai", Font.BOLD, 14));
		lblBarcode.setBounds(70, 50, 200, 14);
		createLoan.add(lblBarcode);
		
		txtBarcode = new JTextField("");
		txtBarcode.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtBarcode.setSelectedTextColor(new Color(64, 64, 64));
		txtBarcode.setForeground(activated);
		txtBarcode.setColumns(10);
		txtBarcode.setCaretColor(activated);
		txtBarcode.setBorder(null);
		txtBarcode.setBackground(background);
		txtBarcode.setBounds(70, 75, 200, 30);
		txtBarcode.setEnabled(true);
		createLoan.add(txtBarcode);
		
		barcodeSeparator = new JSeparator();
		barcodeSeparator.setBackground(activated);
		barcodeSeparator.setBorder(null);
		barcodeSeparator.setForeground(activated);
		barcodeSeparator.setBounds(70, 105, 200, 3);
		createLoan.add(barcodeSeparator);
		
		btnCheckBarcode = new JButton("Check Barcode");
		btnCheckBarcode.setForeground(new Color(30, 144, 255));
		btnCheckBarcode.setBackground(activated);
		btnCheckBarcode.setBorderPainted(false);
		btnCheckBarcode.setBorder(null);
		btnCheckBarcode.setFont(new Font("Dubai", Font.BOLD, 13));
		btnCheckBarcode.setBounds(70, 120, 100, 23);
		createLoan.add(btnCheckBarcode);
		
		lblBarErr = new JLabel("");
		lblBarErr.setBounds(180, 120, 200, 23);
		lblBarErr.setFont(new Font("Dubai", Font.BOLD, 14));
		lblBarErr.setVisible(false);
		createLoan.add(lblBarErr);
		
		lblName = new JLabel("PRODUCT NAME");
		lblName.setForeground(deactivated);
		lblName.setFont(new Font("Dubai", Font.BOLD, 14));
		lblName.setBounds(70, 180, 200, 14);
		createLoan.add(lblName);
		
		nameSeparator = new JSeparator();
		nameSeparator.setForeground(deactivated);
		nameSeparator.setBorder(null);
		nameSeparator.setBackground(deactivated);
		nameSeparator.setBounds(70, 240, 200, 3);
		createLoan.add(nameSeparator);
		
		txtName = new JTextField("");
		txtName.setEnabled(false);
		txtName.setSelectedTextColor(activated);
		txtName.setForeground(activated);
		txtName.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtName.setColumns(10);
		txtName.setCaretColor(activated);
		txtName.setBorder(null);
		txtName.setBackground(background);
		txtName.setBounds(70, 210, 200, 30);
		createLoan.add(txtName);
		
		lblDescription = new JLabel("PRODUCT DESCRIPTION");
		lblDescription.setForeground(deactivated);
		lblDescription.setFont(new Font("Dubai", Font.BOLD, 14));
		lblDescription.setBounds(70, 280, 223, 14);
		createLoan.add(lblDescription);
		
		txtDesc = new JTextPane();
		txtDesc.setEnabled(false);
		txtDesc.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtDesc.setBorder(null);
		txtDesc.setBackground(background);
		descScroll = new JScrollPane(txtDesc);
		descScroll.setBorder(null);
		descScroll.setBounds(70, 305, 480, 100);
		descScroll.setBackground(background);
		descScroll.setForeground(activated);
		descScroll.setFont(new Font("Dubai", Font.PLAIN, 14));
		createLoan.add(descScroll);
		
		DescriptionSeparator = new JSeparator();
		DescriptionSeparator.setForeground(deactivated);
		DescriptionSeparator.setBorder(null);
		DescriptionSeparator.setBackground(deactivated);
		DescriptionSeparator.setBounds(70, 405, 480, 3);
		createLoan.add(DescriptionSeparator);
		
		lblSalePrice = new JLabel("PRODUCT SALE PRICE");
		lblSalePrice.setForeground(deactivated);
		lblSalePrice.setFont(new Font("Dubai", Font.BOLD, 14));
		lblSalePrice.setBounds(300, 185, 200, 14);
		createLoan.add(lblSalePrice);
		
		txtSalePrice = new JTextField("");
		txtSalePrice.setEnabled(false);
		txtSalePrice.setSelectedTextColor(activated);
		txtSalePrice.setForeground(activated);
		txtSalePrice.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtSalePrice.setColumns(10);
		txtSalePrice.setCaretColor(activated);
		txtSalePrice.setBorder(null);
		txtSalePrice.setBackground(background);
		txtSalePrice.setBounds(300, 210, 200, 30);
		createLoan.add(txtSalePrice);
		
		salePriceSeparator = new JSeparator();
		salePriceSeparator.setForeground(deactivated);
		salePriceSeparator.setBorder(null);
		salePriceSeparator.setBackground(deactivated);
		salePriceSeparator.setBounds(300, 240, 200, 3);
		createLoan.add(salePriceSeparator);
		
		btnCancelCreating = new JButton("Cancel");
		btnCancelCreating.setForeground(new Color(240, 128, 128));
		btnCancelCreating.setFont(new Font("Dubai", Font.BOLD, 13));
		btnCancelCreating.setEnabled(false);
		btnCancelCreating.setBorderPainted(false);
		btnCancelCreating.setBorder(null);
		btnCancelCreating.setBackground(activated);
		btnCancelCreating.setBounds(435, 600, 116, 23);
		createLoan.add(btnCancelCreating);
		
		btnCreateItem = new JButton("Create");
		btnCreateItem.setEnabled(false);
		btnCreateItem.setBounds(70, 600, 116, 23);
		btnCreateItem.setBorderPainted(false);
		btnCreateItem.setBorder(null);
		btnCreateItem.setFont(new Font("Dubai", Font.BOLD, 13));
		btnCreateItem.setForeground(new Color(0, 128, 0));
		btnCreateItem.setBackground(activated);
		createLoan.add(btnCreateItem);
		
		lblPercent = new JLabel("PRODUCT DISCOUNT 0%");
		lblPercent.setForeground(deactivated);
		lblPercent.setFont(new Font("Dubai", Font.BOLD, 14));
		lblPercent.setBounds(70, 420, 200, 14);
		createLoan.add(lblPercent);
		
		percentSlider = new JSlider();
		percentSlider.setEnabled(false);
		percentSlider.setBackground(background);
		percentSlider.setValue(0);
		percentSlider.setForeground(background);
		percentSlider.setBounds(70, 450, 200, 26);
		createLoan.add(percentSlider);
		
		lblProductLocation = new JLabel("PRODUCT LOCATION");
		lblProductLocation.setForeground(deactivated);
		lblProductLocation.setFont(new Font("Dubai", Font.BOLD, 14));
		lblProductLocation.setBounds(70, 490, 145, 14);
		createLoan.add(lblProductLocation);
		
		locationBox = new JComboBox(selectLocation);
		locationBox.setEnabled(false);
		locationBox.setFont(new Font("Dubai", Font.BOLD, 14));
		locationBox.setSelectedIndex(0);
		locationBox.setBounds(70, 520, 145, 23);
		createLoan.add(locationBox);
		
		lblPeriod = new JLabel("PERIOD <DAYS>");
		lblPeriod.setForeground(deactivated);
		lblPeriod.setFont(new Font("Dubai", Font.BOLD, 14));
		lblPeriod.setBounds(350, 450, 200, 14);
		createLoan.add(lblPeriod);
		
		periodSeparator = new JSeparator();
		periodSeparator.setForeground(deactivated);
		periodSeparator.setBorder(null);
		periodSeparator.setBackground(deactivated);
		periodSeparator.setBounds(350, 510, 200, 3);
		createLoan.add(periodSeparator);
		
		txtPeriod = new JTextField("");
		txtPeriod.setSelectedTextColor(activated);
		txtPeriod.setForeground(activated);
		txtPeriod.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtPeriod.setEnabled(false);
		txtPeriod.setColumns(10);
		txtPeriod.setCaretColor(activated);
		txtPeriod.setBorder(null);
		txtPeriod.setBackground(background);
		txtPeriod.setBounds(350, 480, 200, 30);
		createLoan.add(txtPeriod);
		
		percentSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lblPercent.setText("PRODUCT DISCOUNT "+percentSlider.getValue()+"%");
			}
		});
		
		//Cancel item btn aka reset menu
		btnCancelCreating.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetPanel();
			}
		});	
		
		//Check barcode button
		btnCheckBarcode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtBarcode.getText().isEmpty()) {
					notification.errorWindow("Barcode is missing!","Error");
				} 
				else if(invCtrl.isBarcodeAvailable(getBarcode())) {
					
					btnCheckBarcode.setEnabled(false);
					lblBarcode.setForeground(deactivated);
					txtBarcode.setEnabled(false);
					barcodeSeparator.setBackground(deactivated);
					barcodeSeparator.setForeground(deactivated);
					
					
					lblBarErr.setForeground(new Color(34, 139, 34));
					lblBarErr.setText("Barcode available!");
					lblBarErr.setVisible(true);
							
					lblName.setForeground(activated);
					txtName.setText("");
					txtName.setEnabled(true);
					nameSeparator.setForeground(activated);
					nameSeparator.setBackground(activated);
							
					lblDescription.setForeground(activated);
					txtDesc.setText("");
					txtDesc.setEnabled(true);
					DescriptionSeparator.setForeground(activated);
					DescriptionSeparator.setBackground(activated);
							
					lblSalePrice.setForeground(activated);
					txtSalePrice.setText("");
					txtSalePrice.setEnabled(true);
					salePriceSeparator.setForeground(activated);
					salePriceSeparator.setBackground(activated);
					
					lblPercent.setForeground(activated);
					percentSlider.setEnabled(true);
					
					lblProductLocation.setForeground(activated);
					locationBox.setEnabled(true);
					
					lblPeriod.setForeground(activated);
					txtPeriod.setText("");
					txtPeriod.setEnabled(true);
					periodSeparator.setForeground(activated);
					periodSeparator.setBackground(activated);
					
					
					btnCreateItem.setEnabled(true);
					btnCancelCreating.setEnabled(true);
					
				}else {
					notification.errorWindow(invCtrl.checkBarcode(getBarcode()),"ERROR");
				}					
			}
		});		
		
		//Create loan btn
		btnCreateItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String errors = "";
				
				if(txtName.getText().isEmpty() || txtSalePrice.getText().length() >= 0) {
					if(txtName.getText().isEmpty())
						errors += "Name is missing!\n";
					
					if(txtSalePrice.getText().isEmpty()) {
						errors += "Sale price is missing!\n";
					}else {
						try {
			                Double.valueOf(txtSalePrice.getText()); 
			            } catch (Exception e1) {
			                errors += "Sale price is not a number!\n";
			            }
					}
					
					if(txtPeriod.getText().isEmpty()) {
						errors += "Period is missing!\n";
					}else {
						try {
			                Integer.valueOf(txtPeriod.getText()); 
			            } catch (Exception e1) {
			                errors += "Period should be a number!\n";
			            }
					}
						
					if(errors.length() > 0) {
						notification.errorWindow(errors,"ERROR");
						errors = "";
					}else {
						//create item
						invCtrl.createLoan(getBarcode(),txtName.getText(),txtDesc.getText(),Double.valueOf(txtSalePrice.getText()), Double.valueOf(percentSlider.getValue()),selectedLocation(),Integer.valueOf(txtPeriod.getText()));
						//reset menu
						resetPanel();
						//product created information
						notification.informationWindow("Loanable product created successfully.", "");
						
					}
				}
			}
		});
		
		txtSalePrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char vchar = arg0.getKeyChar();
				if(!(Character.isDigit(vchar))) {
					if(vchar != '.')
						arg0.consume();
					if(vchar == '.' && txtSalePrice.getText().isEmpty()) {
						arg0.consume();
					}
					if(vchar == '.' && txtSalePrice.getText().contains(".")) {
						arg0.consume();
					}
				} 
			}
		});
		
		txtPeriod.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char vchar = arg0.getKeyChar();
				if(!(Character.isDigit(vchar))) {
					arg0.consume();
				}
			}
		});
	}
	
	
	
	private void resetPanel() {
		btnCheckBarcode.setEnabled(true);
		lblBarcode.setForeground(activated);
		txtBarcode.setText("");
		txtBarcode.setEnabled(true);
		barcodeSeparator.setBackground(activated);
		barcodeSeparator.setForeground(activated);
		
		lblBarErr.setText("");
		lblBarErr.setVisible(false);
				
		lblName.setForeground(deactivated);
		txtName.setText("");
		txtName.setEnabled(false);
		nameSeparator.setForeground(deactivated);
		nameSeparator.setBackground(deactivated);
				
		lblDescription.setForeground(deactivated);
		txtDesc.setText("");
		txtDesc.setEnabled(false);
		DescriptionSeparator.setForeground(deactivated);
		DescriptionSeparator.setBackground(deactivated);
				
		lblSalePrice.setForeground(deactivated);
		txtSalePrice.setText("");
		txtSalePrice.setEnabled(false);
		salePriceSeparator.setForeground(deactivated);
		salePriceSeparator.setBackground(deactivated);
		
		lblPercent.setForeground(deactivated);
		percentSlider.setValue(0);
		percentSlider.setEnabled(false);
		
		lblProductLocation.setForeground(deactivated);
		locationBox.setSelectedIndex(0);
		locationBox.setEnabled(false);
		
		lblPeriod.setForeground(deactivated);
		txtPeriod.setText("");
		txtPeriod.setEnabled(false);
		periodSeparator.setForeground(deactivated);
		periodSeparator.setBackground(deactivated);
		
		
		btnCreateItem.setEnabled(false);
		btnCancelCreating.setEnabled(false);
	}
	

	private String selectedLocation() {
		if(String.valueOf(locationBox.getSelectedItem()).contains("Timber")) {
			return "TIMBER";
		}
		
		return "DIY";
	}
	
	private String getBarcode() {
		return txtBarcode.getText().replaceAll("\\s","");
	}
}
