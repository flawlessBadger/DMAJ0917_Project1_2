package guilayer.salePanels;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controllayer.CustomerController;
import controllayer.InventoryController;
import controllayer.SaleController;
import controllayer.CustomerEditor;
import guilayer.NotificationWindow;

import javax.swing.ListSelectionModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.border.CompoundBorder;

public class CreateSalePanel extends JPanel {
	
	private CustomerController customerCtrl = new CustomerController();
	private InventoryController inventoryCtrl = new InventoryController();
	private SaleController saleCtrl = new SaleController();
	private NotificationWindow notification = new NotificationWindow();
	
	private JTable tblProducts;
	private DefaultTableModel tblModel;
	private JComboBox<String> cmbbxCustomer;
	private JCheckBox chckbxCustomer;
	private JButton btnAddProduct;
	private JButton btnRemoveProduct;
	private JTextField txtfldSearchInventory;
	private JSpinner sprQuantity;
	private JSlider sldSaleDiscount;
	private JSpinner sprSaleDiscount;
	private JTextField txtfldSum;
	private JLabel lblDiscount;
	private JTextField txtfldDiscount;
	private JLabel lblTotal;
	private JTextField txtfldTotal;
	private JRadioButton rdbtnCash;
	private JRadioButton rdbtnCard;
	private JRadioButton rdbtnVoucher;
	private boolean active;
	private JLabel lblSearchProduct;
	private JLabel lblSaleDiscount;
	private JSeparator separator_1;
	private JLabel lblCustomer;
	private JLabel lblPaymentMethod;
	
	
	@SuppressWarnings("serial")
	public CreateSalePanel() {
		setForeground(Color.DARK_GRAY);
		
		setLayout(null);
		setBackground(new Color(255, 235, 205));
		setBounds(0, 0, 776, 671);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setForeground(Color.LIGHT_GRAY);
		scrollPane.setBackground(new Color(255, 235, 205));
		scrollPane.setBounds(384, 50, 336, 421);
		add(scrollPane);
		
		tblModel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"BARCODE", "NAME", "QUANTITY", "PRICE"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, Integer.class, Double.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
		};
		tblProducts = new JTable(tblModel);
		tblProducts.setRowHeight(28);
		tblProducts.setFont(new Font("Dubai", Font.PLAIN, 14));
		tblProducts.setGridColor(Color.DARK_GRAY);
		tblProducts.setBackground(Color.WHITE);
		tblProducts.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(tblProducts);
		
		txtfldSearchInventory = new JTextField();
		txtfldSearchInventory.setSelectedTextColor(Color.DARK_GRAY);
		txtfldSearchInventory.setForeground(Color.DARK_GRAY);
		txtfldSearchInventory.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtfldSearchInventory.setColumns(10);
		txtfldSearchInventory.setCaretColor(Color.DARK_GRAY);
		txtfldSearchInventory.setBorder(null);
		txtfldSearchInventory.setBackground(new Color(255, 235, 205));
		txtfldSearchInventory.setBounds(70, 77, 200, 30);
		add(txtfldSearchInventory);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBorder(null);
		separator.setBackground(Color.LIGHT_GRAY);
		separator.setBounds(70, 104, 200, 3);
		add(separator);
		
		cmbbxCustomer = new JComboBox<String>();
		cmbbxCustomer.setForeground(Color.DARK_GRAY);
		cmbbxCustomer.setBackground(Color.WHITE);
		cmbbxCustomer.setEnabled(false);
		cmbbxCustomer.setBounds(99, 310, 219, 30);
		add(cmbbxCustomer);
		
		chckbxCustomer = new JCheckBox("");
		chckbxCustomer.setMinimumSize(new Dimension(28, 28));
		chckbxCustomer.setPreferredSize(new Dimension(28, 28));
		chckbxCustomer.setMaximumSize(new Dimension(28, 28));
		chckbxCustomer.setBackground(new Color(255, 235, 205));
		chckbxCustomer.setBounds(70, 310, 21, 30);
		add(chckbxCustomer);
		
		btnAddProduct = new JButton("Add");
		btnAddProduct.setForeground(new Color(0, 128, 0));
		btnAddProduct.setFont(new Font("Dubai", Font.BOLD, 13));
		btnAddProduct.setBorderPainted(false);
		btnAddProduct.setBorder(null);
		btnAddProduct.setBackground(Color.DARK_GRAY);
		btnAddProduct.setBounds(70, 118, 50, 23);
		add(btnAddProduct);
		
		btnRemoveProduct = new JButton("Delete");
		btnRemoveProduct.setForeground(new Color(240, 128, 128));
		btnRemoveProduct.setFont(new Font("Dubai", Font.BOLD, 13));
		btnRemoveProduct.setBorderPainted(false);
		btnRemoveProduct.setBorder(null);
		btnRemoveProduct.setBackground(Color.DARK_GRAY);
		btnRemoveProduct.setBounds(220, 118, 50, 23);
		add(btnRemoveProduct);
		
		sprQuantity = new JSpinner();
		sprQuantity.setFont(new Font("Dubai", Font.PLAIN, 14));
		sprQuantity.setForeground(Color.DARK_GRAY);
		sprQuantity.setBackground(new Color(255, 235, 205));
		sprQuantity.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		sprQuantity.setBounds(276, 77, 42, 30);
		add(sprQuantity);
		
		sldSaleDiscount = new JSlider();
		sldSaleDiscount.setForeground(Color.DARK_GRAY);
		sldSaleDiscount.setBackground(new Color(255, 235, 205));
		sldSaleDiscount.setMaximum(20);
		sldSaleDiscount.setValue(0);
		sldSaleDiscount.setBounds(70, 213, 200, 26);
		add(sldSaleDiscount);
		
		sprSaleDiscount = new JSpinner();
		sprSaleDiscount.setFont(new Font("Dubai", Font.PLAIN, 14));
		sprSaleDiscount.setModel(new SpinnerNumberModel(0.0, 0.0, 100.0, 1.0));
		sprSaleDiscount.setBounds(276, 209, 42, 30);
		add(sprSaleDiscount);
		
		JLabel lblSum = new JLabel("SUM:");
		lblSum.setFont(new Font("Dubai", Font.PLAIN, 14));
		lblSum.setBounds(384, 485, 75, 14);
		add(lblSum);
		
		txtfldSum = new JTextField();
		txtfldSum.setBorder(null);
		txtfldSum.setForeground(Color.DARK_GRAY);
		txtfldSum.setBackground(new Color(255, 235, 205));
		txtfldSum.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtfldSum.setHorizontalAlignment(SwingConstants.RIGHT);
		txtfldSum.setEditable(false);
		txtfldSum.setBounds(634, 482, 86, 20);
		add(txtfldSum);
		txtfldSum.setColumns(10);
		
		lblDiscount = new JLabel("DISCOUNT:");
		lblDiscount.setFont(new Font("Dubai", Font.PLAIN, 14));
		lblDiscount.setBounds(384, 510, 75, 14);
		add(lblDiscount);
		
		txtfldDiscount = new JTextField();
		txtfldDiscount.setForeground(Color.DARK_GRAY);
		txtfldDiscount.setBackground(new Color(255, 235, 205));
		txtfldDiscount.setBorder(null);
		txtfldDiscount.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtfldDiscount.setHorizontalAlignment(SwingConstants.RIGHT);
		txtfldDiscount.setEditable(false);
		txtfldDiscount.setColumns(10);
		txtfldDiscount.setBounds(634, 507, 86, 20);
		add(txtfldDiscount);
		
		lblTotal = new JLabel("TOTAL:");
		lblTotal.setFont(new Font("Dubai", Font.PLAIN, 14));
		lblTotal.setBounds(384, 551, 75, 14);
		add(lblTotal);
		
		txtfldTotal = new JTextField();
		txtfldTotal.setBackground(new Color(255, 235, 205));
		txtfldTotal.setBorder(null);
		txtfldTotal.setForeground(Color.DARK_GRAY);
		txtfldTotal.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtfldTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		txtfldTotal.setEditable(false);
		txtfldTotal.setColumns(10);
		txtfldTotal.setBounds(634, 548, 86, 20);
		add(txtfldTotal);
		
		rdbtnCash = new JRadioButton("CASH");
		rdbtnCash.setFont(new Font("Dubai", Font.PLAIN, 14));
		rdbtnCash.setBackground(new Color(255, 235, 205));
		rdbtnCash.setMnemonic('1');
		rdbtnCash.setBounds(70, 396, 109, 23);
		add(rdbtnCash);
		
		rdbtnCard = new JRadioButton("CARD");
		rdbtnCard.setFont(new Font("Dubai", Font.PLAIN, 14));
		rdbtnCard.setBackground(new Color(255, 235, 205));
		rdbtnCard.setMnemonic('2');
		rdbtnCard.setBounds(70, 422, 109, 23);
		add(rdbtnCard);
		
		rdbtnVoucher = new JRadioButton("VOUCHER");
		rdbtnVoucher.setFont(new Font("Dubai", Font.PLAIN, 14));
		rdbtnVoucher.setBackground(new Color(255, 235, 205));
		rdbtnVoucher.setMnemonic('3');
		rdbtnVoucher.setBounds(70, 448, 109, 23);
		add(rdbtnVoucher);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnCash);
		buttonGroup.add(rdbtnCard);
		buttonGroup.add(rdbtnVoucher);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setForeground(new Color(0, 128, 0));
		btnCreate.setFont(new Font("Dubai", Font.BOLD, 13));
		btnCreate.setBorderPainted(false);
		btnCreate.setBorder(null);
		btnCreate.setBackground(Color.DARK_GRAY);
		btnCreate.setBounds(70, 604, 50, 23);
		add(btnCreate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(new Color(240, 128, 128));
		btnCancel.setFont(new Font("Dubai", Font.BOLD, 13));
		btnCancel.setBorderPainted(false);
		btnCancel.setBorder(null);
		btnCancel.setBackground(Color.DARK_GRAY);
		btnCancel.setBounds(670, 604, 50, 23);
		add(btnCancel);
		
		lblSearchProduct = new JLabel("SEARCH PRODUCT <BARCODE>");
		lblSearchProduct.setForeground(Color.DARK_GRAY);
		lblSearchProduct.setFont(new Font("Dubai", Font.BOLD, 14));
		lblSearchProduct.setBounds(70, 50, 200, 14);
		add(lblSearchProduct);
		
		lblSaleDiscount = new JLabel("SALE DISCOUNT <%>");
		lblSaleDiscount.setForeground(Color.DARK_GRAY);
		lblSaleDiscount.setFont(new Font("Dubai", Font.BOLD, 14));
		lblSaleDiscount.setBounds(70, 188, 200, 14);
		add(lblSaleDiscount);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBorder(null);
		separator_1.setBackground(Color.LIGHT_GRAY);
		separator_1.setBounds(384, 535, 336, 5);
		add(separator_1);
		
		lblCustomer = new JLabel("REGULAR CUSTOMER");
		lblCustomer.setForeground(Color.DARK_GRAY);
		lblCustomer.setFont(new Font("Dubai", Font.BOLD, 14));
		lblCustomer.setBounds(70, 289, 200, 14);
		add(lblCustomer);
		
		lblPaymentMethod = new JLabel("PAYMENT METHOD");
		lblPaymentMethod.setForeground(Color.DARK_GRAY);
		lblPaymentMethod.setFont(new Font("Dubai", Font.BOLD, 14));
		lblPaymentMethod.setBounds(70, 375, 200, 14);
		add(lblPaymentMethod);
		
		chckbxCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!active) return;
				
				boolean selected = chckbxCustomer.isSelected();
				saleCtrl.setCustomerId(selected ? customerCtrl.getCustomerIds()[cmbbxCustomer.getSelectedIndex()] : -1);
				cmbbxCustomer.setEnabled(selected);
			}
		});
		cmbbxCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!active) return;
				
				saleCtrl.setCustomerId(customerCtrl.getCustomerIds()[cmbbxCustomer.getSelectedIndex()]);
			}
		});
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!active) return;
				
				String barcode = txtfldSearchInventory.getText();
				if (barcode.equals("")) {
					notification.errorWindow("Barcode is missing!","Error");
					return;
				}
				if (inventoryCtrl.isBarcodeAvailable(barcode) ) {
					notification.errorWindow("Barcode is invalid!","Error");
					return;
				}
				
				int quantity = (Integer)sprQuantity.getValue();
				int totalStock = inventoryCtrl.getTotalStock(barcode);
				if (quantity > totalStock) {
					notification.errorWindow("Only " + totalStock + " pcs on stock!","Error");
					return;
				}
				txtfldSearchInventory.setText("");
				if (totalStock < 1) {
					notification.errorWindow("Product is out of stock!","Error");
					return;
				}
				sprQuantity.setValue(1);
					
				
				
				for (int j = 0; j < quantity; j++) {
					if (!saleCtrl.addSaleLineItem(barcode)) {
						notification.errorWindow("An error occured!","Error");
						break;
					}
					
					String name = inventoryCtrl.getSaleLineItem(barcode).getName();
					int tempQuantity = 1, pos = tblModel.getRowCount();
					
					for(int i = pos-1; i > -1; i--) {
						if (tblModel.getValueAt(i, 0).equals(barcode)) {
							tempQuantity += (Integer)tblModel.getValueAt(i, 2);
							tblModel.removeRow(i);
							pos = i;
							break;
						}
					}
					
					double price = inventoryCtrl.getPrice(barcode, tempQuantity) * tempQuantity;
					tblModel.insertRow(pos, new Object[]{ barcode, name , tempQuantity, price});
					updatePrices();
				}
			}
		});
		btnRemoveProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!active) return;
				
				String barcode = txtfldSearchInventory.getText();
				if (barcode.equals("")) {
					notification.errorWindow("Barcode is missing!","Error");
					return;
				}
				if (inventoryCtrl.isBarcodeAvailable(barcode) ) {
					notification.errorWindow("Barcode is invalid!","Error");
					return;
				}
				
				int quantity = (Integer)sprQuantity.getValue();
				int totalTempStock = saleCtrl.getTotalTempStock(barcode);
				if (totalTempStock < 1) {
					notification.errorWindow("Product is not on list!","Error");
					return;
				}
				txtfldSearchInventory.setText("");
				if (quantity > totalTempStock) {
					notification.errorWindow("Only " + totalTempStock + " pcs on the list!","Error");
					return;
				}
				sprQuantity.setValue(1);
				
				
				
				for (int j = 0; j < quantity; j++) {
					if (!saleCtrl.removeSaleLineItem(barcode)) {
						notification.errorWindow("An error occured!","Error");
						break;
					}
					
					String name = inventoryCtrl.getSaleLineItem(barcode).getName();
					int tempQuantity = -1, pos = tblModel.getRowCount();
					
					for (int i = pos-1; i > -1; i--) {
						if (tblModel.getValueAt(i, 0).equals(barcode)) {
							tempQuantity += (Integer)tblModel.getValueAt(i, 2);
							tblModel.removeRow(i);
							pos = i;
							break;
						}
					}
					
					if (tempQuantity > 0) {
						double price = inventoryCtrl.getPrice(barcode, tempQuantity) * tempQuantity;
						tblModel.insertRow(pos, new Object[]{ barcode, name , tempQuantity, price});
					}
					updatePrices();
				}
			}
		});
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!active) return;
				
				saleCtrl.setPaymentMethod(buttonGroup.getSelection().getMnemonic()-48);
			}
		};
		rdbtnCash.addActionListener(actionListener);
		rdbtnCard.addActionListener(actionListener);
		rdbtnVoucher.addActionListener(actionListener);
		sldSaleDiscount.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (!active) return;
				
				updateDiscount(sldSaleDiscount.getValue());
			}
		});
		sprSaleDiscount.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (!active) return;
				
				updateDiscount((Double)sprSaleDiscount.getValue());
			}
		});
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!saleCtrl.finishSale()) {
					notification.errorWindow("Required fields haven't been filled!", "Error");
					return;
				}
				
				active = false;
				resetPanel();
				notification.informationWindow("Sale was created!", "Success");
				active = true;
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!saleCtrl.cancelSale()) {
					notification.errorWindow("Required fields haven't been filled!", "Error");
					return;
				}
				
				active = false;
				resetPanel();
				notification.informationWindow("Sale was canceled!", "Success");
				saleCtrl.createSale();
				active = true;
			}
		});
		
		saleCtrl.createSale();
		active = true;
		resetPanel();
	}
	private void updatePrices() {
		DecimalFormat df = new DecimalFormat("#.##");
		txtfldSum.setText(df.format(saleCtrl.getSumTempPrice()));
		txtfldDiscount.setText(df.format(saleCtrl.getDiscountTempPrice()));
		txtfldTotal.setText(df.format(saleCtrl.getTotalTempPrice()));
	}
	private void updateDiscount(double discount) {
		saleCtrl.setDiscount(discount);
		sprSaleDiscount.setValue(discount);
		sldSaleDiscount.setValue((int)discount);
		updatePrices();
	}
	private void resetPanel() {
		chckbxCustomer.setSelected(false);
		cmbbxCustomer.setEnabled(false);
		for (Integer customerId : customerCtrl.getCustomerIds()) {
			CustomerEditor customer = new CustomerEditor(customerId);
			cmbbxCustomer.addItem(customer.getName() + " (" + customer.getId() + ")");
		}
		
		txtfldSearchInventory.setText("");
		sprQuantity.setValue(1);
		tblModel.getDataVector().removeAllElements();
		tblModel.fireTableDataChanged();
		
		sldSaleDiscount.setValue(0);
		sprSaleDiscount.setValue(0.0);
		txtfldSum.setText("0");
		txtfldDiscount.setText("0");
		txtfldTotal.setText("0");
	}
}
