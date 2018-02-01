package guilayer.salePanels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import guilayer.NotificationWindow;

public class ManageSalePanel extends JPanel {

	private CreateSalePanel createSalePanel = new CreateSalePanel();
	private JTabbedPane tabbedPane;
	
	public ManageSalePanel() {
		
		setBackground(new Color(255, 235, 205));
		setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setFont(new Font("Dubai", Font.PLAIN, 14));
		tabbedPane.setForeground(Color.DARK_GRAY);
		tabbedPane.setBounds(10, 45, 780, 715);
		add(tabbedPane);
		
		tabbedPane.addTab("Create sale", createSalePanel);
	}

}
