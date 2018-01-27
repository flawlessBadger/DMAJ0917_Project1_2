package guilayer.panels;

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
		createBundle.setBackground(new Color(255, 235, 205));
		createBundle.setBounds(0, 0, 780, 680);
		add(createBundle);
		createBundle.setLayout(null);
		
		lblBarcode = new JLabel("BUNDLE BARCODE");
		lblBarcode.setBounds(70, 50, 200, 14);
		createBundle.add(lblBarcode);
		lblBarcode.setForeground(Color.DARK_GRAY);
		lblBarcode.setFont(new Font("Dubai", Font.BOLD, 14));
		
		txtBarcode = new JTextField();
		txtBarcode.setSelectedTextColor(Color.DARK_GRAY);
		txtBarcode.setForeground(Color.DARK_GRAY);
		txtBarcode.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtBarcode.setEnabled(true);
		txtBarcode.setColumns(10);
		txtBarcode.setCaretColor(Color.DARK_GRAY);
		txtBarcode.setBorder(null);
		txtBarcode.setBackground(new Color(255, 235, 205));
		txtBarcode.setBounds(70, 75, 200, 30);
		createBundle.add(txtBarcode);
		
		barcodeSeparator = new JSeparator();
		barcodeSeparator.setForeground(Color.DARK_GRAY);
		barcodeSeparator.setBorder(null);
		barcodeSeparator.setBackground(Color.DARK_GRAY);
		barcodeSeparator.setBounds(70, 105, 200, 3);
		createBundle.add(barcodeSeparator);
		
		btnBarcode = new JButton("Check Barcode");
		btnBarcode.setForeground(new Color(30, 144, 255));
		btnBarcode.setFont(new Font("Dubai", Font.BOLD, 13));
		btnBarcode.setBorderPainted(false);
		btnBarcode.setBorder(null);
		btnBarcode.setBackground(Color.DARK_GRAY);
		btnBarcode.setBounds(70, 120, 100, 23);
		createBundle.add(btnBarcode);
		
		lblName = new JLabel("BUNDLE NAME");
		lblName.setForeground(Color.LIGHT_GRAY);
		lblName.setFont(new Font("Dubai", Font.BOLD, 14));
		lblName.setBounds(70, 180, 200, 14);
		createBundle.add(lblName);
		
		txtName = new JTextField();
		txtName.setSelectedTextColor(Color.DARK_GRAY);
		txtName.setForeground(Color.DARK_GRAY);
		txtName.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtName.setEnabled(false);
		txtName.setColumns(10);
		txtName.setCaretColor(Color.DARK_GRAY);
		txtName.setBorder(null);
		txtName.setBackground(new Color(255, 235, 205));
		txtName.setBounds(70, 210, 200, 30);
		createBundle.add(txtName);
		
		nameSeparator = new JSeparator();
		nameSeparator.setForeground(Color.LIGHT_GRAY);
		nameSeparator.setBorder(null);
		nameSeparator.setBackground(Color.LIGHT_GRAY);
		nameSeparator.setBounds(70, 240, 200, 3);
		createBundle.add(nameSeparator);
		
		lblDescription = new JLabel("BUNDLE DESCRIPTION");
		lblDescription.setForeground(new Color(192, 192, 192));
		lblDescription.setFont(new Font("Dubai", Font.BOLD, 14));
		lblDescription.setBounds(70, 280, 200, 14);
		createBundle.add(lblDescription);
		
		txtDescription = new JTextPane();
		txtDescription.setEnabled(false);
		txtDescription.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtDescription.setBorder(null);
		txtDescription.setBackground(new Color(255, 235, 205));
		descScroll = new JScrollPane(txtDescription);
		descScroll.setBorder(null);
		descScroll.setBounds(70, 305, 480, 100);
		descScroll.setBackground(new Color(255, 235, 205));
		descScroll.setForeground(Color.DARK_GRAY);
		descScroll.setFont(new Font("Dubai", Font.PLAIN, 14));
		createBundle.add(descScroll);
		
		descriptionSeparator = new JSeparator();
		descriptionSeparator.setForeground(new Color(192, 192, 192));
		descriptionSeparator.setBorder(null);
		descriptionSeparator.setBackground(new Color(192, 192, 192));
		descriptionSeparator.setBounds(70, 405, 480, 3);
		createBundle.add(descriptionSeparator);
		
		lblSalePrice = new JLabel("BUNDLE SALE PRICE");
		lblSalePrice.setForeground(new Color(192, 192, 192));
		lblSalePrice.setFont(new Font("Dubai", Font.BOLD, 14));
		lblSalePrice.setBounds(300, 180, 200, 14);
		createBundle.add(lblSalePrice);
		
		txtSalePrice = new JTextField();
		txtSalePrice.setEnabled(false);
		txtSalePrice.setSelectedTextColor(Color.DARK_GRAY);
		txtSalePrice.setForeground(Color.DARK_GRAY);
		txtSalePrice.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtSalePrice.setColumns(10);
		txtSalePrice.setCaretColor(Color.DARK_GRAY);
		txtSalePrice.setBorder(null);
		txtSalePrice.setBackground(new Color(255, 235, 205));
		txtSalePrice.setBounds(300, 210, 200, 30);
		createBundle.add(txtSalePrice);
		
		salePriceSeparator = new JSeparator();
		salePriceSeparator.setForeground(new Color(192, 192, 192));
		salePriceSeparator.setBorder(null);
		salePriceSeparator.setBackground(new Color(192, 192, 192));
		salePriceSeparator.setBounds(300, 240, 200, 3);
		createBundle.add(salePriceSeparator);
		
		lblSearchBarcode = new JLabel("SEARCH PRODUCT <BARCODE>");
		lblSearchBarcode.setForeground(new Color(192, 192, 192));
		lblSearchBarcode.setFont(new Font("Dubai", Font.BOLD, 14));
		lblSearchBarcode.setBounds(70, 470, 200, 14);
		createBundle.add(lblSearchBarcode);
		
		txtSearchBarcode = new JTextField();
		txtSearchBarcode.setSelectedTextColor(Color.DARK_GRAY);
		txtSearchBarcode.setForeground(Color.DARK_GRAY);
		txtSearchBarcode.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtSearchBarcode.setEnabled(false);
		txtSearchBarcode.setColumns(10);
		txtSearchBarcode.setCaretColor(Color.DARK_GRAY);
		txtSearchBarcode.setBorder(null);
		txtSearchBarcode.setBackground(new Color(255, 235, 205));
		txtSearchBarcode.setBounds(70, 495, 200, 30);
		createBundle.add(txtSearchBarcode);
		
		searchBarcodeSeparator = new JSeparator();
		searchBarcodeSeparator.setForeground(new Color(192, 192, 192));
		searchBarcodeSeparator.setBorder(null);
		searchBarcodeSeparator.setBackground(new Color(192, 192, 192));
		searchBarcodeSeparator.setBounds(70, 525, 200, 3);
		createBundle.add(searchBarcodeSeparator);
		
		btnAdd = new JButton("Add");
		btnAdd.setEnabled(false);
		btnAdd.setForeground(new Color(0, 128, 0));
		btnAdd.setFont(new Font("Dubai", Font.BOLD, 13));
		btnAdd.setBorderPainted(false);
		btnAdd.setBorder(null);
		btnAdd.setBackground(Color.DARK_GRAY);
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
		btnDel.setBackground(Color.DARK_GRAY);
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
		btnCancel.setBackground(Color.DARK_GRAY);
		btnCancel.setBounds(585, 630, 116, 23);
		createBundle.add(btnCancel);
		
		btnCreate = new JButton("Create");
		btnCreate.setForeground(new Color(0, 128, 0));
		btnCreate.setFont(new Font("Dubai", Font.BOLD, 13));
		btnCreate.setEnabled(false);
		btnCreate.setBorderPainted(false);
		btnCreate.setBorder(null);
		btnCreate.setBackground(Color.DARK_GRAY);
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
					lblBarcode.setForeground(new Color(192, 192, 192));
					txtBarcode.setEnabled(false);
					barcodeSeparator.setBackground(new Color(192, 192, 192));
					barcodeSeparator.setForeground(new Color(192, 192, 192));
					
					
					lblBarErr.setForeground(new Color(34, 139, 34));
					lblBarErr.setText("Barcode available!");
					lblBarErr.setVisible(true);
							
					lblName.setForeground(Color.DARK_GRAY);
					txtName.setText("");
					txtName.setEnabled(true);
					nameSeparator.setForeground(Color.DARK_GRAY);
					nameSeparator.setBackground(Color.DARK_GRAY);
							
					lblDescription.setForeground(Color.DARK_GRAY);
					txtDescription.setText("");
					txtDescription.setEnabled(true);
					descriptionSeparator.setForeground(Color.DARK_GRAY);
					descriptionSeparator.setBackground(Color.DARK_GRAY);
							
					lblSalePrice.setForeground(Color.DARK_GRAY);
					txtSalePrice.setText("");
					txtSalePrice.setEnabled(true);
					salePriceSeparator.setForeground(Color.DARK_GRAY);
					salePriceSeparator.setBackground(Color.DARK_GRAY);
					
					lblSearchBarcode.setForeground(Color.DARK_GRAY);
					txtSearchBarcode.setEnabled(true);
					searchBarcodeSeparator.setForeground(Color.DARK_GRAY);
					searchBarcodeSeparator.setBackground(Color.DARK_GRAY);
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
		lblBarcode.setForeground(Color.DARK_GRAY);
		txtBarcode.setText("");
		txtBarcode.setEnabled(true);
		barcodeSeparator.setBackground(Color.DARK_GRAY);
		barcodeSeparator.setForeground(Color.DARK_GRAY);
		
		lblBarErr.setText("");
		lblBarErr.setVisible(false);
				
		lblName.setForeground(new Color(192, 192, 192));
		txtName.setText("");
		txtName.setEnabled(false);
		nameSeparator.setForeground(new Color(192, 192, 192));
		nameSeparator.setBackground(new Color(192, 192, 192));
				
		lblDescription.setForeground(new Color(192, 192, 192));
		txtDescription.setText("");
		txtDescription.setEnabled(false);
		descriptionSeparator.setForeground(new Color(192, 192, 192));
		descriptionSeparator.setBackground(new Color(192, 192, 192));
				
		lblSalePrice.setForeground(new Color(192, 192, 192));
		txtSalePrice.setText("");
		txtSalePrice.setEnabled(false);
		salePriceSeparator.setForeground(new Color(192, 192, 192));
		salePriceSeparator.setBackground(new Color(192, 192, 192));
		
		lblSearchBarcode.setForeground(new Color(192, 192, 192));
		txtSearchBarcode.setText("");
		txtSearchBarcode.setEnabled(false);
		searchBarcodeSeparator.setForeground(new Color(192, 192, 192));
		searchBarcodeSeparator.setBackground(new Color(192, 192, 192));
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
