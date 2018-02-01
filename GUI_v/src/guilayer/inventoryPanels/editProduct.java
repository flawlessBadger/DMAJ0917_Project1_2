package guilayer.inventoryPanels;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import controllayer.ItemEditor;
import guilayer.NotificationWindow;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class editProduct extends JPanel {
	private ItemEditor editItem;
	private NotificationWindow notification = new NotificationWindow();
	
	private JTextField txtName;
	private JTextField txtSalePrice;
	private JTextField txtCostPrice;
	private JTextField txtMinimumStock;
	private JTextPane txtDesc;
	private JTextField txtSetStock;
	private JTable discountsTable;
	private JTextField txtQuantity;
	private JScrollPane tableScroll;
	private String errors = "";
	private ArrayList<Integer> removeDiscounts = new ArrayList<>();
	
	private final static Color background = new Color(255, 235, 205);
	private final static Color activated = Color.DARK_GRAY;
	private final static Color deactivated = Color.LIGHT_GRAY;

	private Object[][] data = new Object[][]{};
	private String[] columnNames = new String[]{"Quantity","Discount"};
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
	public editProduct(String barcode) {
		editItem = new ItemEditor (barcode);
		setBackground(background);
		setLayout(null);
		
		JLabel lblName = new JLabel("PRODUCT NAME");
		lblName.setForeground(activated);
		lblName.setFont(new Font("Dubai", Font.BOLD, 14));
		lblName.setBounds(145, 32, 200, 14);
		add(lblName);
		
		txtName = new JTextField("");
		txtName.setSelectedTextColor(activated);
		txtName.setForeground(activated);
		txtName.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtName.setColumns(10);
		txtName.setCaretColor(activated);
		txtName.setBorder(null);
		txtName.setBackground(background);
		txtName.setBounds(145, 62, 200, 30);
		add(txtName);
		
		JSeparator nameSeparator = new JSeparator();
		nameSeparator.setForeground(activated);
		nameSeparator.setBorder(null);
		nameSeparator.setBackground(activated);
		nameSeparator.setBounds(145, 92, 200, 3);
		add(nameSeparator);
		
		JLabel lblDescription = new JLabel("PRODUCT DESCRIPTION");
		lblDescription.setForeground(activated);
		lblDescription.setFont(new Font("Dubai", Font.BOLD, 14));
		lblDescription.setBounds(145, 132, 410, 14);
		add(lblDescription);
		
		txtDesc = new JTextPane();
		txtDesc.setEnabled(true);
		txtDesc.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtDesc.setBorder(null);
		txtDesc.setBackground(background);
		JScrollPane scrollPane = new JScrollPane(txtDesc);
		scrollPane.setForeground(activated);
		scrollPane.setFont(new Font("Dubai", Font.PLAIN, 14));
		scrollPane.setBorder(null);
		scrollPane.setBackground(background);
		scrollPane.setBounds(145, 157, 410, 100);
		add(scrollPane);
		
		JSeparator descriptionSeparator = new JSeparator();
		descriptionSeparator.setForeground(activated);
		descriptionSeparator.setBorder(null);
		descriptionSeparator.setBackground(activated);
		descriptionSeparator.setBounds(145, 257, 410, 3);
		add(descriptionSeparator);
		
		JLabel lblProductSalePrice = new JLabel("PRODUCT SALE PRICE");
		lblProductSalePrice.setForeground(activated);
		lblProductSalePrice.setFont(new Font("Dubai", Font.BOLD, 14));
		lblProductSalePrice.setBounds(145, 272, 200, 14);
		add(lblProductSalePrice);
		
		txtSalePrice = new JTextField("");
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
		txtSalePrice.setSelectedTextColor(activated);
		txtSalePrice.setForeground(activated);
		txtSalePrice.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtSalePrice.setColumns(10);
		txtSalePrice.setCaretColor(activated);
		txtSalePrice.setBorder(null);
		txtSalePrice.setBackground(background);
		txtSalePrice.setBounds(145, 297, 200, 30);
		add(txtSalePrice);
		
		JSeparator salePriceSeparator = new JSeparator();
		salePriceSeparator.setForeground(activated);
		salePriceSeparator.setBorder(null);
		salePriceSeparator.setBackground(activated);
		salePriceSeparator.setBounds(145, 327, 200, 3);
		add(salePriceSeparator);
		
		JLabel lblCostPrice = new JLabel("PRODUCT COST PRICE");
		lblCostPrice.setForeground(activated);
		lblCostPrice.setFont(new Font("Dubai", Font.BOLD, 14));
		lblCostPrice.setBounds(355, 272, 200, 14);
		add(lblCostPrice);
		
		txtCostPrice = new JTextField("");
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
		txtCostPrice.setSelectedTextColor(activated);
		txtCostPrice.setForeground(activated);
		txtCostPrice.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtCostPrice.setColumns(10);
		txtCostPrice.setCaretColor(activated);
		txtCostPrice.setBorder(null);
		txtCostPrice.setBackground(background);
		txtCostPrice.setBounds(355, 297, 200, 30);
		add(txtCostPrice);
		
		JSeparator costPriceSeparator = new JSeparator();
		costPriceSeparator.setForeground(activated);
		costPriceSeparator.setBorder(null);
		costPriceSeparator.setBackground(activated);
		costPriceSeparator.setBounds(355, 327, 200, 3);
		add(costPriceSeparator);
		
		JLabel lblSetMinimumStock = new JLabel("SET MINIMUM STOCK");
		lblSetMinimumStock.setForeground(activated);
		lblSetMinimumStock.setFont(new Font("Dubai", Font.BOLD, 14));
		lblSetMinimumStock.setBounds(145, 385, 200, 14);
		add(lblSetMinimumStock);
		
		txtMinimumStock = new JTextField("");
		txtMinimumStock.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char vchar = arg0.getKeyChar();
				if(!(Character.isDigit(vchar))) {
					arg0.consume();
				} 
			}
		});
		txtMinimumStock.setSelectedTextColor(activated);
		txtMinimumStock.setForeground(activated);
		txtMinimumStock.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtMinimumStock.setColumns(10);
		txtMinimumStock.setCaretColor(activated);
		txtMinimumStock.setBorder(null);
		txtMinimumStock.setBackground(background);
		txtMinimumStock.setBounds(145, 410, 200, 30);
		add(txtMinimumStock);
		
		JSeparator minimumStockSeparator = new JSeparator();
		minimumStockSeparator.setForeground(activated);
		minimumStockSeparator.setBorder(null);
		minimumStockSeparator.setBackground(activated);
		minimumStockSeparator.setBounds(145, 440, 200, 3);
		add(minimumStockSeparator);
		
		JLabel lblSetStock = new JLabel("SET STOCK");
		lblSetStock.setForeground(activated);
		lblSetStock.setFont(new Font("Dubai", Font.BOLD, 14));
		lblSetStock.setBounds(355, 385, 200, 14);
		add(lblSetStock);
		
		txtSetStock = new JTextField("");
		txtSetStock.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char vchar = arg0.getKeyChar();
				if(!(Character.isDigit(vchar))) {
					arg0.consume();
				} 
			}
		});
		txtSetStock.setSelectedTextColor(activated);
		txtSetStock.setForeground(activated);
		txtSetStock.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtSetStock.setColumns(10);
		txtSetStock.setCaretColor(activated);
		txtSetStock.setBorder(null);
		txtSetStock.setBackground(background);
		txtSetStock.setBounds(355, 410, 200, 30);
		add(txtSetStock);
		
		JSeparator setStockSeparator = new JSeparator();
		setStockSeparator.setForeground(activated);
		setStockSeparator.setBorder(null);
		setStockSeparator.setBackground(activated);
		setStockSeparator.setBounds(355, 440, 200, 3);
		add(setStockSeparator);
		
		JLabel lblQuantity = new JLabel("QUANTITY");
		lblQuantity.setForeground(activated);
		lblQuantity.setFont(new Font("Dubai", Font.BOLD, 14));
		lblQuantity.setBounds(355, 485, 200, 14);
		add(lblQuantity);
		
		txtQuantity = new JTextField("");
		txtQuantity.setSelectedTextColor(activated);
		txtQuantity.setForeground(activated);
		txtQuantity.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtQuantity.setColumns(10);
		txtQuantity.setCaretColor(activated);
		txtQuantity.setBorder(null);
		txtQuantity.setBackground(background);
		txtQuantity.setBounds(355, 510, 200, 30);
		add(txtQuantity);
		
		JSeparator quantitySeparator = new JSeparator();
		quantitySeparator.setForeground(activated);
		quantitySeparator.setBorder(null);
		quantitySeparator.setBackground(activated);
		quantitySeparator.setBounds(355, 540, 200, 3);
		add(quantitySeparator);
		
		JSlider discountSlider = new JSlider();
		discountSlider.setValue(0);
		discountSlider.setForeground(background);
		discountSlider.setBackground(background);
		discountSlider.setBounds(145, 510, 200, 26);
		add(discountSlider);
		
		JLabel lblDiscount = new JLabel("PRODUCT DISCOUNT 0%");
		lblDiscount.setForeground(activated);
		lblDiscount.setFont(new Font("Dubai", Font.BOLD, 14));
		lblDiscount.setBounds(145, 485, 200, 14);
		add(lblDiscount);
		
		discountsTable = new JTable(tableModel);
		tableScroll = new JScrollPane(discountsTable);
		tableScroll.setBounds(145, 553, 410, 102);
		add(tableScroll);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manageInvPanel.changeEditMenu("searchBarcode");
			}
		});
		btnCancel.setForeground(new Color(240, 128, 128));
		btnCancel.setFont(new Font("Dubai", Font.BOLD, 13));
		btnCancel.setBorderPainted(false);
		btnCancel.setBorder(null);
		btnCancel.setBackground(activated);
		btnCancel.setBounds(439, 666, 116, 23);
		add(btnCancel);
		
		JButton btnEdit = new JButton("Save");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
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
					
					if(!txtMinimumStock.getText().isEmpty()) {
						try {
			                Integer.valueOf(txtMinimumStock.getText()); 
			            } catch (Exception e1) {
			            	errors += "Minimum stock must be an integer!\n";
			            }
					}
					
					if(!txtSetStock.getText().isEmpty()) {
						try {
			                Integer.valueOf(txtSetStock.getText()); 
			            } catch (Exception e1) {
			            	errors += "Stock must be an integer!\n";
			            }
					}
					
					if(!txtQuantity.getText().isEmpty()) {
						try {
			                Integer.valueOf(txtQuantity.getText()); 
			            } catch (Exception e1) {
			            	errors += "Quantity must be an integer!\n";
			            }
						if(discountSlider.getValue() == 0) {
							errors += "Discount can't be zero!\n";
						}
					}
						
					if(errors.length() > 0) {
						notification.errorWindow(errors,"ERROR");
						errors = "";
					}else {
						if(!txtName.getText().equals(editItem.getName())) {
							editItem.setName(txtName.getText());
						}
						
						if(!txtDesc.getText().equals(editItem.getDescription())) {
							editItem.setDescription(txtDesc.getText());
						}
						
						if(!Double.valueOf(txtSalePrice.getText()).equals(editItem.getSalePrice())) {
							editItem.setSalePrice(Double.valueOf(txtSalePrice.getText()));
						}
						
						if(!Double.valueOf(txtCostPrice.getText()).equals(editItem.getCostPrice())) {
							editItem.setCostPrice(Double.valueOf(txtCostPrice.getText()));
						}
						
						if(!txtDesc.getText().equals(editItem.getDescription())) {
							editItem.setDescription(txtDesc.getText());
						}
						
						if(!txtMinimumStock.getText().isEmpty()) {
							editItem.setMinStock(Integer.valueOf(txtMinimumStock.getText()));
						}
						
						if(!txtSetStock.getText().isEmpty()) {
							editItem.setStock(Integer.valueOf(txtSetStock.getText()));
						}
						
						if(!txtQuantity.getText().isEmpty()) {
							editItem.setDiscount(Integer.valueOf(txtQuantity.getText()), discountSlider.getValue());
						}
						System.out.println(removeDiscounts.size() != 0);
						if(removeDiscounts.size() != 0) {
							for(int i = 0; i <= removeDiscounts.size() - 1;i++) {
								editItem.removeDiscount((Integer) removeDiscounts.get(i));
							}
						}
						
						loadItem();
						notification.informationWindow("Product has been edited","");
					}
				}
			}
		});
		btnEdit.setForeground(new Color(0, 128, 0));
		btnEdit.setFont(new Font("Dubai", Font.BOLD, 13));
		btnEdit.setBorderPainted(false);
		btnEdit.setBorder(null);
		btnEdit.setBackground(activated);
		btnEdit.setBounds(145, 666, 116, 23);
		add(btnEdit);
		
		discountSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lblDiscount.setText("PRODUCT DISCOUNT "+discountSlider.getValue()+"%");
			}
		});
		
		discountsTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent eventA) {
				try {
					if(eventA.getClickCount() == 2) {
						removeDiscounts.add(Integer.parseInt(""+tableModel.getValueAt( ((JTable)eventA.getSource()).getSelectedRow(), 0)));
						tableModel.removeRow( ((JTable)eventA.getSource()).getSelectedRow() );
					}
	            } catch (Exception e1) {
	                errors += "Something went wrong, please Cancel and try again!\n";
	            }
			}
		});
		
		//Load Item
		loadItem();
	}
	
	private void loadItem() {
		for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}
		
		txtName.setText(editItem.getName());
		txtSalePrice.setText(""+editItem.getSalePrice());
		txtCostPrice.setText(""+editItem.getCostPrice());
		txtDesc.setText(editItem.getDescription());
		
		if(!editItem.getAllKeys().isEmpty()) {
			//System.out.print(editItem.getAllKeys());
			//System.out.print(editItem.getAllValues());
			
			String[] keys = editItem.getAllKeys().split("-");
			String[] values = editItem.getAllValues().split("-");
			
			if(!(keys.length == 0)) {
				for(int i = 0; i < keys.length - 1;i++) {
					tableModel.addRow(new Object[] {keys[i+1],values[i+1]});
				}
			}
		}
	}
}
