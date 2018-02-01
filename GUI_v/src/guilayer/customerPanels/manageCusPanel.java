package guilayer.customerPanels;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTabbedPane;
import java.awt.Font;

import guilayer.NotificationWindow;
import guilayer.inventoryPanels.createProductPanel;
import guilayer.layers.MainMenu;

import javax.swing.event.ChangeListener;

import controllayer.InventoryController;

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
import javax.swing.JTextPane;
import java.awt.Panel;

public class manageCusPanel extends JPanel {
	
	private InventoryController invCtrl = new InventoryController();
	private NotificationWindow notification = new NotificationWindow();
	private JTabbedPane tabbedPane;
	
	private final static Color background = new Color(255, 235, 205);
	private final static Color activated = Color.DARK_GRAY;
	
	private editCustomer customerEdit = new editCustomer();
	private createCustomer customerCreate = new createCustomer();
	private listCustomer listCustomer = new listCustomer();
	/**
	 * Create the panel.
	 */
	public manageCusPanel() {
		setBackground(background);
		setLayout(null);
		
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setFont(new Font("Dubai", Font.PLAIN, 14));
		tabbedPane.setForeground(activated);
		tabbedPane.setBounds(0, 0, 800, 771);
		add(tabbedPane);
		
		tabbedPane.addTab("Create Customer", null, customerCreate, null);
		
		tabbedPane.addTab("Edit Customer", null, customerEdit, null);
		
		tabbedPane.addTab("List Customer", null, listCustomer, null);
		
		
	}
}
