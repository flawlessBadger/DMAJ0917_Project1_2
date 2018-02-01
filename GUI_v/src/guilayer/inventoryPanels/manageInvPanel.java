package guilayer.inventoryPanels;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTabbedPane;
import java.awt.Font;

import guilayer.NotificationWindow;
import guilayer.inventoryPanels.createProductPanel;
import guilayer.layers.MainMenu;

import javax.swing.event.ChangeListener;

import controllayer.InventoryController;

import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.Container;

public class manageInvPanel extends JPanel {

	private createProductPanel createItem = new createProductPanel();
	private createBundlePanel createBundle = new createBundlePanel();
	private createLoanPanel createLoan = new createLoanPanel();
	
	private InventoryController invCtrl = new InventoryController();
	private NotificationWindow notification = new NotificationWindow();
	private JTabbedPane tabbedPane;
	private static JPanel editPanel;
	private JTextField txtBarcode;
	
	private final static Color background = new Color(255, 235, 205);
	private final static Color activated = Color.DARK_GRAY;
	/**
	 * Create the panel.
	 */
	public manageInvPanel() {
		setBackground(background);
		setLayout(null);
		
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setFont(new Font("Dubai", Font.PLAIN, 14));
		tabbedPane.setForeground(activated);
		tabbedPane.setBounds(0, 0, 800, 771);
		add(tabbedPane);
		

		tabbedPane.addTab("Create Product", null, createItem, null);
		tabbedPane.addTab("Create Bundle", null,createBundle,null);
		tabbedPane.addTab("Create Loanable Product", null, createLoan, null);
		
		
		/*
		 * START EDIT PANE
		 */
		editPanel = new JPanel();
		editPanel.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
				changeEditMenu("searchBarcode");
			}
		});
		editPanel.setBackground(background);
		tabbedPane.addTab("Edit", null, editPanel, null);
		editPanel.setLayout(new CardLayout(0, 0));
		
		JPanel barcodePanel = new JPanel();
		barcodePanel.setBackground(background);
		barcodePanel.setLayout(null);
		
		JLabel lblBarcode = new JLabel("BARCODE <PRODUCT, BUNDLE OR LOANABLE PRODUCT>");
		lblBarcode.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarcode.setForeground(activated);
		lblBarcode.setFont(new Font("Dubai", Font.BOLD, 14));
		lblBarcode.setBounds(187, 260, 400, 14);
		barcodePanel.add(lblBarcode);
		
		txtBarcode = new JTextField();
		txtBarcode.setHorizontalAlignment(SwingConstants.CENTER);
		txtBarcode.setSelectedTextColor(activated);
		txtBarcode.setForeground(activated);
		txtBarcode.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtBarcode.setEnabled(true);
		txtBarcode.setColumns(10);
		txtBarcode.setCaretColor(activated);
		txtBarcode.setBorder(null);
		txtBarcode.setBackground(background);
		txtBarcode.setBounds(187, 285, 400, 30);
		barcodePanel.add(txtBarcode);
		
		JSeparator barcodeSeparator = new JSeparator();
		barcodeSeparator.setForeground(activated);
		barcodeSeparator.setBorder(null);
		barcodeSeparator.setBackground(activated);
		barcodeSeparator.setBounds(187, 315, 400, 3);
		barcodePanel.add(barcodeSeparator);
		
		JButton btnCheck = new JButton("Check Barcode");
		btnCheck.setForeground(new Color(30, 144, 255));
		btnCheck.setFont(new Font("Dubai", Font.BOLD, 13));
		btnCheck.setBorderPainted(false);
		btnCheck.setBorder(null);
		btnCheck.setBackground(activated);
		btnCheck.setBounds(337, 330, 100, 23);
		barcodePanel.add(btnCheck);
		
		editPanel.add(barcodePanel, "searchBarcode");
		changeEditMenu("searchBarcode");
		
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!invCtrl.isBarcodeAvailable(getBarcode())) {
					if(invCtrl.isValidItem(getBarcode())) {
						editProduct editProduct = new editProduct(getBarcode());
						editPanel.add(editProduct,"productEdit");
						changeEditMenu("productEdit");
					}
				}
			}
		});
		/*
		 * END EDIT PANE
		 */
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Restock", null, panel_4, null);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Remove", null, panel_5, null);
		
		
	}
	
	private String getBarcode() {
		return this.txtBarcode.getText().replaceAll("\\s","");
	}

	public static void changeEditMenu(String menuName) {
	    CardLayout cl = (CardLayout) editPanel.getLayout();
	    cl.show(editPanel, menuName);
	}
}
