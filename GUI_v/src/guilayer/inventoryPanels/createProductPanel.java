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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import controllayer.InventoryController;
import guilayer.NotificationWindow;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class createProductPanel extends JPanel {
	
	private JTextArea instructor;
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
	
	private JLabel lblCostPrice;
	private JTextField txtCostPrice;
	private JSeparator costSeparator;
	
	private JButton btnCancelCreating;
	private JButton btnCreateItem;
	
	private NotificationWindow notification = new NotificationWindow();
	private InventoryController invCtrl = new InventoryController();
	
	private final static Color background = new Color(255, 235, 205);
	private final static Color activated = Color.DARK_GRAY;
	private final static Color deactivated = Color.LIGHT_GRAY;
	/**
	 * Create the panel.
	 */	
	
	public createProductPanel() {
		
		
		setLayout(null);
		//------Create Item tab------\\
		JPanel createItem = new JPanel();
		createItem.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
				resetPanel();
			}
		});
		
		createItem.setBounds(0, 0, 800, 771);
		add(createItem);
		createItem.setBorder(null);
		createItem.setBackground(background);
		createItem.setFont(new Font("Dubai", Font.BOLD, 11));
		createItem.setLayout(null);
		
		instructor = new JTextArea("1. Insert Barcode\n"+
									"2. Click \"Check Barcode\"\n");
		instructor.setBackground(background);
		instructor.setForeground(new Color(0, 128, 0));
		instructor.setFont(new Font("Dubai Medium", Font.PLAIN, 14));
		instructor.setBounds(380, 50, 350, 220);
		instructor.setWrapStyleWord(true);
		instructor.setLineWrap(true);
		instructor.setEditable(false);
		createItem.add(instructor);
		
		lblBarcode = new JLabel("PRODUCT BARCODE");
		lblBarcode.setForeground(activated);
		lblBarcode.setFont(new Font("Dubai", Font.BOLD, 14));
		lblBarcode.setBounds(70, 50, 200, 14);
		createItem.add(lblBarcode);
		
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
		createItem.add(txtBarcode);
		
		barcodeSeparator = new JSeparator();
		barcodeSeparator.setBackground(activated);
		barcodeSeparator.setBorder(null);
		barcodeSeparator.setForeground(activated);
		barcodeSeparator.setBounds(70, 105, 200, 3);
		createItem.add(barcodeSeparator);
		
		btnCheckBarcode = new JButton("Check Barcode");
		btnCheckBarcode.setForeground(new Color(30, 144, 255));
		btnCheckBarcode.setBackground(activated);
		btnCheckBarcode.setBorderPainted(false);
		btnCheckBarcode.setBorder(null);
		btnCheckBarcode.setFont(new Font("Dubai", Font.BOLD, 13));
		btnCheckBarcode.setBounds(70, 120, 100, 23);
		createItem.add(btnCheckBarcode);
		
		lblBarErr = new JLabel("");
		lblBarErr.setBounds(180, 120, 200, 23);
		lblBarErr.setFont(new Font("Dubai", Font.BOLD, 14));
		lblBarErr.setVisible(false);
		createItem.add(lblBarErr);
		
		lblName = new JLabel("PRODUCT NAME");
		lblName.setForeground(deactivated);
		lblName.setFont(new Font("Dubai", Font.BOLD, 14));
		lblName.setBounds(70, 180, 200, 14);
		createItem.add(lblName);
		
		nameSeparator = new JSeparator();
		nameSeparator.setForeground(deactivated);
		nameSeparator.setBorder(null);
		nameSeparator.setBackground(deactivated);
		nameSeparator.setBounds(70, 240, 200, 3);
		createItem.add(nameSeparator);
		
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
		createItem.add(txtName);
		
		lblDescription = new JLabel("PRODUCT DESCRIPTION");
		lblDescription.setForeground(deactivated);
		lblDescription.setFont(new Font("Dubai", Font.BOLD, 14));
		lblDescription.setBounds(70, 280, 200, 14);
		createItem.add(lblDescription);
		
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
		createItem.add(descScroll);
		
		DescriptionSeparator = new JSeparator();
		DescriptionSeparator.setForeground(deactivated);
		DescriptionSeparator.setBorder(null);
		DescriptionSeparator.setBackground(deactivated);
		DescriptionSeparator.setBounds(70, 405, 480, 3);
		createItem.add(DescriptionSeparator);
		
		lblSalePrice = new JLabel("PRODUCT SALE PRICE");
		lblSalePrice.setForeground(deactivated);
		lblSalePrice.setFont(new Font("Dubai", Font.BOLD, 14));
		lblSalePrice.setBounds(70, 420, 200, 14);
		createItem.add(lblSalePrice);
		
		txtSalePrice = new JTextField("");
		txtSalePrice.setEnabled(false);
		txtSalePrice.setSelectedTextColor(activated);
		txtSalePrice.setForeground(activated);
		txtSalePrice.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtSalePrice.setColumns(10);
		txtSalePrice.setCaretColor(activated);
		txtSalePrice.setBorder(null);
		txtSalePrice.setBackground(background);
		txtSalePrice.setBounds(70, 445, 200, 30);
		createItem.add(txtSalePrice);
		
		salePriceSeparator = new JSeparator();
		salePriceSeparator.setForeground(deactivated);
		salePriceSeparator.setBorder(null);
		salePriceSeparator.setBackground(deactivated);
		salePriceSeparator.setBounds(70, 475, 200, 3);
		createItem.add(salePriceSeparator);
		
		lblCostPrice = new JLabel("PRODUCT COST PRICE");
		lblCostPrice.setForeground(deactivated);
		lblCostPrice.setFont(new Font("Dubai", Font.BOLD, 14));
		lblCostPrice.setBounds(350, 420, 200, 14);
		createItem.add(lblCostPrice);
		
		txtCostPrice = new JTextField("");
		txtCostPrice.setEnabled(false);
		txtCostPrice.setSelectedTextColor(activated);
		txtCostPrice.setForeground(activated);
		txtCostPrice.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtCostPrice.setColumns(10);
		txtCostPrice.setCaretColor(activated);
		txtCostPrice.setBorder(null);
		txtCostPrice.setBackground(background);
		txtCostPrice.setBounds(350, 445, 200, 30);
		createItem.add(txtCostPrice);
		
		costSeparator = new JSeparator();
		costSeparator.setForeground(deactivated);
		costSeparator.setBorder(null);
		costSeparator.setBackground(deactivated);
		costSeparator.setBounds(350, 475, 200, 3);
		createItem.add(costSeparator);
		
		btnCancelCreating = new JButton("Cancel");
		btnCancelCreating.setForeground(new Color(240, 128, 128));
		btnCancelCreating.setFont(new Font("Dubai", Font.BOLD, 13));
		btnCancelCreating.setEnabled(false);
		btnCancelCreating.setBorderPainted(false);
		btnCancelCreating.setBorder(null);
		btnCancelCreating.setBackground(activated);
		btnCancelCreating.setBounds(435, 560, 116, 23);
		createItem.add(btnCancelCreating);
		
		btnCreateItem = new JButton("Create");
		btnCreateItem.setEnabled(false);
		btnCreateItem.setBounds(70, 560, 116, 23);
		btnCreateItem.setBorderPainted(false);
		btnCreateItem.setBorder(null);
		btnCreateItem.setFont(new Font("Dubai", Font.BOLD, 13));
		btnCreateItem.setForeground(new Color(0, 128, 0));
		btnCreateItem.setBackground(activated);
		createItem.add(btnCreateItem);
		
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
					
					lblCostPrice.setForeground(activated);
					txtCostPrice.setText("");
					txtCostPrice.setEnabled(true);
					costSeparator.setForeground(activated);
					costSeparator.setBackground(activated);
					
					btnCreateItem.setEnabled(true);
					btnCancelCreating.setEnabled(true);
					
					instructor.setText("Well done.\n"+
										"1. Please insert a Name\n"+
										"2. a Description if needed\n"+
										"3. the Cost Price\n"+
										"4. Sale Price\n"+
										"5. and click \"Create\"\n\n"+
										"You can also \"Cancel\"\n");
				}else {
					notification.errorWindow(invCtrl.checkBarcode(getBarcode()),"ERROR");
				}					
			}
		});		
		
		//Create item btn
		btnCreateItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String errors = "";
				
				if(txtName.getText().isEmpty() || txtSalePrice.getText().length() >= 0 || txtCostPrice.getText().length() >= 0) {
					if(txtName.getText().isEmpty())
						errors += "Item name missing!\n";
					
					if(txtSalePrice.getText().isEmpty()) {
						errors += "Sale price missing!\n";
					}else {
						try {
			                Double.valueOf(txtSalePrice.getText()); 
			            } catch (Exception e1) {
			                errors += "Sale price is not a number!\n";
			            }
					}
						
					if(txtCostPrice.getText().isEmpty()) {
						errors += "Cost price missing!\n";
					}else {
						try {
			                Double.valueOf(txtCostPrice.getText()); 
			            } catch (Exception e1) {
			            	errors += "Cost price is not a number!\n";
			            }
					}
						
					if(errors.length() > 0) {
						notification.errorWindow(errors,"ERROR");
						errors = "";
					}else {
						//create item
						invCtrl.createItem(getBarcode(),
											txtName.getText(),
											txtDesc.getText(),
											Double.valueOf(txtSalePrice.getText().replaceAll("\\s","")),
											Double.valueOf(txtCostPrice.getText().replaceAll("\\s","")));
						//reset menu
						resetPanel();
						//product created information
						notification.informationWindow("Product created successfully.", "");
						
					}
				}
			}
		});
		txtCostPrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char vchar = arg0.getKeyChar();
				if(!(Character.isDigit(vchar))) {
					if(vchar != '.')
						arg0.consume();
					if(vchar == '.' && txtCostPrice.getText().isEmpty()) {
						arg0.consume();
					}
					if(vchar == '.' && txtCostPrice.getText().contains(".")) {
						arg0.consume();
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
		
		lblCostPrice.setForeground(deactivated);
		txtCostPrice.setText("");
		txtCostPrice.setEnabled(false);
		costSeparator.setForeground(deactivated);
		costSeparator.setBackground(deactivated);
		
		btnCreateItem.setEnabled(false);
		btnCancelCreating.setEnabled(false);
		
		instructor.setText("1. Insert Barcode\n"+
							"2. Click \"Check Barcode\"\n");
	}
	
	private String getBarcode() {
		return txtBarcode.getText().replaceAll("\\s","");
	}
}
