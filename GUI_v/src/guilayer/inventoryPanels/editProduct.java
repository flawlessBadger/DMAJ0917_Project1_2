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

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class editProduct extends JPanel {
	private ItemEditor editItem;
	
	private JTextField txtName;
	private JTextField txtSalePrice;
	private JTextField txtCostPrice;
	private JTextField txtMinimumStock;
	private JTextPane txtDesc;
	private JTextField txtSetStock;
	private JTable discountsTable;
	private JTextField txtQuantity;
	private JScrollPane tableScroll;
	
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
		lblName.setBounds(10, 10, 200, 14);
		add(lblName);
		
		txtName = new JTextField("");
		txtName.setSelectedTextColor(activated);
		txtName.setForeground(activated);
		txtName.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtName.setColumns(10);
		txtName.setCaretColor(activated);
		txtName.setBorder(null);
		txtName.setBackground(background);
		txtName.setBounds(10, 40, 200, 30);
		add(txtName);
		
		JSeparator nameSeparator = new JSeparator();
		nameSeparator.setForeground(activated);
		nameSeparator.setBorder(null);
		nameSeparator.setBackground(activated);
		nameSeparator.setBounds(10, 70, 200, 3);
		add(nameSeparator);
		
		JLabel lblDescription = new JLabel("PRODUCT DESCRIPTION");
		lblDescription.setForeground(activated);
		lblDescription.setFont(new Font("Dubai", Font.BOLD, 14));
		lblDescription.setBounds(10, 110, 410, 14);
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
		scrollPane.setBounds(10, 135, 410, 100);
		add(scrollPane);
		
		JSeparator descriptionSeparator = new JSeparator();
		descriptionSeparator.setForeground(activated);
		descriptionSeparator.setBorder(null);
		descriptionSeparator.setBackground(activated);
		descriptionSeparator.setBounds(10, 235, 410, 3);
		add(descriptionSeparator);
		
		JLabel lblProductSalePrice = new JLabel("PRODUCT SALE PRICE");
		lblProductSalePrice.setForeground(activated);
		lblProductSalePrice.setFont(new Font("Dubai", Font.BOLD, 14));
		lblProductSalePrice.setBounds(10, 250, 200, 14);
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
		txtSalePrice.setBounds(10, 275, 200, 30);
		add(txtSalePrice);
		
		JSeparator salePriceSeparator = new JSeparator();
		salePriceSeparator.setForeground(activated);
		salePriceSeparator.setBorder(null);
		salePriceSeparator.setBackground(activated);
		salePriceSeparator.setBounds(10, 305, 200, 3);
		add(salePriceSeparator);
		
		JLabel lblCostPrice = new JLabel("PRODUCT COST PRICE");
		lblCostPrice.setForeground(activated);
		lblCostPrice.setFont(new Font("Dubai", Font.BOLD, 14));
		lblCostPrice.setBounds(220, 250, 200, 14);
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
		txtCostPrice.setBounds(220, 275, 200, 30);
		add(txtCostPrice);
		
		JSeparator costPriceSeparator = new JSeparator();
		costPriceSeparator.setForeground(activated);
		costPriceSeparator.setBorder(null);
		costPriceSeparator.setBackground(activated);
		costPriceSeparator.setBounds(220, 305, 200, 3);
		add(costPriceSeparator);
		
		JLabel lblSetMinimumStock = new JLabel("SET MINIMUM STOCK");
		lblSetMinimumStock.setForeground(activated);
		lblSetMinimumStock.setFont(new Font("Dubai", Font.BOLD, 14));
		lblSetMinimumStock.setBounds(10, 363, 200, 14);
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
		txtMinimumStock.setBounds(10, 388, 200, 30);
		add(txtMinimumStock);
		
		JSeparator minimumStockSeparator = new JSeparator();
		minimumStockSeparator.setForeground(activated);
		minimumStockSeparator.setBorder(null);
		minimumStockSeparator.setBackground(activated);
		minimumStockSeparator.setBounds(10, 418, 200, 3);
		add(minimumStockSeparator);
		
		JLabel lblSetStock = new JLabel("SET STOCK");
		lblSetStock.setForeground(activated);
		lblSetStock.setFont(new Font("Dubai", Font.BOLD, 14));
		lblSetStock.setBounds(220, 363, 200, 14);
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
		txtSetStock.setBounds(220, 388, 200, 30);
		add(txtSetStock);
		
		JSeparator setStockSeparator = new JSeparator();
		setStockSeparator.setForeground(activated);
		setStockSeparator.setBorder(null);
		setStockSeparator.setBackground(activated);
		setStockSeparator.setBounds(220, 418, 200, 3);
		add(setStockSeparator);
		
		JLabel lblQuantity = new JLabel("QUANTITY");
		lblQuantity.setForeground(activated);
		lblQuantity.setFont(new Font("Dubai", Font.BOLD, 14));
		lblQuantity.setBounds(220, 463, 200, 14);
		add(lblQuantity);
		
		txtQuantity = new JTextField("");
		txtQuantity.setSelectedTextColor(activated);
		txtQuantity.setForeground(activated);
		txtQuantity.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtQuantity.setColumns(10);
		txtQuantity.setCaretColor(activated);
		txtQuantity.setBorder(null);
		txtQuantity.setBackground(background);
		txtQuantity.setBounds(220, 488, 200, 30);
		add(txtQuantity);
		
		JSeparator quantitySeparator = new JSeparator();
		quantitySeparator.setForeground(activated);
		quantitySeparator.setBorder(null);
		quantitySeparator.setBackground(activated);
		quantitySeparator.setBounds(220, 518, 200, 3);
		add(quantitySeparator);
		
		JSlider discountSlider = new JSlider();
		discountSlider.setValue(0);
		discountSlider.setForeground(background);
		discountSlider.setBackground(background);
		discountSlider.setBounds(10, 488, 200, 26);
		add(discountSlider);
		
		JLabel lblDiscount = new JLabel("PRODUCT DISCOUNT 0%");
		lblDiscount.setForeground(activated);
		lblDiscount.setFont(new Font("Dubai", Font.BOLD, 14));
		lblDiscount.setBounds(10, 463, 200, 14);
		add(lblDiscount);
		
		discountsTable = new JTable(tableModel);
		tableScroll = new JScrollPane(discountsTable);
		tableScroll.setBounds(10, 532, 410, 77);
		add(tableScroll);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(new Color(240, 128, 128));
		btnCancel.setFont(new Font("Dubai", Font.BOLD, 13));
		btnCancel.setBorderPainted(false);
		btnCancel.setBorder(null);
		btnCancel.setBackground(activated);
		btnCancel.setBounds(304, 620, 116, 23);
		add(btnCancel);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setForeground(new Color(0, 128, 0));
		btnEdit.setFont(new Font("Dubai", Font.BOLD, 13));
		btnEdit.setBorderPainted(false);
		btnEdit.setBorder(null);
		btnEdit.setBackground(activated);
		btnEdit.setBounds(10, 620, 116, 23);
		add(btnEdit);
		
		discountSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lblDiscount.setText("PRODUCT DISCOUNT "+discountSlider.getValue()+"%");
			}
		});
	}
}
