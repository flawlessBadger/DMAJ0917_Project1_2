package guilayer.inventoryPanels;

import javax.swing.JPanel;

import java.awt.Color;
import controllayer.InventoryController;
import guilayer.NotificationWindow;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.Font;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class createBundlePanel extends JPanel {
	
	private InventoryController invCtrl = new InventoryController();
	private NotificationWindow notification = new NotificationWindow();
	//error label
	private JLabel lblBarErr;
	
	private JLabel lblBarcode;
	private JTextField txtBarcode;
	private JSeparator barcodeSeparator;
	private JButton btnBarcode;
	
	private JLabel lblName;
	private JTextField txtName;
	private JSeparator nameSeparator;
	
	private JLabel lblDescription;
	private JTextPane txtDescription;
	private JScrollPane descScroll; 
	private JSeparator descriptionSeparator;
	
	private JLabel lblSalePrice;
	private JTextField txtSalePrice;
	private JSeparator salePriceSeparator;
	
	private JLabel lblSearchBarcode;
	private JTextField txtSearchBarcode;
	private JSeparator searchBarcodeSeparator;
	private JButton btnAdd;
	private JButton btnDel;
	
	private JScrollPane bndlScroll;
	private JTable bndlTable;
	
	private JButton btnCancel;
	private JButton btnCreate;
	
	private Object[][] data = new Object[][]{};
	private String[] columnNames = new String[]{"Product Barcode","Product Name","Quantity"};
	
	private final static Color background = new Color(255, 235, 205);
	private final static Color activated = Color.DARK_GRAY;
	private final static Color deactivated = Color.LIGHT_GRAY;
	
	//instance table model
	DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
	    @Override
	    public boolean isCellEditable(int row, int column) {	
	    	if(column == 2)
	    		return true;
	    	else
	    		return false;
	    }
	};
	/**
	 * Create the panel.
	 */
	
	
	
	public createBundlePanel() {
		setBackground(background);
		setLayout(null);
		
		JPanel createBundle = new JPanel();
		createBundle.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
				resetPanel();
			}
		});
		createBundle.setBackground(background);
		createBundle.setBounds(0, 0, 800, 657);
		add(createBundle);
		createBundle.setLayout(null);
		
		lblBarcode = new JLabel("BUNDLE BARCODE");
		lblBarcode.setBounds(70, 50, 200, 14);
		createBundle.add(lblBarcode);
		lblBarcode.setForeground(activated);
		lblBarcode.setFont(new Font("Dubai", Font.BOLD, 14));
		
		txtBarcode = new JTextField();
		txtBarcode.setSelectedTextColor(activated);
		txtBarcode.setForeground(activated);
		txtBarcode.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtBarcode.setEnabled(true);
		txtBarcode.setColumns(10);
		txtBarcode.setCaretColor(activated);
		txtBarcode.setBorder(null);
		txtBarcode.setBackground(background);
		txtBarcode.setBounds(70, 75, 200, 30);
		createBundle.add(txtBarcode);
		
		barcodeSeparator = new JSeparator();
		barcodeSeparator.setForeground(activated);
		barcodeSeparator.setBorder(null);
		barcodeSeparator.setBackground(activated);
		barcodeSeparator.setBounds(70, 105, 200, 3);
		createBundle.add(barcodeSeparator);
		
		btnBarcode = new JButton("Check Barcode");
		btnBarcode.setForeground(new Color(30, 144, 255));
		btnBarcode.setFont(new Font("Dubai", Font.BOLD, 13));
		btnBarcode.setBorderPainted(false);
		btnBarcode.setBorder(null);
		btnBarcode.setBackground(activated);
		btnBarcode.setBounds(70, 120, 100, 23);
		createBundle.add(btnBarcode);
		
		lblName = new JLabel("BUNDLE NAME");
		lblName.setForeground(deactivated);
		lblName.setFont(new Font("Dubai", Font.BOLD, 14));
		lblName.setBounds(70, 180, 200, 14);
		createBundle.add(lblName);
		
		txtName = new JTextField();
		txtName.setSelectedTextColor(activated);
		txtName.setForeground(activated);
		txtName.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtName.setEnabled(false);
		txtName.setColumns(10);
		txtName.setCaretColor(activated);
		txtName.setBorder(null);
		txtName.setBackground(background);
		txtName.setBounds(70, 210, 200, 30);
		createBundle.add(txtName);
		
		nameSeparator = new JSeparator();
		nameSeparator.setForeground(deactivated);
		nameSeparator.setBorder(null);
		nameSeparator.setBackground(deactivated);
		nameSeparator.setBounds(70, 240, 200, 3);
		createBundle.add(nameSeparator);
		
		lblDescription = new JLabel("BUNDLE DESCRIPTION");
		lblDescription.setForeground(deactivated);
		lblDescription.setFont(new Font("Dubai", Font.BOLD, 14));
		lblDescription.setBounds(70, 280, 200, 14);
		createBundle.add(lblDescription);
		
		txtDescription = new JTextPane();
		txtDescription.setEnabled(false);
		txtDescription.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtDescription.setBorder(null);
		txtDescription.setBackground(background);
		descScroll = new JScrollPane(txtDescription);
		descScroll.setBorder(null);
		descScroll.setBounds(70, 305, 480, 100);
		descScroll.setBackground(background);
		descScroll.setForeground(activated);
		descScroll.setFont(new Font("Dubai", Font.PLAIN, 14));
		createBundle.add(descScroll);
		
		descriptionSeparator = new JSeparator();
		descriptionSeparator.setForeground(deactivated);
		descriptionSeparator.setBorder(null);
		descriptionSeparator.setBackground(deactivated);
		descriptionSeparator.setBounds(70, 405, 480, 3);
		createBundle.add(descriptionSeparator);
		
		lblSalePrice = new JLabel("BUNDLE SALE PRICE");
		lblSalePrice.setForeground(deactivated);
		lblSalePrice.setFont(new Font("Dubai", Font.BOLD, 14));
		lblSalePrice.setBounds(300, 180, 200, 14);
		createBundle.add(lblSalePrice);
		
		txtSalePrice = new JTextField();
		txtSalePrice.setEnabled(false);
		txtSalePrice.setSelectedTextColor(activated);
		txtSalePrice.setForeground(activated);
		txtSalePrice.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtSalePrice.setColumns(10);
		txtSalePrice.setCaretColor(activated);
		txtSalePrice.setBorder(null);
		txtSalePrice.setBackground(background);
		txtSalePrice.setBounds(300, 210, 200, 30);
		createBundle.add(txtSalePrice);
		
		salePriceSeparator = new JSeparator();
		salePriceSeparator.setForeground(deactivated);
		salePriceSeparator.setBorder(null);
		salePriceSeparator.setBackground(deactivated);
		salePriceSeparator.setBounds(300, 240, 200, 3);
		createBundle.add(salePriceSeparator);
		
		lblSearchBarcode = new JLabel("SEARCH PRODUCT <BARCODE>");
		lblSearchBarcode.setForeground(deactivated);
		lblSearchBarcode.setFont(new Font("Dubai", Font.BOLD, 14));
		lblSearchBarcode.setBounds(70, 470, 200, 14);
		createBundle.add(lblSearchBarcode);
		
		txtSearchBarcode = new JTextField();
		txtSearchBarcode.setSelectedTextColor(activated);
		txtSearchBarcode.setForeground(activated);
		txtSearchBarcode.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtSearchBarcode.setEnabled(false);
		txtSearchBarcode.setColumns(10);
		txtSearchBarcode.setCaretColor(activated);
		txtSearchBarcode.setBorder(null);
		txtSearchBarcode.setBackground(background);
		txtSearchBarcode.setBounds(70, 495, 200, 30);
		createBundle.add(txtSearchBarcode);
		
		searchBarcodeSeparator = new JSeparator();
		searchBarcodeSeparator.setForeground(deactivated);
		searchBarcodeSeparator.setBorder(null);
		searchBarcodeSeparator.setBackground(deactivated);
		searchBarcodeSeparator.setBounds(70, 525, 200, 3);
		createBundle.add(searchBarcodeSeparator);
		
		btnAdd = new JButton("Add");
		btnAdd.setEnabled(false);
		btnAdd.setForeground(new Color(0, 128, 0));
		btnAdd.setFont(new Font("Dubai", Font.BOLD, 13));
		btnAdd.setBorderPainted(false);
		btnAdd.setBorder(null);
		btnAdd.setBackground(activated);
		btnAdd.setBounds(70, 540, 50, 23);
		createBundle.add(btnAdd);
		
		bndlTable = new JTable();
		bndlTable.setModel(tableModel);
		bndlTable.getTableHeader().setReorderingAllowed(false);
		
		/*
		JTextField tableCellBox = new JTextField();
		TableColumn defineColumn = bndlTable.getColumnModel().getColumn(2);
		defineColumn.setCellEditor(new DefaultCellEditor (tableCellBox));
		tableCellBox.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent arg0){
				char vchar = arg0.getKeyChar();
				if(!(Character.isDigit(vchar))){
					tableCellBox.setEditable(false);
					tableCellBox.setBackground(Color.WHITE);
					//JOptionPane.showMessageDialog(null,"String Type Entry Not Allowed");
				}else{
					tableCellBox.setEditable(true);
				}
			}
		});
		*/
		
		btnDel = new JButton("Delete");
		btnDel.setForeground(new Color(240, 128, 128));
		btnDel.setFont(new Font("Dubai", Font.BOLD, 13));
		btnDel.setEnabled(false);
		btnDel.setBorderPainted(false);
		btnDel.setBorder(null);
		btnDel.setBackground(activated);
		btnDel.setBounds(220, 540, 50, 23);
		createBundle.add(btnDel);
		bndlScroll = new JScrollPane(bndlTable);
		bndlScroll.setBounds(350, 470, 350, 150);
		createBundle.add(bndlScroll);
		
		lblBarErr = new JLabel("");
		lblBarErr.setFont(new Font("Dubai", Font.BOLD, 14));
		lblBarErr.setBounds(180, 120, 200, 23);
		createBundle.add(lblBarErr);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setForeground(new Color(240, 128, 128));
		btnCancel.setFont(new Font("Dubai", Font.BOLD, 13));
		btnCancel.setEnabled(false);
		btnCancel.setBorderPainted(false);
		btnCancel.setBorder(null);
		btnCancel.setBackground(activated);
		btnCancel.setBounds(585, 630, 116, 23);
		createBundle.add(btnCancel);
		
		btnCreate = new JButton("Create");
		btnCreate.setForeground(new Color(0, 128, 0));
		btnCreate.setFont(new Font("Dubai", Font.BOLD, 13));
		btnCreate.setEnabled(false);
		btnCreate.setBorderPainted(false);
		btnCreate.setBorder(null);
		btnCreate.setBackground(activated);
		btnCreate.setBounds(70, 630, 116, 23);
		createBundle.add(btnCreate);
		
		//Check barcode button
		btnBarcode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtBarcode.getText().isEmpty()) {
					notification.errorWindow("Barcode is missing!","Error");
				} 
				else if(invCtrl.isBarcodeAvailable(getBarcode())) {
					
					btnBarcode.setEnabled(false);
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
					txtDescription.setText("");
					txtDescription.setEnabled(true);
					descriptionSeparator.setForeground(activated);
					descriptionSeparator.setBackground(activated);
							
					lblSalePrice.setForeground(activated);
					txtSalePrice.setText("");
					txtSalePrice.setEnabled(true);
					salePriceSeparator.setForeground(activated);
					salePriceSeparator.setBackground(activated);
					
					lblSearchBarcode.setForeground(activated);
					txtSearchBarcode.setEnabled(true);
					searchBarcodeSeparator.setForeground(activated);
					searchBarcodeSeparator.setBackground(activated);
					btnAdd.setEnabled(true);
					btnDel.setEnabled(true);
					
					btnCreate.setEnabled(true);
					btnCancel.setEnabled(true);
					/*instructorText = "Well done.\n"+
									"1. Please insert a Name\n"+
									"2. a Description if needed\n"+
									"3. the Cost Price\n"+
									"4. Sale Price\n"+
									"5. and click \"Create\"\n\n"+
									"You can also \"Cancel\"\n";
					instructor.setText(instructorText);
					*/
				}else {
					notification.errorWindow(invCtrl.checkBarcode(txtBarcode.getText()),"ERROR");
				}					
			}
		});	
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean newEntry = true;
				if(!invCtrl.isBarcodeAvailable(getSearchBarcode())) {
					if(invCtrl.isValidItem(getSearchBarcode())) {
						for(int i = 0 ; i < tableModel.getRowCount(); i++) {
							if(((String)tableModel.getValueAt(i, 0)).equals(getSearchBarcode())) {
								int increaseQuantity = ((int)tableModel.getValueAt(i, 2)) + 1; 
								tableModel.setValueAt(increaseQuantity, i, 2);
								newEntry = false;
							}
						}
						if(newEntry)
							tableModel.addRow(new Object[] {getSearchBarcode(),invCtrl.findItem(getSearchBarcode()),1});
					}
				}
					
			}
		});
		
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!invCtrl.isBarcodeAvailable(getSearchBarcode())) {
					for(int i = tableModel.getRowCount() - 1; i >= 0 ; i--) {
						if(((String)tableModel.getValueAt(i, 0)).equals(getSearchBarcode())) {
							if(((int)tableModel.getValueAt(i, 2)) - 1 != 0) {
								tableModel.setValueAt(((int)tableModel.getValueAt(i, 2)) - 1, i, 2);
							}else {
								tableModel.removeRow(i);
							}						
						}
					}
				}
					
			}
		});
		
		bndlTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent eventA) {
				if(eventA.getClickCount() == 2) {
					tableModel.removeRow( ((JTable)eventA.getSource()).getSelectedRow() );
				}
			}
		});
		
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String errors = "";
				
				if(txtName.getText().isEmpty() || txtSalePrice.getText().length() >= 0) {
					if(txtName.getText().isEmpty())
						errors += "Item name missing!\n";
					else if(txtSalePrice.getText().isEmpty()) {
						errors += "Sale price missing!\n";
					}else {
						try {
			                Double.valueOf(txtSalePrice.getText()); 
			            } catch (Exception e1) {
			                errors += "Sale price is not a number!\n";
			            }
					} 
					
					if(tableModel.getRowCount() <= 0) {
						errors += "No Product's selected!";
					}
					
					if(errors.length() > 0) {
						notification.errorWindow(errors,"ERROR");
						errors = "";
					}else {
						invCtrl.createBundle(getBarcode(),txtName.getText(),txtDescription.getText(),Double.valueOf(txtSalePrice.getText()));
						
						for(int i = tableModel.getRowCount() - 1; i >= 0 ; i--) {
							invCtrl.addToBundle(getBarcode(),((String)tableModel.getValueAt(i, 0)),Integer.parseInt(""+tableModel.getValueAt(i, 2)));
						}
						resetPanel();
						notification.informationWindow("Bundle created successfully.", "");
					}
				}
				
				
					
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetPanel();
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
		btnBarcode.setEnabled(true);
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
		txtDescription.setText("");
		txtDescription.setEnabled(false);
		descriptionSeparator.setForeground(deactivated);
		descriptionSeparator.setBackground(deactivated);
				
		lblSalePrice.setForeground(deactivated);
		txtSalePrice.setText("");
		txtSalePrice.setEnabled(false);
		salePriceSeparator.setForeground(deactivated);
		salePriceSeparator.setBackground(deactivated);
		
		lblSearchBarcode.setForeground(deactivated);
		txtSearchBarcode.setText("");
		txtSearchBarcode.setEnabled(false);
		searchBarcodeSeparator.setForeground(deactivated);
		searchBarcodeSeparator.setBackground(deactivated);
		btnAdd.setEnabled(false);
		btnDel.setEnabled(false);
		
		btnCreate.setEnabled(false);
		btnCancel.setEnabled(false);
		
		for(int i = tableModel.getRowCount() - 1 ; i >= 0 ; i--) {
			tableModel.removeRow(i);
		}
		//instructor.setText("1. Insert Barcode\n"+
		//					"2. Click \"Check Barcode\"\n");
	}
	
	private String getBarcode() {
		return this.txtBarcode.getText().replaceAll("\\s","");
	}
	
	private String getSearchBarcode() {
		return this.txtSearchBarcode.getText().replaceAll("\\s","");
	}
}
