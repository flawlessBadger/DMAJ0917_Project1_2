package guilayer.layers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import guilayer.inventoryPanels.manageInvPanel;
import guilayer.salePanels.ManageSalePanel;
import guilayer.customerPanels.manageCusPanel;
import guilayer.employeePanels.EmployeeView;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;

public class MainMenu extends JPanel {
	
	private JPanel isActivePanel = new JPanel();
	private JPanel leftPanel = new JPanel();
	private String activePanel = "manageInv";
	private CardLayout cardLayout;
	private JPanel cardPanel;
	
	private manageInvPanel inventoryManager = new manageInvPanel();
	private EmployeeView employeeView = new EmployeeView();
	private manageCusPanel customerManager = new manageCusPanel();
	private ManageSalePanel manageSale = new ManageSalePanel();
	
	/**
	 * Create the panel.
	 */
	public MainMenu() {
		
		setLayout(null);
		

		
		JPanel mainPane = new JPanel();
		mainPane.setBounds(0, 0, 1000, 771);
		add(mainPane);
		mainPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setVisible(false);
		menuBar.setBounds(0, 0, 1000, 21);
		mainPane.add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);
		cardPanel.setBounds(200, 0, 800, 771);
		mainPane.add(cardPanel);
		cardPanel.add(inventoryManager, "inventoryManager");
		cardPanel.add(employeeView, "employeeView");
		cardPanel.add(customerManager,"customerManager");
		cardPanel.add(manageSale,"manageSale");
		employeeView.setBackground(new Color(255, 235, 205));
		
		
		
		//left Panel
		leftPanel.setBackground(Color.DARK_GRAY);
		leftPanel.setBounds(0, 0, 200, 771);
		mainPane.add(leftPanel);
		leftPanel.setLayout(null);
		
		JPanel manageInv = new JPanel();
		manageInv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				changeMenuState(manageInv);
				cardLayout.show(cardPanel,"inventoryManager");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				manageInv.getComponent(0).setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(manageInv.getName() != activePanel) {
					manageInv.getComponent(0).setForeground(Color.gray);
				}
			}
		});
		
		isActivePanel.setBounds(0, 262, 10, 35);
		leftPanel.add(isActivePanel);
		isActivePanel.setBackground(new Color(255, 235, 205));
		manageInv.setName("manageInv");
		manageInv.setBackground(Color.DARK_GRAY);
		manageInv.setBounds(0, 245, 200, 70);
		leftPanel.add(manageInv);
		manageInv.setLayout(null);
		
		JLabel lblInv = new JLabel("Manage Inventory");
		lblInv.setForeground(Color.WHITE);
		lblInv.setBounds(25, 23, 154, 24);
		lblInv.setFont(new Font("Dubai", Font.BOLD, 14));
		manageInv.add(lblInv);

		JPanel manageEmp = new JPanel();
		manageEmp.setName("manageEmp");
		manageEmp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				changeMenuState(manageEmp);
				cardLayout.show(cardPanel,"employeeView");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				manageEmp.getComponent(0).setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(manageEmp.getName() != activePanel) {
					manageEmp.getComponent(0).setForeground(Color.gray);
				}
			}
		});
		manageEmp.setLayout(null);
		manageEmp.setBackground(Color.DARK_GRAY);
		manageEmp.setBounds(0, 315, 200, 70);
		leftPanel.add(manageEmp);
		
		JLabel lblEmp = new JLabel("Manage Employee");
		lblEmp.setForeground(Color.GRAY);
		lblEmp.setFont(new Font("Dubai", Font.BOLD, 14));
		lblEmp.setBounds(25, 23, 154, 24);
		manageEmp.add(lblEmp);
		
		JPanel manageCus = new JPanel();
		manageCus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeMenuState(manageCus);
				cardLayout.show(cardPanel,"customerManager");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				manageCus.getComponent(0).setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(manageCus.getName() != activePanel) {
					manageCus.getComponent(0).setForeground(Color.gray);
				}
			}
		});
		manageCus.setName("manageCus");
		manageCus.setLayout(null);
		manageCus.setBackground(Color.DARK_GRAY);
		manageCus.setBounds(0, 385, 200, 70);
		leftPanel.add(manageCus);
		
		JLabel lblCus = new JLabel("Manage Customer");
		lblCus.setForeground(Color.GRAY);
		lblCus.setFont(new Font("Dubai", Font.BOLD, 14));
		lblCus.setBounds(25, 23, 154, 24);
		manageCus.add(lblCus);
		
		JPanel createSal = new JPanel();
		createSal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeMenuState(createSal);
				cardLayout.show(manageSale,"manageSale");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				createSal.getComponent(0).setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(createSal.getName() != activePanel) {
					createSal.getComponent(0).setForeground(Color.gray);
				}
			}
		});
		createSal.setName("manageSal");
		createSal.setLayout(null);
		createSal.setBackground(Color.DARK_GRAY);
		createSal.setBounds(0, 455, 200, 70);
		leftPanel.add(createSal);
		
		JLabel lblSal = new JLabel("Create Sale");
		lblSal.setForeground(Color.GRAY);
		lblSal.setFont(new Font("Dubai", Font.BOLD, 14));
		lblSal.setBounds(25, 23, 111, 24);
		createSal.add(lblSal);
		

		
		inventoryManager.setAlignmentY(Component.TOP_ALIGNMENT);
		inventoryManager.setAlignmentX(Component.LEFT_ALIGNMENT);
		inventoryManager.setBackground(new Color(255, 235, 205));
		
		JPanel midPanel = new JPanel();
		midPanel.setBounds(0, 0, 795, 738);
		mainPane.add(midPanel);
		midPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		midPanel.setAlignmentX(0.0f);
		midPanel.setBorder(null);
		midPanel.setBackground(new Color(255, 235, 205));
		midPanel.setLayout(new CardLayout(0, 0));
	 
		
	}
	
	private void changeMenuState(JPanel setActive) {
		
		for(int i = 0; i < leftPanel.getComponentCount(); i++) {
			if(((JPanel)leftPanel.getComponent(i)).getName() == activePanel) {
				((JPanel) leftPanel.getComponent(i)).getComponent(0).setForeground(Color.GRAY);
			}
		}
		
		((JLabel) setActive.getComponent(0)).setForeground(Color.WHITE);
		isActivePanel.setLocation(0, setActive.getY()+17);
		activePanel = setActive.getName();
	};
}
